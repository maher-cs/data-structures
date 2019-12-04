public class StackArray<E> {

    // class attributes
    private E[] array;
    private int pointer;

    // default constructor with init size parameter
    public StackArray(int size) {
        this.array = (E[]) new Object[size];
        this.pointer = -1;
    }

    // push new element to the head of the stack
    // return true if successfully pushed
    public boolean push(E element) {
        if(this.isFull()) {
            return false;
        }
        this.array[++this.pointer] = element;
        return true;
    }

    // pop the element on the top
    // return null if the stack is empty
    public E pop() {
        if(this.isEmpty()) {
            return null;
        }
        E element = this.array[this.pointer];
        this.array[this.pointer--] = null;
        return element;
    }

    public E peek() {
        if(this.isEmpty()) {
            return null;
        }
        return this.array[this.pointer];
    }

    // check if the stack is empty
    // WARNING: overriding this method will affect 
    //  some other methods [pop, peek]
    public boolean isEmpty(){
        return (this.pointer == -1);
    } 

    // check if the stack is empty
    // WARNING: overriding this method will affect 
    //  some other methods [push]
    public boolean isFull() {
        return (this.pointer == this.array.length - 1);
    }

    // toString method
    @Override
    public String toString() {
        String output = "";
        for(int i = 0; i <= this.pointer; i++) {
            output += " " + this.array[i].toString();
        }
        output = "[" + output + " <= ]";
        return output;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof StackArray)){
            return false;
        }
        StackArray<E> other = (StackArray<E>) obj;
        if(this.pointer != other.pointer) {
            return false;
        }
        for(int i = 0; i <= this.pointer; i++) {
            if(!this.array[i].equals(other.array[i])) {
                return false;
            }
        }
        return true;
    }
}