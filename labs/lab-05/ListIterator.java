public class ListIterator {
    private Node<Integer> current;
    private Node<Integer> previous;
    private LinkList<Integer> ourList;

    public ListIterator(LinkList<Integer> list) {
        ourList = list;
        reset();
    }

    public void reset() {
        current = ourList.getFirst();
        previous = null;
    }

    public boolean atEnd() {
        return (current.getNext() == null);
    }

    public void nextLink() {
        previous = current;
        current = current.getNext();
    }

    public Node<Integer> getCurrent() {
        return current;
    }

    public void insertAfter(int dd) {
        Node<Integer> newLink = new Node<Integer>(dd);

        if (ourList.isEmpty()) {
            ourList.setFirst(newLink);
            current = newLink;
        } else {
            newLink.setNext(current.getNext());
            current.setNext(newLink);
            nextLink();
        }
    }

    public void insertBefore(int dd) {
        Node<Integer> newLink = new Node<Integer>(dd);

        if (previous == null) {
            newLink.setNext(ourList.getFirst());
            ourList.setFirst(newLink);
            reset();
        } else {
            newLink.setNext(previous.getNext());
            previous.setNext(newLink);
            current = newLink;
        }
    }

    public int deleteCurrent() {
        int value = current.getData();
        if (previous == null) {
            ourList.setFirst(current.getNext());
            reset();
        } else {
            previous.setNext(current.getNext());
            if (atEnd())
                reset();
            else
                current = current.getNext();
        }
        return value;
    }

}