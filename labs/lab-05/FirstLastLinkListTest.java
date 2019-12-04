public class FirstLastLinkListTest {

    // colors for console
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    // test result messages
    public static final String TEST_PASS = " " + ANSI_GREEN + "PASS" + ANSI_RESET;
    public static final String TEST_FAIL = " " + ANSI_RED + "FAIL" + ANSI_RESET;

    public static void main(String[] args) {

        testConstructer();
        testIsEmpty();
        testGetFirst();
        testGetLast();
        testSetFirst();
        testInsertFirst();
        testInsertLast();
        testDelete();
        testDeleteFirst();
        testDeleteLast();
        testFind();
        testRemoveIndex();
        testInsertIndex();
        testRetrieveIndex();
        testUpdateIndex();

    }

    // test insert at method
    public static void testUpdateIndex() {
        System.out.print("testing update-at method...");

        TestCaseFirstLastLinkList[] cases = new TestCaseFirstLastLinkList[3];

        // normal case
        cases[0] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[0].list = new FirstLastLinkList<Integer>(3, 5, 7);
        cases[0].list.updateAt(1, 2);
        cases[0].setExpected("[ 3 2 7]");
        cases[0].setActual(cases[0].list.toString());

        // case insert at head
        cases[1] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[1].list = new FirstLastLinkList<Integer>(10, 57);
        cases[1].list.updateAt(0, 5);
        cases[1].setExpected("[ 5 57]");
        cases[1].setActual(cases[1].list.toString());

        // case insert at before tail
        cases[2] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[2].list = new FirstLastLinkList<Integer>(10, 57);
        cases[2].list.updateAt(1, 2);
        cases[2].setExpected("[ 10 2]");
        cases[2].setActual(cases[2].list.toString());

        TestCaseFirstLastLinkList.runTests(cases);
    }

    // test retrieve at method
    public static void testRetrieveIndex() {
        System.out.print("testing retrieve-at method...");

        TestCaseFirstLastLinkList[] cases = new TestCaseFirstLastLinkList[3];

        // normal case
        cases[0] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[0].list = new FirstLastLinkList<String>("A", "B", "C");
        String retrived0 = cases[0].list.retrieve(1).toString();
        cases[0].setExpected("B");
        cases[0].setActual(retrived0);

        // case insert at head
        cases[1] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[1].list = new FirstLastLinkList<Integer>(10, 57);
        String retrived1 = cases[1].list.retrieve(0).toString();
        cases[1].setExpected("10");
        cases[1].setActual(retrived1);

        // case insert at before tail
        cases[2] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[2].list = new FirstLastLinkList<Integer>(10, 57);
        String retrived2 = cases[2].list.retrieve(1).toString();
        cases[2].setExpected("57");
        cases[2].setActual(retrived2);

        TestCaseFirstLastLinkList.runTests(cases);
    }

    // test insert at method
    public static void testInsertIndex() {
        System.out.print("testing insert-at method...");

        TestCaseFirstLastLinkList[] cases = new TestCaseFirstLastLinkList[3];

        // normal case
        cases[0] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[0].list = new FirstLastLinkList<Integer>(3, 5, 7);
        cases[0].list.insertAt(1, 2);
        cases[0].setExpected("[ 3 2 5 7]");
        cases[0].setActual(cases[0].list.toString());

        // case insert at head
        cases[1] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[1].list = new FirstLastLinkList<Integer>(10, 57);
        cases[1].list.insertAt(0, 5);
        cases[1].setExpected("[ 5 10 57]");
        cases[1].setActual(cases[1].list.toString());

        // case insert at before tail
        cases[2] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[2].list = new FirstLastLinkList<Integer>(10, 57);
        cases[2].list.insertAt(1, 2);
        cases[2].setExpected("[ 10 2 57]");
        cases[2].setActual(cases[2].list.toString());

        TestCaseFirstLastLinkList.runTests(cases);
    }

    // test remove at index method
    public static void testRemoveIndex() {
        System.out.print("testing remove-at method...");

        TestCaseFirstLastLinkList[] cases = new TestCaseFirstLastLinkList[4];

        // normal case
        cases[0] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[0].list = new FirstLastLinkList<Integer>(3, 5, 7);
        cases[0].list.removeAt(1);
        cases[0].setExpected("[ 3 7]");
        cases[0].setActual(cases[0].list.toString());

        // case delete head
        cases[1] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[1].list = new FirstLastLinkList<Integer>(10, 57);
        cases[1].list.removeAt(0);
        cases[1].setExpected("[ 57]");
        cases[1].setActual(cases[1].list.toString());

        // case delete tail
        cases[2] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[2].list = new FirstLastLinkList<Integer>(10, 57);
        cases[2].list.removeAt(1);
        cases[2].setExpected("[ 10]");
        cases[2].setActual(cases[2].list.toString());

        // case delete the only element in the list
        cases[3] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[3].list = new FirstLastLinkList<Integer>(10);
        cases[3].list.removeAt(0);
        cases[3].setExpected("[]");
        cases[3].setActual(cases[3].list.toString());

        TestCaseFirstLastLinkList.runTests(cases);
    }

    // test find method
    public static void testFind() {
        System.out.print("testing find method...");

        TestCaseFirstLastLinkList[] cases = new TestCaseFirstLastLinkList[4];

        cases[0] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[0].list = new FirstLastLinkList<Integer>(3, 5, 7);
        String founded1 = cases[0].list.find(3).toString();
        cases[0].setExpected("{3}");
        cases[0].setActual(founded1);

        cases[1] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[1].list = new FirstLastLinkList<Integer>(3, 5, 7);
        String founded2 = cases[1].list.find(5).toString();
        cases[1].setExpected("{5}");
        cases[1].setActual(founded2);

        cases[2] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[2].list = new FirstLastLinkList<Integer>(10);
        String founded3 = cases[2].list.find(10).toString();
        cases[2].setExpected("{10}");
        cases[2].setActual(founded3);

        cases[3] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[3].list = new FirstLastLinkList<Integer>();
        String founded4 = cases[3].list.find(10) + "";
        cases[3].setExpected("null");
        cases[3].setActual(founded4);

        TestCaseFirstLastLinkList.runTests(cases);
    }

    // test delete-last method
    public static void testDeleteLast() {
        System.out.print("testing delete-last method...");

        TestCaseFirstLastLinkList[] cases = new TestCaseFirstLastLinkList[3];

        cases[0] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[0].list = new FirstLastLinkList<Integer>(3, 5, 7);
        cases[0].list.deleteLast();
        cases[0].setExpected("[ 3 5]");
        cases[0].setActual(cases[0].list.toString());

        cases[1] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[1].list = new FirstLastLinkList<Integer>(10);
        cases[1].list.deleteLast();
        cases[1].setExpected("[]");
        cases[1].setActual(cases[1].list.toString());

        cases[2] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[2].list = new FirstLastLinkList<Integer>();
        cases[2].list.deleteLast();
        cases[2].setExpected("[]");
        cases[2].setActual(cases[2].list.toString());

        TestCaseFirstLastLinkList.runTests(cases);
    }

    // test delete-first method
    public static void testDeleteFirst() {
        System.out.print("testing delete-first method...");

        TestCaseFirstLastLinkList[] cases = new TestCaseFirstLastLinkList[3];

        cases[0] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[0].list = new FirstLastLinkList<Integer>(3, 5, 7);
        cases[0].list.deleteFirst();
        cases[0].setExpected("[ 5 7]");
        cases[0].setActual(cases[0].list.toString());

        cases[1] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[1].list = new FirstLastLinkList<Integer>(10);
        cases[1].list.deleteFirst();
        cases[1].setExpected("[]");
        cases[1].setActual(cases[1].list.toString());

        cases[2] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[2].list = new FirstLastLinkList<Integer>();
        cases[2].list.deleteFirst();
        cases[2].setExpected("[]");
        cases[2].setActual(cases[2].list.toString());

        TestCaseFirstLastLinkList.runTests(cases);
    }

    // test delete method
    public static void testDelete() {
        System.out.print("testing delete method...");

        TestCaseFirstLastLinkList[] cases = new TestCaseFirstLastLinkList[6];

        // normal case
        cases[0] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[0].list = new FirstLastLinkList<Integer>(3, 5, 7);
        cases[0].list.delete(7);
        cases[0].setExpected("[ 3 5]");
        cases[0].setActual(cases[0].list.toString());

        // case delete head
        cases[1] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[1].list = new FirstLastLinkList<Integer>(10, 57);
        cases[1].list.delete(10);
        cases[1].setExpected("[ 57]");
        cases[1].setActual(cases[1].list.toString());

        // case delete tail
        cases[2] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[2].list = new FirstLastLinkList<Integer>(10, 57);
        cases[2].list.delete(57);
        cases[2].setExpected("[ 10]");
        cases[2].setActual(cases[2].list.toString());

        // case delete non-exist element
        cases[3] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[3].list = new FirstLastLinkList<Integer>(10, 12, 16);
        cases[3].list.delete(57);
        cases[3].setExpected("[ 10 12 16]");
        cases[3].setActual(cases[3].list.toString());

        // case delete the only element in the list
        cases[4] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[4].list = new FirstLastLinkList<Integer>(10);
        cases[4].list.delete(10);
        cases[4].setExpected("[]");
        cases[4].setActual(cases[4].list.toString());

        // case delete from empty list
        cases[5] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[5].list = new FirstLastLinkList<Integer>();
        cases[5].list.delete(10);
        cases[5].setExpected("[]");
        cases[5].setActual(cases[5].list.toString());

        TestCaseFirstLastLinkList.runTests(cases);
    }

    // test insert-last method
    public static void testInsertLast() {
        System.out.print("testing insert-last method...");

        TestCaseFirstLastLinkList[] cases = new TestCaseFirstLastLinkList[2];

        cases[0] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[0].list = new FirstLastLinkList<Integer>(3, 5, 7);
        cases[0].list.insertLast(10);
        cases[0].setExpected("[ 3 5 7 10]");
        cases[0].setActual(cases[0].list.toString());

        cases[1] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[1].list = new FirstLastLinkList<Integer>();
        cases[1].list.insertLast(10);
        cases[1].setExpected("[ 10]");
        cases[1].setActual(cases[1].list.toString());

        TestCaseFirstLastLinkList.runTests(cases);
    }

    // test insert-first method
    public static void testInsertFirst() {
        System.out.print("testing insert-first method...");

        TestCaseFirstLastLinkList[] cases = new TestCaseFirstLastLinkList[2];

        cases[0] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[0].list = new FirstLastLinkList<Integer>(3, 5, 7);
        cases[0].list.insertFirst(10);
        cases[0].setExpected("[ 10 3 5 7]");
        cases[0].setActual(cases[0].list.toString());

        cases[1] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[1].list = new FirstLastLinkList<Integer>();
        cases[1].list.insertFirst(null);
        cases[1].setExpected("[ null]");
        cases[1].setActual(cases[1].list.toString());

        TestCaseFirstLastLinkList.runTests(cases);
    }

    // test set-first
    public static void testSetFirst() {
        System.out.print("testing set-first method...");

        TestCaseFirstLastLinkList[] cases = new TestCaseFirstLastLinkList[2];

        cases[0] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[0].list = new FirstLastLinkList<Integer>(3, 5, 7);
        Integer newElm = 10;
        String oldElm = cases[0].list.setFirst(newElm).toString();
        cases[0].setExpected("[ 10 5 7], 3");
        cases[0].setActual(cases[0].list.toString() + ", " + oldElm);

        cases[1] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[1].list = new FirstLastLinkList<Integer>(3, 5, 7);
        Node<Integer> newNode = new Node(10);
        String oldElm2 = cases[1].list.setFirst(newNode).toString();
        cases[1].setExpected("[ 10 5 7], 3");
        cases[1].setActual(cases[1].list.toString() + ", " + oldElm2);

        TestCaseFirstLastLinkList.runTests(cases);
    }

    // test get-last method
    public static void testGetLast() {
        System.out.print("testing get-last method...");

        TestCaseFirstLastLinkList[] cases = new TestCaseFirstLastLinkList[2];

        cases[0] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[0].list = new FirstLastLinkList<Integer>(3, 5, 7);
        cases[0].setExpected("{7}");
        cases[0].setActual(cases[0].list.getLast().toString());

        cases[1] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[1].list = new FirstLastLinkList<Integer>();
        cases[1].setExpected("null");
        cases[1].setActual("" + cases[1].list.getLast());

        TestCaseFirstLastLinkList.runTests(cases);
    }

    // test get-first method
    public static void testGetFirst() {
        System.out.print("testing get-first method...");

        TestCaseFirstLastLinkList[] cases = new TestCaseFirstLastLinkList[2];

        cases[0] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[0].list = new FirstLastLinkList<Integer>(3, 5, 7);
        cases[0].setExpected("{3}");
        cases[0].setActual(cases[0].list.getFirst().toString());

        cases[1] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[1].list = new FirstLastLinkList<Integer>();
        cases[1].setExpected("null");
        cases[1].setActual("" + cases[1].list.getFirst());

        TestCaseFirstLastLinkList.runTests(cases);
    }

    // test is-empty method
    public static void testIsEmpty() {
        System.out.print("testing is-empty method...");

        TestCaseFirstLastLinkList[] cases = new TestCaseFirstLastLinkList[3];

        cases[0] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[0].list = new FirstLastLinkList<Integer>(3, 5, 7);
        cases[0].setExpected("false");
        cases[0].setActual("" + cases[0].list.isEmpty());

        cases[1] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[1].list = new FirstLastLinkList<Integer>();
        cases[1].list.insertFirst(4);
        cases[1].setExpected("false");
        cases[1].setActual("" + cases[1].list.isEmpty());

        cases[2] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[2].list = new FirstLastLinkList<Integer>();
        cases[2].setExpected("true");
        cases[2].setActual("" + cases[2].list.isEmpty());

        TestCaseFirstLastLinkList.runTests(cases);
    }

    // test set method
    public static void testConstructer() {
        System.out.print("testing constructer...");

        TestCaseFirstLastLinkList[] cases = new TestCaseFirstLastLinkList[2];

        cases[0] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[0].list = new FirstLastLinkList<Integer>(3, 5, 7, 3);
        cases[0].setExpected("[ 3 5 7 3]");
        cases[0].setActual(cases[0].list.toString());

        cases[1] = new TestCaseFirstLastLinkList<String, FirstLastLinkList<Integer>>();
        cases[1].list = new FirstLastLinkList<Integer>();
        cases[1].setExpected("[]");
        cases[1].setActual(cases[1].list.toString());

        TestCaseFirstLastLinkList.runTests(cases);
    }
}