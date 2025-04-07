package node;

public class main {
    static Node a;
    static Node b;

    public static void main(String[] args) {
        creatNode();
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
    }
}
