package node;

public class main {
    static Node a;
    static Node b;

    public static void main(String[] args) {
        creatNode();
        show();
        zip();
        show();
    }

    public static void creatNode(){
        b = new Node(3,new Node(4,null));
        Node n1 = new Node(7,null);
        Node n2 = new Node(6,n1);
        Node n3 = new Node(9,n2);
        a = new Node(5, n3);
    }

    public static void show() {
        //liste a
        Node n = a;

        while (true){
            System.out.print(n.elt);
            n = n.next;
            if(n == null){
                break;
            }
        }
        System.out.println();
        n = b;
        while (true){
            System.out.print(n.elt);
            n = n.next;
            if(n == null){
                break;
            }
        }
        System.out.println();
    }

    public static void zip() {
        if (a != null){
            int i = 0;
            Node tmp_a = a.next;
            Node tmp_b = b.next;
            while (true){
                b.next = tmp_a;
                a.next = b;
                a = a.next;
                b = b.next;
                i++;
                if(tmp_a.next != null && tmp_b.next != null){
                    tmp_a = tmp_a.next;
                    tmp_b = tmp_b.next;
                }else{
                    break;
                }
            }
        }
    }

}
