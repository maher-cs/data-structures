public class QueueLinkList<E> {

    // class attributes
    private FirstLastLinkList<E> list;

    // default constructor with init size parameter
    public QueueLinkList() {
        this.list = new FirstLastLinkList<E>();
    }

    // push new element to the head of the stack
    // return true if successfully pushed
    public boolean enqueue(E element) {
        this.list.insertLast(element);
        return true;
    }

    // pop the element on the top
    // return null if the stack is empty
    public E dequeue() {
        if(this.isEmpty()) {
            return null;
        }
        return this.list.deleteFirst().getData();
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
        return (this.list.isEmpty());
    } 

    // toString method
    @Override
    public String toString() {
        String output = this.list.toString();
        output = "[ => " + output + " ]";
        return output;
    }
}