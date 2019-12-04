public class StackLinkList<E> {

    // private attributes
    private FirstLastLinkList<E> list;

     // default constructor
     public StackLinkList() {
        this.list = new FirstLastLinkList<E>();
    }

    // push new element to the head of the stack
    // return true if successfully pushed
    public boolean push(E element) {
        this.list.insertFirst(element);
        return true;
    }

    // pop the element on the top
    // return null if the stack is empty
    public E pop() {
        if(this.isEmpty()) {
            return null;
        }
        E element = this.list.getFirst().getData();
        this.list.deleteFirst();
        return element;
    }

    public E peek() {
        if(this.isEmpty()) {
            return null;
        }
        return this.list.getFirst().getData();
    }

    // check if the stack is empty
    // WARNING: overriding this method will affect 
    //  some other methods [pop, peek]
    public boolean isEmpty(){
        return (this.list.size() == 0);
    } 

    // toString method
    @Override
    public String toString() {
        String output = this.list.toString();
        output = "[" + output + " <= ]";
        return output;
    }
}