public class CircularDoublyLinkList<E> implements Iteratable<E> {

    // child attributes
    private CNode<E> head;
    private CNode<E> tail;
    private int nElements;

    public CircularDoublyLinkList(E... list) {
        // if passing empty list
        if (list == null || list.length <= 0) {
            this.head = null;
            this.tail = null;
            return;
        }

        for (int i = list.length - 1; i >= 0; i--) {
            if (i == list.length - 1) {
                this.firstInsert(list[i]);
                continue;
            }
            this.insertFirst(list[i]);
        }
    }

    // to string method
    @Override
    public String toString() {
        String output = "";
        Iterator<E> iter = this.iterator();
        while (iter.hasNext()) {
            E currentData = iter.next();
            output += " " + currentData;
        }

        output = "[" + output + "]";
        return output;
    }

    // return iterator on the list items
    @Override
    public Iterator<E> iterator() {
        CircularDoublyLinkListIterator<E> iter = new CircularDoublyLinkListIterator<E>(this);
        return iter;
    }

    public boolean isEmpty() {
        return this.nElements == 0;
    }

    public int size() {
        return this.nElements;
    }

    public CNode<E> getFirst() {
        return this.head;
    }

    public CNode<E> getLast() {
        return this.tail;
    }

    public E setFirst(E elm) {
        E oldHead = null;
        CNode<E> cnode = new CNode<E>(elm);
        if (!this.isEmpty()) {
            oldHead = this.head.getData();
            cnode.setPrevNext(this.tail, this.head.getNext());
        }
        this.head = cnode;
        return oldHead;
    }

    public E setFirst(CNode<E> cnode) {
        E oldHead = null;
        if (!this.isEmpty()) {
            oldHead = this.head.getData();
            cnode.setPrevNext(this.tail, this.head.getNext());
        }
        this.head = cnode;
        return oldHead;
    }

    public void insertFirst(E elm) {
        if (this.isEmpty()) {
            this.firstInsert(elm);
            return;
        }
        CNode<E> newCNode = new CNode<E>(elm, this.tail, this.head);
        this.head.setPrev(newCNode);
        this.tail.setNext(newCNode);
        this.head = newCNode;
        this.nElements++;
    }

    public void insertLast(E elm) {
        this.insertFirst(elm);
        this.head = this.head.getNext();
        this.tail = this.tail.getNext();
    }

    // delete first match with a given key
    public void delete(E key) {
        CNode<E> deleted = this.find(key);
        if (deleted == null) {
            return;
        }
        // if delete head
        if (this.head == deleted) {
            this.deleteFirst();
            return;
        }

        // if delete tail
        if (this.tail == deleted) {
            this.deleteLast();
            return;
        }

        // if founded
        if (deleted != null) {
            CNode<E> prevDel = deleted.getPrev();
            CNode<E> nextDel = deleted.getNext();
            nextDel.setPrev(prevDel);
            prevDel.setNext(nextDel);
            this.nElements--;
        }
    }

    public void deleteFirst() {
        CNode<E> deleted = this.head;
        if (deleted == null) {
            return;
        }
        CNode<E> prevDel = deleted.getPrev();
        CNode<E> nextDel = deleted.getNext();
        nextDel.setPrev(prevDel);
        prevDel.setNext(nextDel);
        this.nElements--;
        this.head = nextDel;
    }

    public void deleteLast() {
        CNode<E> deleted = this.tail;
        if (deleted == null) {
            return;
        }
        CNode<E> prevDel = deleted.getPrev();
        CNode<E> nextDel = deleted.getNext();
        nextDel.setPrev(prevDel);
        prevDel.setNext(nextDel);
        this.nElements--;
        this.tail = prevDel;
    }

    public CNode<E> find(E key) {
        if (this.isEmpty()) {
            return null;
        }
        CNode<E> current = this.head;
        for (int i = 0; i < this.size(); i++) {
            if (current.getData().equals(key)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    // update the value of the element at given index
    public void updateAt(int index, E elm) throws IndexOutOfBoundsException {
        this.checkIndex(index);

        CNode<E> current = this.head;
        for (int i = 0; i < this.size(); i++) {
            if (i == index) {
                current.setData(elm);
            }
            current = current.getNext();
        }
    }

    // retrieve the value of the element at given index
    public E retrieve(int index) throws IndexOutOfBoundsException {
        this.checkIndex(index);

        Iterator<E> iter = this.iterator();
        int counter = 0;
        while (iter.hasNext()) {
            if (counter == index) {
                return iter.getCurrent();
            }
            iter.next();
            counter++;
        }
        return null;
    }

    // remove element at given index
    public void removeAt(int index) throws IndexOutOfBoundsException {
        this.checkIndex(index);

        if (index == 0) {
            this.deleteFirst();
            return;
        }

        if (index == this.size() - 1) {
            this.deleteLast();
            return;
        }

        CNode<E> current = this.head.getNext();
        for (int i = 1; i < this.size(); i++) {
            if (index == i) {
                CNode<E> prevDel = current.getPrev();
                CNode<E> nextDel = current.getNext();
                nextDel.setPrev(prevDel);
                prevDel.setNext(nextDel);
                this.nElements--;
                break;
            }
            current = current.getNext();
        }
    }

    // insert element at given index
    public void insertAt(int index, E e) throws IndexOutOfBoundsException {
        this.checkIndex(index);

        if (index == 0) {
            this.insertFirst(e);
            return;
        }

        CNode<E> current = this.head.getNext();
        for (int i = 1; i < this.size(); i++) {
            if (index == i) {
                CNode<E> prevDel = current.getPrev();
                CNode<E> newCNode = new CNode<E>(e);
                newCNode.setPrevNext(prevDel, current);
                current.setPrev(newCNode);
                prevDel.setNext(newCNode);
                this.nElements++;
                break;
            }
            current = current.getNext();
        }

    }

    // ## private helpers methods ##

    // insert element for the first time
    private void firstInsert(E elm) {
        CNode<E> newCNode = new CNode<E>(elm);
        this.head = newCNode;
        this.tail = newCNode;
        newCNode.setPrevNext(this.tail, this.head);
        this.nElements++;
    }

    // check if the given index is in bounds
    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
    }
}