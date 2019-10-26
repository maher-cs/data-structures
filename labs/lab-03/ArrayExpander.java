public class ArrayExpander<E extends Comparable<E>> {

    // class attributes
    private E[] array;
    private int nElements;

    // constructor with initial size of array parameter
    public ArrayExpander(int initialSize) {
        this.array = (E[]) new Comparable[initialSize];
        this.nElements = 0;
    }

    // constructor with values
    // WARNING: overriding insertList() method may change
    // the behavior of this method
    public ArrayExpander(E... elements) {
        int initialSize = (elements.length * 2);
        this.array = (E[]) new Comparable[initialSize];
        this.insertList(elements);
    }

    // print the elements
    // WARNING: overriding toString() method may change
    // the behavior of this method
    public void display() {
        System.out.println(this.toString());
    }

    // toString method
    // WARNING: overriding this method in a child class may change
    // some methods behavior [display()]
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < this.nElements; i++) {
            output += " " + this.array[i].toString();
        }
        output = "[" + output + "]";
        return output;
    }

    // return array of elements
    public E[] toArray() {
        E[] output = (E[]) new Comparable[this.nElements];
        for (int i = 0; i < this.nElements; i++) {
            output[i] = this.array[i];
        }
        return output;
    }

    // return the size (number of elements)
    public int size() {
        return this.nElements;
    }

    // clear the array
    public void clear() {
        this.nElements = 0;
        this.array = (E[]) new Comparable[10];
    }

    // insert new element
    // WARNING: overriding insertAt() method may change
    // the behavior of this method
    // WARNING: overriding this method in a child class may change
    // some methods behavior [insertList()]
    public int insert(E element) {
        boolean isInserted = insertAt(this.nElements, element);
        if (!isInserted)
            return -1;

        return this.nElements;
    }

    // insert list method and return last index
    // WARNING: overriding insert() method may change
    // the behavior of this method
    // WARNING: overriding this method in a child class may change
    // some methods behavior [constructor(list)]
    public int insertList(E... elements) {
        for (E e : elements) {
            this.insert(e);
        }
        return this.nElements - 1;
    }

    // insert element at index
    // WARNING: overriding this method in a child class may change
    // some methods behavior [insert(), insertFirst()]
    public boolean insertAt(int index, E element) {
        if (!this.isValidIndex(index) || !thereIsCapacity(this.nElements))
            return false;

        this.shiftRight(index, 1);
        this.array[index] = element;
        this.nElements++;
        return true;
    }

    // insert element at position 0
    // WARNING: overriding insertAt() method may change
    // the behavior of this method
    public boolean insertFirst(E element) {
        return insertAt(0, element);
    }

    // find method: return index of given element
    // WARNING: overriding this method in a child class may change
    // some methods behavior [remove()]
    public int find(E element) {
        return this.binarySearch(element);
    }

    // find method: return index of given element
    public int[] findAll(E element) {
        int[] indexes = new int[this.nElements + 1];
        int indexesCounter = 0;
        for (int i = 0; i < this.nElements; i++) {
            if (element.equals(this.array[i]))
                indexes[indexesCounter++] = i;
        }
        indexes[indexesCounter] = -1;
        return indexes;
    }

    // findLast method: return last index of given element
    public int findLast(E element) {
        for (int i = this.nElements - 1; i >= 0; i--) {
            if (element.equals(this.array[i]))
                return i;
        }
        return -1;
    }

    // get method: return element for given index
    public E get(int index) {
        if (!isValidIndex(index) || index >= this.nElements)
            return null;
        return this.array[index];
    }

    // removeAt: remove element at given index
    // WARNING: overriding this method in a child class may change
    // some methods behavior [remove()]
    public E removeAt(int index) {
        if (!isValidIndex(index) || index >= this.nElements)
            return null;

        E element = this.array[index];
        this.shiftLeft(index + 1, 1);
        this.nElements--;
        return element;
    }

    // remove: remove first given element
    // WARNING: overriding [removeAt(), find()] method may change
    // the behavior of this method
    public E remove(E element) {
        return this.removeAt(this.find(element));
    }

    // removeLast: remove last given element
    // WARNING: overriding [removeAt(), findLast()] method may change
    // the behavior of this method
    public E removeLast(E element) {
        return this.removeAt(this.findLast(element));
    }

    // removeAll: remove all elements match given element
    // WARNING: overriding [removeAt(), find()] method may change
    // the behavior of this method
    public int removeAll(E element) {
        int counter = 0;
        int index;
        while ((index = this.find(element)) != -1) {
            this.removeAt(index);
            counter++;
        }
        return counter;
    }

    // remove duplicates: keep the last occure
    // WARNING: overriding [removeAt(), find()] method may change
    // the behavior of this method
    public int removeDuplicates() {
        int counter = 0;
        for (int i = 0; i < this.nElements; i++) {
            for (int j = 0; j < i; j++) {
                if (this.array[i].equals(this.array[j])) {
                    this.removeAt(j);
                    counter++;
                    j--;
                    i--;
                }
            }
        }
        return counter;
    }

    // test set method: set value at given position and return old value
    public E set(int index, E element) {
        if (!isValidIndex(index))
            return null;
        E oldElement = this.get(index);
        this.array[index] = element;
        return oldElement;
    }

    // insert element ordered
    public void insertOrdered(E value) {
        int j;
        for (j = 0; j < this.nElements; j++)
            if (this.array[j].compareTo(value) > 0)
                break;
        for (int k = this.nElements; k > j; k--)
            this.array[k] = this.array[k - 1];
        this.array[j] = value;
        this.nElements++;
    }

    // binary search
    public int binarySearch(E searchKey) {
        this.selectionSort();
        int left = 0;
        int right = this.nElements-1;
        while(left <= right) {
            int pivot = (left+right)/2;
            // System.out.println(searchKey + ": left="+left + ", right="+right+", pivot="+pivot);
            int comp = this.array[pivot].compareTo(searchKey);
            if(comp == 0) {
                return pivot;
            } else if(comp < 0) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return -1;
    }
    

    // bubble sort
    public void bubbleSort() {
        for (int i = 0; i < nElements-1; i++) {
            for (int j = 0; j < nElements-1-i; j++) {
                if(this.array[j].compareTo(array[j+1]) > 0) {
                    E temp = this.array[j];
                    this.array[j] = this.array[j+1];
                    this.array[j+1] = temp;
                }
            }
        }
    }

    // selection sort
    public void selectionSort() {
        for (int i = 0; i < nElements; i++) {
            E min = this.array[i];
            int minIndex = i;
            for (int j = i; j < nElements; j++) {
                if(this.array[j].compareTo(min) < 0) {
                    min = this.array[j];
                    minIndex = j;
                }
            }
            E temp = this.array[i];
            this.array[i] = min;
            this.array[minIndex] = temp;
        }
    }

    // insertion sort
    public void insertionSort() {
        for(int i = 0; i < this.nElements; i++)
            this.insertOrdered(this.removeAt(i));
    }

    // ## private methods ##
    // check if there is capacity
    private boolean thereIsCapacity(int index) {
        if (index >= this.array.length) {
            // System.err.println("no capacity!");
            ensureCapacity();
        }
        return true;
    }

    private void ensureCapacity() {
        E[] newArray = (E[]) new Comparable[this.array.length*2];
        for(int i = 0; i < this.nElements; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    // check if index is valid and connected
    private boolean isValidIndex(int index) {
        if (index > this.nElements || index < 0) {
            // System.err.println("invalid index!");
            return false;
        }
        return true;
    }

    // shift the elements to the right
    private boolean shiftRight(int start, int shiftAmount) {
        int lastIndex = this.nElements - 1 + shiftAmount;
        if (!thereIsCapacity(lastIndex) || shiftAmount < 1)
            return false;

        for (int i = lastIndex; i > start + shiftAmount - 1; i--) {
            this.array[i] = this.array[i - shiftAmount];
        }

        return true;
    }

    // shift the elements to the left
    private boolean shiftLeft(int start, int shiftAmount) {
        if (!isValidIndex(start - shiftAmount))
            return false;

        for (int i = start; i < this.nElements; i++) {
            this.array[i - shiftAmount] = this.array[i];
        }

        return true;
    }

}