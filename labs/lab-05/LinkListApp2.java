
public class LinkListApp2 {
    public static void main(String[] args) {
        LinkList<Integer> theList = new LinkList<Integer>();

        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertFirst(88);

        theList.displayList();

        Node<Integer> f = theList.find(88);
        if (f != null)
            System.out.println("Found link with key " + f.getData());
        else
            System.out.println("Can't find link");

        Node<Integer> d = theList.delete(66);
        if (d != null)
            System.out.println("Deleted link with key " + d.getData());
        else
            System.out.println("Can't delete link");

        theList.displayList();
        theList.deleteLast();
        theList.displayList();
        theList.deleteFirst();
        theList.displayList();
        theList.insertLast(33);
        theList.displayList();
        theList.insertLast(80);
        theList.displayList();

        System.out.println("==========");

        MathOpsLinkList mathLinkList = new MathOpsLinkList(theList);

        System.out.println("size: " + theList.size());
        System.out.println("sum: " + mathLinkList.sum());
        System.out.println("max: " + mathLinkList.max());
        System.out.println("min: " + mathLinkList.min());
    }
}
