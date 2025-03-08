package s03;

public class AmStramGram {

    // "Josephus problem" with persons numbered 1..n
    // Removes every k-th persons (ie skip k-1 persons)
    // PRE: n>=1, k>=1
    // RETURNS: the survivor
    // Example: n=5, k=2:
    //   '12345 → 1'2345 → 1'(2)345 → 1'345
    //          → 13'45  → 13'(4)5  → 13'5
    //          → 135'   → '(1)35   → '35
    //          → 3'5    → 3'(5)    → 3'  ===> survivor: 3
    public static int winnerAmStramGram(int n, int k) {
        List list = new List();
        ListItr li = new ListItr(list);
        for (int i = 0; i < n; i++) {
            li.insertAfter(i + 1);
            li.goToNext();
        }

        if (list.size == 1) {
            return list.first.elt;
        }
        System.out.println(list.size + " joueur on été ajouté à la partie");
        int i = 1;
        int w = -1;
        System.out.println("N : " + n + "\nK : " + k);
        li.goToFirst();
        if(n==3){
            System.out.println("test");
        }

        while (n > 1) {
            boolean asRemove = false;
            if (li.succ == null) {
                // si on est en dernière position
                li.goToFirst();
            }
            if (i % k == 0) {
                // i est le k ième
                System.out.println("remove");
                li.removeAfter();
                asRemove = true;
                n--;
            }
            if(n == 1) {
                // si il ne reste que 1 elt
                w = list.first.elt;
                break;
            }
            if (li.succ != null && !asRemove) {
                // on ne bouge pas si on a remove (car on a déjà bouger)
                li.goToNext();
            }
            i++;
        }

        System.out.println(w+" à gagner la partie");
        return w;
    }

    // ----------------------------------------------------------
    static void josephusDemo(int n, int k) {
        System.out.printf("n=%d, k=%d : Survivor is %d\n", n, k, winnerAmStramGram(n, k));
    }

    public static void main(String[] args) {
        int n = 5, k = 2;
        if (args.length == 2) {
            n = Integer.parseInt(args[0]);
            k = Integer.parseInt(args[1]);
        }
        josephusDemo(n, k);
    }
}
