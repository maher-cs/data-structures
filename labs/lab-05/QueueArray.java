public class QueueArray<E> {

    // class attributes
    private E[] array;
    private int head;
    private int tail;

    // default constructor with init size parameter
    public QueueArray(int size) {
        this.array = (E[]) new Object[size];
        this.head = -1;
        this.tail = -1;
    }

    // push new element to the head of the stack
    // return true if successfully pushed
    public boolean enqueue(E element) {
        if(this.isFull()) {
            return false;
        }
        
        this.array[index(++this.head)] = element;
        return true;
    }

    // pop the element on the top
    // return null if the stack is empty
    public E dequeue() {
        if(this.isEmpty()) {
            return null;
        }
        E element = this.array[index(++this.tail)];
        this.array[index(this.tail)] = null;
        return element;
    }

    public E peek() {
        if(this.isEmpty()) {
            return null;
        }
        return this.array[index(this.tail)];
    }

    // check if the stack is empty
    // WARNING: overriding this method will affect 
    //  some other methods [pop, peek]
    public boolean isEmpty(){
        return (this.head == this.tail);
    } 

    // check if the stack is empty
    // WARNING: overriding this method will affect 
    //  some other methods [push]
    public boolean isFull() {
        return index(this.head + 1) == index(this.tail);
    }

    // toString method
    @Override
    public String toString() {
        String output = "";
        for(int i = index(this.tail + 1); i != index(this.head + 1) ; i++) {
            output += " " + this.array[i].toString();
        }
        output = "[ => " + output + " ]";
        return output;
    }


    private int index(int i) {
        return i % this.array.length;
    }
}