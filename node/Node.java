package node;

public class Node {
    Node next;
    int elt;

    public Node(int elt, Node next) {
        this.elt = elt;
        this.next = next;
    }
}
