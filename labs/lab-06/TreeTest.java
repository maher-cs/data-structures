public class TreeTest {

    // colors for console
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    // test result messages
    public static final String TEST_PASS = " " + ANSI_GREEN + "PASS" + ANSI_RESET;
    public static final String TEST_FAIL = " " + ANSI_RED + "FAIL" + ANSI_RESET;

    public static void main(String[] args) {

        testConstructor();
        testFind();
        testFindR();
        testPreOrderR();
        testPostOrderR();
        testInOrderR();
        testPreOrderN();
        testPostOrderN();
        testInOrderN();
        testLevelOrder();
        testMin();
        testMax();
        testDepthFirst();

        

    }

    // testing depth first
    public static void testDepthFirst() {
        System.out.print("testing depth first...");

        TestCaseTree[] cases = new TestCaseTree[2];

        cases[0] = new TestCaseTree<String, Tree<Integer>>();
        cases[0].list = new Tree<Integer>(3, 5, 1, 7, 3, 2);
        String result1 = cases[0].list.depthFirst(2, cases[0].list.getRoot()) + "";
        cases[0].setExpected("true");
        cases[0].setActual(result1);

        cases[1] = new TestCaseTree<String, Tree<Integer>>();
        cases[1].list = new Tree<Integer>(3, 5, 1, 7, 3, 2);
        String result2 = cases[1].list.depthFirst(3, cases[0].list.getRoot()) + "";
        cases[1].setExpected("true");
        cases[1].setActual(result2);

        TestCaseTree.runTests(cases);
    }

    // testing max
    public static void testMax() {
        System.out.print("testing max...");

        TestCaseTree[] cases = new TestCaseTree[1];

        cases[0] = new TestCaseTree<String, Tree<Integer>>();
        cases[0].list = new Tree<Integer>(3, 5, 1, 7, 3, 2);
        String result = cases[0].list.max() + "";
        cases[0].setExpected("7");
        cases[0].setActual(result);

        TestCaseTree.runTests(cases);
    }

    // testing min
    public static void testMin() {
        System.out.print("testing min...");

        TestCaseTree[] cases = new TestCaseTree[1];

        cases[0] = new TestCaseTree<String, Tree<Integer>>();
        cases[0].list = new Tree<Integer>(3, 5, 1, 7, 3, 2);
        String result = cases[0].list.min() + "";
        cases[0].setExpected("1");
        cases[0].setActual(result);

        TestCaseTree.runTests(cases);
    }

    // testing level order
    public static void testLevelOrder() {
        System.out.print("testing level order...");

        TestCaseTree[] cases = new TestCaseTree[1];

        cases[0] = new TestCaseTree<String, Tree<Integer>>();
        cases[0].list = new Tree<Integer>(3, 5, 1, 7, 3, 2);
        cases[0].setExpected("3 1 5 2 3 7 ");
        cases[0].setActual(cases[0].list.toStringLevelOrder(cases[0].list.getRoot()));

        TestCaseTree.runTests(cases);
    }

    // testing post order non-recursive
    public static void testPostOrderN() {
        System.out.print("testing post order non-recursive...");

        TestCaseTree[] cases = new TestCaseTree[1];

        cases[0] = new TestCaseTree<String, Tree<Integer>>();
        cases[0].list = new Tree<Integer>(3, 5, 1, 7, 3, 2);
        cases[0].setExpected("2 1 3 7 5 3 ");
        cases[0].setActual(cases[0].list.toStringPostOrderN());

        TestCaseTree.runTests(cases);
    }

    // testing in order non-recursive
    public static void testInOrderN() {
        System.out.print("testing in order non-recursive...");

        TestCaseTree[] cases = new TestCaseTree[1];

        cases[0] = new TestCaseTree<String, Tree<Integer>>();
        cases[0].list = new Tree<Integer>(3, 5, 1, 7, 3, 2);
        cases[0].setExpected("1 2 3 3 5 7 ");
        cases[0].setActual(cases[0].list.toStringInOrderN());

        TestCaseTree.runTests(cases);
    }

    // testing pre order non-recursive
    public static void testPreOrderN() {
        System.out.print("testing pre order non-recursive...");

        TestCaseTree[] cases = new TestCaseTree[1];

        cases[0] = new TestCaseTree<String, Tree<Integer>>();
        cases[0].list = new Tree<Integer>(3, 5, 1, 7, 3, 2);
        cases[0].setExpected("3 1 2 5 3 7 ");
        cases[0].setActual(cases[0].list.toStringPreOrderN());

        TestCaseTree.runTests(cases);
    }

    // testing post order recursive
    public static void testPostOrderR() {
        System.out.print("testing post order recursive...");

        TestCaseTree[] cases = new TestCaseTree[1];

        cases[0] = new TestCaseTree<String, Tree<Integer>>();
        cases[0].list = new Tree<Integer>(3, 5, 1, 7, 3, 2);
        cases[0].setExpected("2 1 3 7 5 3 ");
        cases[0].setActual(cases[0].list.toStringPostOrderR(cases[0].list.getRoot()));

        TestCaseTree.runTests(cases);
    }

    // testing in order recursive
    public static void testInOrderR() {
        System.out.print("testing in order recursive...");

        TestCaseTree[] cases = new TestCaseTree[1];

        cases[0] = new TestCaseTree<String, Tree<Integer>>();
        cases[0].list = new Tree<Integer>(3, 5, 1, 7, 3, 2);
        cases[0].setExpected("1 2 3 3 5 7 ");
        cases[0].setActual(cases[0].list.toStringInOrderR(cases[0].list.getRoot()));

        TestCaseTree.runTests(cases);
    }

    // testing pre order recursive
    public static void testPreOrderR() {
        System.out.print("testing pre order recursive...");

        TestCaseTree[] cases = new TestCaseTree[1];

        cases[0] = new TestCaseTree<String, Tree<Integer>>();
        cases[0].list = new Tree<Integer>(3, 5, 1, 7, 3, 2);
        cases[0].setExpected("3 1 2 5 3 7 ");
        cases[0].setActual(cases[0].list.toStringPreOrderR(cases[0].list.getRoot()));

        TestCaseTree.runTests(cases);
    }

    // testing find recursive method
    public static void testFindR() {
        System.out.print("testing find recursive method...");

        TestCaseTree[] cases = new TestCaseTree[4];

        cases[0] = new TestCaseTree<String, Tree<Integer>>();
        cases[0].list = new Tree<Integer>(3, 5, 7);
        String founded1 = cases[0].list.find(3).toString();
        cases[0].setExpected("{3}");
        cases[0].setActual(founded1);

        cases[1] = new TestCaseTree<String, Tree<Integer>>();
        cases[1].list = new Tree<Integer>(3, 5, 7);
        String founded2 = cases[1].list.find(5).toString();
        cases[1].setExpected("{5}");
        cases[1].setActual(founded2);

        cases[2] = new TestCaseTree<String, Tree<Integer>>();
        cases[2].list = new Tree<Integer>(10);
        String founded3 = cases[2].list.find(10).toString();
        cases[2].setExpected("{10}");
        cases[2].setActual(founded3);

        cases[3] = new TestCaseTree<String, Tree<Integer>>();
        cases[3].list = new Tree<Integer>();
        String founded4 = cases[3].list.find(10) + "";
        cases[3].setExpected("null");
        cases[3].setActual(founded4);

        TestCaseTree.runTests(cases);
    }

    // testing find method
    public static void testFind() {
        System.out.print("testing find method...");

        TestCaseTree[] cases = new TestCaseTree[4];

        cases[0] = new TestCaseTree<String, Tree<Integer>>();
        cases[0].list = new Tree<Integer>(3, 5, 7);
        String founded1 = cases[0].list.find(3).toString();
        cases[0].setExpected("{3}");
        cases[0].setActual(founded1);

        cases[1] = new TestCaseTree<String, Tree<Integer>>();
        cases[1].list = new Tree<Integer>(3, 5, 7);
        String founded2 = cases[1].list.find(5).toString();
        cases[1].setExpected("{5}");
        cases[1].setActual(founded2);

        cases[2] = new TestCaseTree<String, Tree<Integer>>();
        cases[2].list = new Tree<Integer>(10);
        String founded3 = cases[2].list.find(10).toString();
        cases[2].setExpected("{10}");
        cases[2].setActual(founded3);

        cases[3] = new TestCaseTree<String, Tree<Integer>>();
        cases[3].list = new Tree<Integer>();
        String founded4 = cases[3].list.find(10) + "";
        cases[3].setExpected("null");
        cases[3].setActual(founded4);

        TestCaseTree.runTests(cases);
    }

    // testing constructor
    public static void testConstructor() {
        System.out.print("testing constructer...");

        TestCaseTree[] cases = new TestCaseTree[2];

        cases[0] = new TestCaseTree<String, Tree<Integer>>();
        cases[0].list = new Tree<Integer>(3, 5, 1, 7, 3, 2);
        cases[0].setExpected("1 2 3 3 5 7 ");
        cases[0].setActual(cases[0].list.toString());

        cases[1] = new TestCaseTree<String, Tree<Integer>>();
        cases[1].list = new Tree<Integer>();
        cases[1].setExpected("");
        cases[1].setActual(cases[1].list.toString());

        TestCaseTree.runTests(cases);
    }



    
}