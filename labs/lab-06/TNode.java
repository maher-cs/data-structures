public class TNode<E> {

    // class attributes
    private E data;
    private TNode<E> right;
    private TNode<E> left;

    // default constructor
    public TNode() {
        this.data = null;
        this.right = null;
        this.left = null;
    }

    // constructor with data parameter
    public TNode(E data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    // constructor with data and right node parameter
    public TNode(E data, TNode<E> left, TNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
        
    }

    // ## setters
    public void setData(E data) {
        this.data = data;
    }

    public void setRight(TNode<E> right) {
        this.right = right;
    }

    public void setLeft(TNode<E> left) {
        this.left = left;
    }

    public void setLeftRight(TNode<E> left, TNode<E> right) {
        this.left = left;
        this.right = right;
    }

    // ## getters
    public E getData() {
        return this.data;
    }

    public TNode<E> getRight() {
        return this.right;
    }

    public TNode<E> getLeft() {
        return this.left;
    }

    // to string
    @Override
    public String toString() {
        return "{" + this.getData() + "}";
    }
}