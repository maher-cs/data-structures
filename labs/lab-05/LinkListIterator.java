public class LinkListIterator<E> implements Iterator<E> {

    // class attributes
    private Node<E> current;
    private LinkList<E> list;

    // constructor that recieve list as parameter
    public LinkListIterator(LinkList<E> list) {
        this.list = list;
        this.reset();
    }

    // reset iterator to the first element
    @Override
    public void reset() {
        this.current = this.list.getFirst();
    }
    
    // go to next item
    @Override
    public E next() {
        E data = this.current.getData();
        this.current = this.current.getNext();
        return data;
    }

    // return the current item
    @Override
    public E getCurrent() {
        return this.current.getData();
    }

    // return false if current item is the last one
    @Override
    public boolean hasNext() {
        return this.current != null;
    }

}