public class CNode<E> {

    // class attributes
    private E data;
    private CNode<E> next;
    private CNode<E> prev;

    // default constructor
    public CNode() {
        this.data = null;
        this.next = null;
        this.prev = null;
    }

    // constructor with data parameter
    public CNode(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    // constructor with data and next node parameter
    public CNode(E data, CNode<E> prev, CNode<E> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
        
    }

    // ## setters
    public void setData(E data) {
        this.data = data;
    }

    public void setNext(CNode<E> next) {
        this.next = next;
    }

    public void setPrev(CNode<E> prev) {
        this.prev = prev;
    }

    public void setPrevNext(CNode<E> prev, CNode<E> next) {
        this.prev = prev;
        this.next = next;
    }

    // ## getters
    public E getData() {
        return this.data;
    }

    public CNode<E> getNext() {
        return this.next;
    }

    public CNode<E> getPrev() {
        return this.prev;
    }

    // to string
    @Override
    public String toString() {
        return "{" + this.getData() + "}";
    }
}