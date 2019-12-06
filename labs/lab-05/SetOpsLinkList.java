public class SetOpsLinkList<E> {

    public LinkList<E> intersection(LinkList<E> list1, LinkList<E> list2) {
        LinkList<E> result = new LinkList<E>();

        Iterator<E> iter1 = list1.iterator();

        while (iter1.hasNext()) {
            E elm = iter1.next();
            if (list2.find(elm) != null) {
                result.insertFirst(elm);
            }
        }

        return result;

    }

    public LinkList<E> union(LinkList<E> list1, LinkList<E> list2) {
        LinkList<E> result = new LinkList<E>();

        Iterator<E> iter1 = list1.iterator();
        Iterator<E> iter2 = list2.iterator();

        while (iter1.hasNext()) {
            E elm = iter1.next();
            if (result.find(elm) == null) {
                result.insertFirst(elm);
            }
        }

        while (iter2.hasNext()) {
            E elm = iter2.next();
            if (result.find(elm) == null) {
                result.insertFirst(elm);
            }
        }

        return result;
    }

    public LinkList<E> difference(LinkList<E> list1, LinkList<E> list2) {
        LinkList<E> result = new LinkList<E>();

        Iterator<E> iter1 = list1.iterator();

        while (iter1.hasNext()) {
            E elm = iter1.next();
            if (list2.find(elm) == null) {
                result.insertFirst(elm);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SetOpsLinkList<Integer> setOps = new SetOpsLinkList<Integer>();
        LinkList<Integer> list1 = new LinkList<Integer>(1, 2, 3, 4, 5, 6, 7);
        LinkList<Integer> list2 = new LinkList<Integer>(5, 6, 7, 8, 9, 10);

        LinkList<Integer> union = setOps.union(list1, list2);
        LinkList<Integer> intersection = setOps.intersection(list1, list2);
        LinkList<Integer> difference1 = setOps.difference(list1, list2);
        LinkList<Integer> difference2 = setOps.difference(list2, list1);

        System.out.println("list 1: " + list1);
        System.out.println("list 2: " + list2);
        System.out.println("===========");
        System.out.println("union: " + union);
        System.out.println("intersection: " + intersection);
        System.out.println("difference: " + difference1);
        System.out.println("difference: " + difference2);
    }

}