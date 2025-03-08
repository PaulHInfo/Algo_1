package s03;

// When isFirst(), it is forbidden to call goToPrev()
// When isLast(),  it is forbidden to call goToNext()
// When isLast(),  it is forbidden to call consultAfter(), or removeAfter()
// For an empty list, isLast()==isFirst()==true
// For a fresh ListItr, isFirst()==true
// Using multiple iterators on the same list is allowed only
// if none of them modifies the list

public class ListItr {
    final List list;
    ListNode pred, succ;

    // ----------------------------------------------------------
    public ListItr(List anyList) {
        list = anyList;
        goToFirst();
    }

    public void insertAfter(int e) {
        //TODO
        ListNode tmp = new ListNode(e, pred, succ);
        if (isFirst())
            //check si 1er
            list.first = tmp;
        else
            pred.next = tmp;

        if (isLast())
            //check si dernier
            list.last = tmp;
        else
            succ.prev = tmp;
        succ = tmp;
        list.size++;

    }

    public void removeAfter() {
        // TODO
        boolean isBeforeTheLast = (succ.next == null);
        if (!isFirst() && !isBeforeTheLast) {
            // check si entre 2 elt mais sans etre au 1er ni au dernier
            succ = succ.next;
            succ.prev = pred;
            pred.next = succ;
        }

        if(isBeforeTheLast) {
            //check si dernière position
            if(list.size > 1) {
                //check si seulement 1 elt dans la liste
                pred.next = null;
            }
            succ = null;
            list.last = pred;
        }
        if (isFirst()) {
            //check s1 1ère position
            if(list.size > 1) {
                //check si seulement 1 elt dans la liste
                succ = succ.next;
                succ.prev = null;
            }
            list.first = succ;
        }
        list.size--;
    }


    public int consultAfter() {
        return succ.elt;
    }

    public void goToNext() {
        pred = succ;
        succ = succ.next;
    }

    public void goToPrev() {
        succ = pred;
        pred = pred.prev;
    }

    public void goToFirst() {
        succ = list.first;
        pred = null;
    }

    public void goToLast() {
        pred = list.last;
        succ = null;
    }

    public boolean isFirst() {
        return pred == null;
    }

    public boolean isLast() {
        return succ == null;
    }
}

