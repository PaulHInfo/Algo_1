package s03;

public class List {
    ListNode first, last;
    int size;

    public List() {
        size = 0;
        this.first = null;
        this.last = null;
    }

    public int size() {
      return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

}
