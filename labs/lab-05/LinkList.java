public class LinkList<E> implements Iteratable<E> {

    // class attributes
    private Node<E> head;

    // defaul constructor
    public LinkList() {
        this.head = null;
    }

    // constructor with list parameters as verargs
    public LinkList(E... list) {

        // if passing empty list
        if(list == null || list.length <= 0) {
            this.head = null;
            return;
        }

        for(int i = list.length-1; i >= 0; i--) {
            this.insertFirst(list[i]);
        }
    }

    // return true if no elements in the list
    public boolean isEmpty() {
        return this.head == null;
    }

    // return iterator on the list items
    @Override
    public Iterator<E> iterator() {
        LinkListIterator<E> iter = new LinkListIterator(this);
        return iter;
    }

    // to string method
    @Override
    public String toString() {
        String output = "";
        Iterator<E> iter = this.iterator();
        while(iter.hasNext()) {
            E currentData = iter.next(); 
            output += " " + currentData;
        }

        output = "[" + output + "]";
        return output;
    }

    // get the first item in the list
    public Node<E> getFirst() {
        if(this.isEmpty())
            return null;
        return this.head;
    }

    // get the last element in the list
    public Node<E> getLast() {
        if(this.isEmpty())
            return null;
        
        Node<E> current = this.head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }

    // set the first element to a given node
    // return old first element
    public E setFirst(Node<E> node) {
        E oldHead = null;
        if(!this.isEmpty()) {
            oldHead = this.head.getData();
            node.setNext(this.head.getNext());
        }
        this.head = node;
        return oldHead;
    }

    // set the first element to a given element
    // return old first element
    public E setFirst(E element) {
        E oldHead = null;
        Node<E> node = new Node(element);
        if(!this.isEmpty()) {
            oldHead = this.head.getData();
            node.setNext(this.head.getNext());
        }
        this.head = node;
        return oldHead;
    }

    // insert at the head of the list
    public void insertFirst(E element) {
        Node<E> node = new Node(element);
        node.setNext(this.head);
        this.head = node;
    }

    // insert after last element in the list
    public void insertLast(E element) {
        if(this.isEmpty()) {
            this.insertFirst(element);
            return;
        }
            
        Node<E> last = this.getLast();
        last.setNext(new Node(element));
    }

    // delete first match element
    public E delete(E key) {
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
        Node<E> deletedNode = this.deleteNext(previosNode, nextNode);
        return deletedNode.getData();
    }

    // delete head node
    public E deleteFirst() {
        if(this.isEmpty()) {
            return null;
        }
        E element = this.head.getData();
        this.head = this.head.getNext();
        return element;
    }

    public E deleteLast() {
        if(this.isEmpty()) {
            return null;
        }
        if(this.hasOnlyOneElement()) {
            return this.deleteFirst();
        }
        Node<E> beforLast = this.getBeforLast();
        return this.deleteNext(beforLast).getData();
    }

    public Node<E> find(E element) {
        if(this.isEmpty()) {
            return null;
        }
        Node<E> current = this.head;
        while(current != null) {
            if(current.getData().equals(element)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    // ## private utils methods ##

    // delete element by given previos and next node 
    private Node<E> deleteNext(Node<E> node, Node<E> afterNextNode) {
        if(node == null || node.getNext() == null) {
            return null;
        }
        Node<E> deletedNode = node.getNext();
        node.setNext(afterNextNode);
        return deletedNode;
    }

    // delete element by given previos node as last node
    private Node<E> deleteNext(Node<E> node) {
        return this.deleteNext(node, null);
    }

    // find and get previos element by given element
    private Node<E> findPrevios(E element) {
        if(this.isEmpty()) {
            return null;
        }
        Node<E> previos = null;
        Node<E> current = this.head;
        while(current != null) {
            if(current.getData().equals(element)) {
                return previos;
            }
            previos = current;
            current = current.getNext();
        }
        return null;
    }

    // get befor last
    private Node<E> getBeforLast() {
        if(this.isEmpty()) {
            return null;
        }
        Node<E> previos = null;
        Node<E> current = this.head;
        while(current.getNext() != null) {
            previos = current;
            current = current.getNext();
        }
        return previos;
    }

    // return true if size is one
    private boolean hasOnlyOneElement() {
        return ( (!this.isEmpty()) && this.head.getNext() == null);
    }

}