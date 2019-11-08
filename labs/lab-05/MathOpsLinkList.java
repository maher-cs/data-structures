public class MathOpsLinkList {

    // class attributes
    private LinkList<Integer> list;

    public MathOpsLinkList(Integer... list) {
        this.list = new LinkList<Integer>(list);
    }

    public Integer sum() {
        Integer result = 0;

        Iterator<Integer> iter = this.list.iterator();

        while (iter.hasNext()) {
            result += iter.next();
        }

        return result;
    }

    public Integer max() {
        int result = list.getFirst().getData();

        Iterator<Integer> iter = this.list.iterator();

        while (iter.hasNext()) {
            Integer elm = iter.next();
            if (elm.compareTo(result) > 0) {
                result = elm;
            }
        }

        return result;
    }

    public Integer min() {
        Integer result = list.getFirst().getData();

        Iterator<Integer> iter = this.list.iterator();

        while (iter.hasNext()) {
            Integer elm = iter.next();
            if (elm.compareTo(result) < 0) {
                result = elm;
            }
        }

        return result;
    }

    public int size() {
        return this.list.size();
    }

    public static void main(String[] args) {

        MathOpsLinkList mathOps = new MathOpsLinkList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("size: " + mathOps.size());
        System.out.println("max : " + mathOps.max());
        System.out.println("min : " + mathOps.min());
        System.out.println("sum : " + mathOps.sum());

    }
}