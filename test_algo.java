import java.util.Random;
public class test_algo {
    public static void main(String[] args) {
        System.out.println( base3(175,-1));

        int[] t = {1,2,2,2,4,4,5,5};


        int[] monTableau = creerTableauAleatoire();
        // Affichage des valeurs
//        for (int val : monTableau) {
//            System.out.print(val + " ")
//        }
        System.out.println(countPlateaus(t));

//        System.out.println();
//        insertionSort(monTableau);
//        shellSort(monTableau);
    }

//    private static void amorce(int t[]){
//
//    }

    private static int call(int t[], int lastDigit, int nb){
        if(t.length == 1){
            if (t[0] == lastDigit){
                nb++;
            }
            return nb;
        }

        int[] copie = new int[t.length - 1];
        System.arraycopy(t, 0, copie, 0, 1);
        System.arraycopy(t, 2, copie, 1, t.length - 2);

        if(t[0] == lastDigit){
            nb++;
        }

        return call(copie, t[0], nb);
    }


    public static int[] creerTableauAleatoire() {
        int[] tableau = new int[100];
        Random rand = new Random();

        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = rand.nextInt(100); // Valeurs entre 0 et 99
        }

        return tableau;
    }

    private static void insertionSort(int t[]){
        System.out.println("insertionSort");
        for (int i = 1; i < t.length; i++) {
            int key = t[i];
            int j = i - 1;

            // Déplace les éléments de t[0..i-1] qui sont plus grands que key
            // vers une position en avant de leur position actuelle
            while (j >= 0 && t[j] > key) {
                t[j + 1] = t[j];
                j = j - 1;
            }
            t[j + 1] = key;
        }
        for (int val : t) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    private static void shellSort(int t[]){
        System.out.println("shellSort");
        int k = t.length/2; // comment trouver le K ?
        while (k > 0){
            for (int i = 0; i < t.length; i++) {
                if(i+k <= t.length-1 && t[i] > t[i+k]){
                    int tmp = t[i+k];
                    t[i+k] = t[i];
                    t[i] = tmp;
                }
            }
            k--;
        }
        for (int val : t) {
            System.out.print(val + " ");
        }
        System.out.println();
    }


    public static String base3(int num, int res){
        if(num < 3){
            return (int) Math.floor(num%3)+"";
        }else{
            return base3((int)Math.floor(num/3), num%3) +""+ num%3;
        }
    }


    public static int countPlateaus(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return countPlateausRecursive(array, 0, array.length - 1);
    }

    // Méthode récursive avec 3 paramètres
    private static int countPlateausRecursive(int[] array, int start, int end) {
        // Cas de base: un seul élément compte pour 1 plateau
        if (start == end) {
            return 1;
        }

        int mid = (start + end) / 2;

        // Diviser le problème en deux sous-problèmes
        int leftCount = countPlateausRecursive(array, start, mid);
        int rightCount = countPlateausRecursive(array, mid + 1, end);

        // Combiner les résultats
        int mergeCount = 0;
        if (array[mid] == array[mid + 1]) {
            // Si les éléments au milieu sont égaux, on a potentiellement fusionné deux plateaux
            // On vérifie si c'est vraiment une fusion (pas déjà comptée)
            // On compte 1 si les deux côtés étaient des plateaux séparés
            boolean leftIsPlateau = (mid == start) || (array[mid] != array[mid - 1]);
            boolean rightIsPlateau = (mid + 1 == end) || (array[mid + 1] != array[mid + 2]);

            if (leftIsPlateau && rightIsPlateau) {
                mergeCount = -1; // On avait compté deux plateaux séparés qui ne font qu'un
            }
        }

        return leftCount + rightCount + mergeCount;
    }


}
