public class FirstLastLinkList<E> extends LinkList<E> {

    // child attributes
    private Node<E> tail;
    private int nElements;

    public FirstLastLinkList(E... list) {
        // if passing empty list
        if(list == null || list.length <= 0) {
            super.head = null;
            return;
        }

        for(int i = list.length-1; i >= 0; i--) {
            if(i == list.length-1) {
                this.firstInsert(list[i]);
                continue;
            }
            this.insertFirst(list[i]);
        }
    }

    // return the value of nElements instade of iterating and counting
    @Override
    public int size() {
        return this.nElements;
    }

    // adding increment operation on nELements
    @Override
    public void insertFirst(E elm) {
        if(this.size() == 0) {
            this.firstInsert(elm);
            return;
        }
        super.insertFirst(elm);
        this.nElements++;
    }

    // adding increment operation on nELements
    @Override
    public void insertLast(E elm) {
        if(this.size() == 0) {
            this.firstInsert(elm);
            return;
        }
        Node<E> newNode = new Node<E>(elm);
        this.tail.setNext(newNode);
        this.tail = newNode;
    }

    // adding decrement operation on nELements
    // and re-implement to handle tail operation
    @Override
    public Node<E> delete(E key) {
        if(this.isEmpty()) {
            return null;
        }
        if(this.head.getData().equals(key)) {
            return this.deleteFirst();
        }
        Node<E> previosNode = this.findPrevios(key);
        if(previosNode == null) {
            return null;
        }
        Node<E> nextNode = previosNode.getNext().getNext();
        if(nextNode == null) {
            return this.deleteLast();
        }
        Node<E> deletedNode = this.deleteNext(previosNode, nextNode);
        return deletedNode;
    }

    // adding decrement operation on nELements
    @Override
    public Node<E> deleteFirst() {
        if(this.size() == 1) {
            return this.deleteTheOnlyElement();
        }
        Node<E> deleted = super.deleteFirst();
        this.nElements--;
        return deleted;
    }

    // adding decrement operation on nELements
    @Override
    public Node<E> deleteLast() {
        if(this.size() == 1) {
            return this.deleteTheOnlyElement();
        }
        this.tail = this.getBeforLast();
        Node<E> deleted = super.deleteLast();
        this.nElements--;
        return deleted;
    }

    // insert element at given index
    public void insertAt(int index, E e) throws IndexOutOfBoundsException {
        this.checkIndex(index);
        
        if(index == 0) {
            this.insertFirst(e);
            return;
        }

        int counter = 1;

        Node<E> prev = this.head;
        Node<E> current = this.head.getNext();
        while(current != null) {
            if(index == counter) {
                Node<E> newNode = new Node<E>(e);
                newNode.setNext(current);
                prev.setNext(newNode);
                break;
            }
            prev = current;
            current = current.getNext();
            counter++;
        }

    }

    // remove element at given index
    public void removeAt(int index) throws IndexOutOfBoundsException {
        this.checkIndex(index);

        if(index == 0) {
            this.deleteFirst();
            return;
        }

        if(index == this.size() - 1) {
            this.deleteLast();
            return;
        }

        int counter = 1;

        Node<E> prev = this.head;
        Node<E> current = this.head.getNext();
        while(current.getNext() != null) {
            if(index == counter) {
                prev.setNext(current.getNext());
                break;
            }
            prev = current;
            current = current.getNext();
            counter++;
        }
    }

    // retrieve the value of the element at given index
    public E retrieve(int index) throws IndexOutOfBoundsException {
        this.checkIndex(index);

        Iterator<E> iter = this.iterator();
        int counter = 0;
        while(iter.hasNext()) {
            if(counter == index) {
                return iter.getCurrent();
            }
            iter.next();
            counter++;
        }
        return null;
    }

    // update the value of the element at given index
    public void updateAt(int index, E elm) throws IndexOutOfBoundsException {
        this.checkIndex(index);

        Node<E> current = this.head;
        int counter = 0;
        while(current != null) {
            if(counter == index) {
                current.setData(elm);
            }
            current = current.getNext();
            counter++;
        }
    }

    // ## protected helpers methods ##

    // check if the given index is in bounds 
    protected void checkIndex(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    // the first insert operation in the list
    protected void firstInsert(E elm) {
        Node<E> node = new Node<E>(elm);
        this.head = node;
        this.tail = node;
        this.nElements++;
    }

    protected Node<E> deleteTheOnlyElement() {
        if(this.size() == 1) {
            Node<E> deleted = this.head;
            this.head = null;
            this.tail = null;
            this.nElements--;
            return deleted;
        }
        return null;
    }
    
}