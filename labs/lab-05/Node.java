public class Node<T> {

    // class attributes
    private E data;
    private Node<E> next;

    // default constructor
    public Node() {
        this.data = null;
        this.next = null;
    }

    // constructor with data parameter
    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    // constructor with data and next node parameter
    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    // ## setters
    public void setData(E data) {
        this.data = data;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    // ## getters
    public E getData() {
        return this.data;
    }

    public Node<E> getNext() {
        return this.next;
    }
}