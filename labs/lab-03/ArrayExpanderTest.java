/*
 * UQU - CIS - Data sturctures - 1441
 * Lab 3
 * MHD Maher Azkoul - 438017578
 * Test class
 */

import java.util.Arrays;

public class ArrayExpanderTest {

    // colors for console
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    // test result messages
    public static final String TEST_PASS = " " + ANSI_GREEN + "PASS" + ANSI_RESET;
    public static final String TEST_FAIL = " " + ANSI_RED + "FAIL" + ANSI_RESET;

    public static void main(String[] args) {
        testConstructorSize();
        testInsert();
        testInsertList();
        testConstructorList();
        testToArray();
        testSize();
        testClear();
        testInsertAt();
        testInsertFirst();
        testFind();
        testFindLast();
        testFindAll();
        testGet();
        testRemoveAt();
        testRemove();
        testRemoveLast();
        testRemoveAll();
        testRemoveDuplicates();
        testSet();
        testBubbleSort();
        testSelectionSort();
        testInsertionSort();
        testExpandingArray();
    }

    // test expanding array
    public static void testExpandingArray() {
        System.out.print("testing expanding array...");

        TestCase[] cases = new TestCase[1];

        cases[0] = new TestCase<String>();
        cases[0].hArray = new ArrayExpander<Integer>(7, 2);
        cases[0].hArray.insert(5);
        cases[0].hArray.insert(6);
        cases[0].hArray.insert(8);
        cases[0].hArray.insert(9);
        cases[0].setExpected("[ 7 2 5 6 8 9]");
        cases[0].setActual(cases[0].hArray.toString());

        TestCase.runTests(cases);
    }

    // test insertion sort method
    public static void testInsertionSort() {
        System.out.print("testing insertion sort method...");

        TestCase[] cases = new TestCase[1];

        cases[0] = new TestCase<String>();
        cases[0].hArray = new ArrayExpander<Integer>(7, 3, 2, 1, 5);
        cases[0].hArray.selectionSort();
        cases[0].setExpected("[ 1 2 3 5 7]");
        cases[0].setActual(cases[0].hArray.toString());

        TestCase.runTests(cases);
    }

    // test selection sort method
    public static void testSelectionSort() {
        System.out.print("testing selection sort method...");

        TestCase[] cases = new TestCase[1];

        cases[0] = new TestCase<String>();
        cases[0].hArray = new ArrayExpander<Integer>(7, 3, 2, 1, 5);
        cases[0].hArray.selectionSort();
        cases[0].setExpected("[ 1 2 3 5 7]");
        cases[0].setActual(cases[0].hArray.toString());

        TestCase.runTests(cases);
    }

    // test bubble sort method
    public static void testBubbleSort() {
        System.out.print("testing bubble sort method...");

        TestCase[] cases = new TestCase[1];

        cases[0] = new TestCase<String>();
        cases[0].hArray = new ArrayExpander<Integer>(7, 3, 2, 1, 5);
        cases[0].hArray.bubbleSort();
        cases[0].setExpected("[ 1 2 3 5 7]");
        cases[0].setActual(cases[0].hArray.toString());

        TestCase.runTests(cases);
    }

    // test set method
    public static void testSet() {
        System.out.print("testing set method...");

        TestCase[] cases = new TestCase[2];

        cases[0] = new TestCase<String>();
        cases[0].hArray = new ArrayExpander<Integer>(3, 5, 7, 3);
        cases[0].hArray.set(3, 5);
        cases[0].setExpected("[ 3 5 7 5]");
        cases[0].setActual(cases[0].hArray.toString());

        cases[1] = new TestCase<String>();
        cases[1].hArray = new ArrayExpander<Integer>(3, 5, 7, 10);
        cases[1].hArray.set(4, 17);
        cases[1].setExpected("[ 3 5 7 10]");
        cases[1].setActual(cases[1].hArray.toString());

        TestCase.runTests(cases);
    }

    // test remove duplicates
    public static void testRemoveDuplicates() {
        System.out.print("testing remove duplicates method...");

        TestCase[] cases = new TestCase[1];

        cases[0] = new TestCase<String>();
        cases[0].hArray = new ArrayExpander<Integer>(3, 5, 7, 7, 3, 5);
        cases[0].hArray.removeDuplicates();
        cases[0].setExpected("[ 7 3 5]");
        cases[0].setActual(cases[0].hArray.toString());

        TestCase.runTests(cases);
    }

    // test remove all
    public static void testRemoveAll(){
        System.out.print("testing remove all method...");

        TestCase[] cases = new TestCase[2];

        cases[0] = new TestCase<String>();
        cases[0].hArray = new ArrayExpander<Integer>(3, 5, 7, 3);
        cases[0].hArray.removeAll(3);
        cases[0].setExpected("[ 5 7]");
        cases[0].setActual(cases[0].hArray.toString());

        cases[1] = new TestCase<String>();
        cases[1].hArray = new ArrayExpander<Integer>(3, 5, 7, 10);
        cases[1].hArray.removeAll(4);
        cases[1].setExpected("[ 3 5 7 10]");
        cases[1].setActual(cases[1].hArray.toString());

        TestCase.runTests(cases);
    } 

    // test remove lase
    public static void testRemoveLast() {
        System.out.print("testing removeLast method...");

        TestCase[] cases = new TestCase[2];

        cases[0] = new TestCase<String>();
        cases[0].hArray = new ArrayExpander<Integer>(3, 5, 7, 3);
        cases[0].hArray.removeLast(3);
        cases[0].setExpected("[ 3 5 7]");
        cases[0].setActual(cases[0].hArray.toString());

        cases[1] = new TestCase<String>();
        cases[1].hArray = new ArrayExpander<Integer>(3, 5, 7, 10);
        cases[1].hArray.removeLast(4);
        cases[1].setExpected("[ 3 5 7 10]");
        cases[1].setActual(cases[1].hArray.toString());

        TestCase.runTests(cases);
    }

    // test remove
    public static void testRemove() {
        System.out.print("testing remove method...");

        TestCase[] cases = new TestCase[2];

        cases[0] = new TestCase<String>();
        cases[0].hArray = new ArrayExpander<Integer>(3, 5, 7, 10);
        cases[0].hArray.remove(5);
        cases[0].setExpected("[ 3 7 10]");
        cases[0].setActual(cases[0].hArray.toString());

        cases[1] = new TestCase<String>();
        cases[1].hArray = new ArrayExpander<Integer>(3, 5, 7, 10);
        cases[1].hArray.removeAt(4);
        cases[1].setExpected("[ 3 5 7 10]");
        cases[1].setActual(cases[1].hArray.toString());

        TestCase.runTests(cases);
    }

    // test remove at method
    public static void testRemoveAt() {
        System.out.print("testing removeAt method...");

        TestCase[] cases = new TestCase[2];

        cases[0] = new TestCase<String>();
        cases[0].hArray = new ArrayExpander<Integer>(3, 5, 7, 10);
        cases[0].hArray.removeAt(1);
        cases[0].setExpected("[ 3 7 10]");
        cases[0].setActual(cases[0].hArray.toString());

        cases[1] = new TestCase<String>();
        cases[1].hArray = new ArrayExpander<Integer>(3, 5, 7, 10);
        cases[1].hArray.removeAt(4);
        cases[1].setExpected("[ 3 5 7 10]");
        cases[1].setActual(cases[1].hArray.toString());

        TestCase.runTests(cases);
    }

    // test get method
    public static void testGet() {
        System.out.print("testing get method...");

        TestCase[] cases = new TestCase[3];

        cases[0] = new TestCase<Integer>();
        cases[0].hArray = new ArrayExpander<Integer>(3, 5, 7, 7, 10);
        cases[0].setExpected(3);
        cases[0].setActual(cases[0].hArray.get(0));

        cases[1] = new TestCase<Integer>();
        cases[1].hArray = new ArrayExpander<Integer>(3, 5, 7, 7, 10);
        cases[1].setExpected(null);
        cases[1].setActual(cases[1].hArray.get(-1));

        cases[2] = new TestCase<Integer>();
        cases[2].hArray = new ArrayExpander<Integer>(3, 5, 7, 7, 10);
        cases[2].setExpected(null);
        cases[2].setActual(cases[2].hArray.get(5));

        TestCase.runTests(cases);
    }

    // test findAll
    public static void testFindAll() {
        ArrayExpander<Integer> hArray;
        int[] expected, actual;
        boolean pass = true;
        System.out.print("testing findAll method...");

        // case1
        hArray = new ArrayExpander<Integer>(3, 5, 7, 7, 10);
        expected = new int[]{2, 3, -1, 0, 0, 0};
        actual = hArray.findAll(7);
        if(!Arrays.equals(expected, actual)) {
            System.out.print(TEST_FAIL + 1);
            pass = false;
        }

        // case2
        hArray = new ArrayExpander<Integer>(7, 7, 7, 7, 7);
        expected = new int[]{0, 1, 2, 3, 4, -1};
        actual = hArray.findAll(7);
        if(!Arrays.equals(expected, actual)) {
            System.out.print(TEST_FAIL + 2);
            pass = false;
        }

        // case3
        hArray = new ArrayExpander<Integer>(3, 5, 5, 5, 10);
        expected = new int[]{-1, 0, 0, 0, 0, 0};
        actual = hArray.findAll(7);
        if(!Arrays.equals(expected, actual)) {
            System.out.print(TEST_FAIL + 3);
            pass = false;
        }

        if(pass)
            System.out.print(TEST_PASS);
        System.out.println();
    }

    // test findLast
    public static void testFindLast() {
        System.out.print("testing findLast method...");

        TestCase[] cases = new TestCase[3];

        cases[0] = new TestCase<Integer>();
        cases[0].hArray = new ArrayExpander<Integer>(3, 5, 7, 7, 10);
        cases[0].setExpected(3);
        cases[0].setActual(cases[0].hArray.findLast(7));

        cases[1] = new TestCase<Integer>();
        cases[1].hArray = new ArrayExpander<Integer>(3, 5, 7, 10);
        cases[1].setExpected(2);
        cases[1].setActual(cases[1].hArray.findLast(7));

        cases[2] = new TestCase<Integer>();
        cases[2].hArray = new ArrayExpander<Integer>(3, 5, 7, 7, 10);
        cases[2].setExpected(-1);
        cases[2].setActual(cases[2].hArray.find(13));

        TestCase.runTests(cases);
    }

    // test find
    public static void testFind() {
        System.out.print("testing find method...");

        TestCase[] cases = new TestCase[2];

        cases[0] = new TestCase<Integer>();
        cases[0].hArray = new ArrayExpander<Integer>(1, 2, 7, 10);
        cases[0].setExpected(2);
        cases[0].setActual(cases[0].hArray.find(7));

        cases[1] = new TestCase<Integer>();
        cases[1].hArray = new ArrayExpander<Integer>(1, 2, 7, 10);
        cases[1].setExpected(-1);
        cases[1].setActual(cases[1].hArray.find(13));

        TestCase.runTests(cases);
    }

    // test insertAt
    public static void testInsertFirst() {
        System.out.print("testing insertFirst method...");

        TestCase[] cases = new TestCase[2];

        cases[0] = new TestCase<String>();
        cases[0].hArray = new ArrayExpander<Integer>(3, 5, 7, 10);
        cases[0].hArray.insertFirst(13);
        cases[0].setExpected("[ 13 3 5 7 10]");
        cases[0].setActual(cases[0].hArray.toString());

        cases[1] = new TestCase<String>();
        cases[1].hArray = new ArrayExpander<Integer>(3, 5, 7, 10);
        cases[1].hArray.insertFirst(13);
        cases[1].hArray.insertFirst(16);
        cases[1].hArray.insertFirst(19);
        cases[1].setExpected("[ 19 16 13 3 5 7 10]");
        cases[1].setActual(cases[1].hArray.toString());

        TestCase.runTests(cases);
    }

    // test insertAt
    public static void testInsertAt() {
        System.out.print("testing insertAt method...");

        TestCase[] cases = new TestCase[3];

        cases[0] = new TestCase<String>();
        cases[0].hArray = new ArrayExpander<Integer>(3, 5, 7, 10);
        cases[0].hArray.insertAt(1, 13);
        cases[0].setExpected("[ 3 13 5 7 10]");
        cases[0].setActual(cases[0].hArray.toString());

        cases[1] = new TestCase<String>();
        cases[1].hArray = new ArrayExpander<Integer>(3, 5, 7, 10);
        cases[1].hArray.insertAt(4, 13);
        cases[1].setExpected("[ 3 5 7 10 13]");
        cases[1].setActual(cases[1].hArray.toString());

        cases[2] = new TestCase<String>();
        cases[2].hArray = new ArrayExpander<Integer>(3, 5, 7, 10);
        cases[2].hArray.insertAt(6, 13);
        cases[2].setExpected("[ 3 5 7 10]");
        cases[2].setActual(cases[2].hArray.toString());

        TestCase.runTests(cases);
    }

    // test clear method
    public static void testClear() {
        System.out.print("testing clear method...");

        TestCase[] cases = new TestCase[1];

        cases[0] = new TestCase<String>();
        cases[0].hArray = new ArrayExpander<Integer>(3, 5, 7, 10);
        cases[0].hArray.clear();
        cases[0].setExpected("[]");
        cases[0].setActual(cases[0].hArray.toString());

        TestCase.runTests(cases);
    }

    // test size method
    public static void testSize() {
        System.out.print("testing size method...");

        TestCase[] cases = new TestCase[1];

        cases[0] = new TestCase<Integer>();
        cases[0].hArray = new ArrayExpander<String>("m", "t", "g");
        cases[0].setExpected(3);
        cases[0].setActual(cases[0].hArray.size());

        TestCase.runTests(cases);
    }

    // test toArray method
    public static void testToArray() {
        System.out.print("testing to array method...");

        TestCase[] cases = new TestCase[1];

        cases[0] = new TestCase<String[]>();
        cases[0].hArray = new ArrayExpander<String>("m", "t", "g");
        cases[0].setExpected(new String[]{"m", "t", "g"});
        cases[0].setActual(cases[0].hArray.toArray());

        TestCase.runArrayTest(cases);
    }

    // test constructor with list
    private static void testConstructorList() {
        System.out.print("testing constructor with values...");

        TestCase[] cases = new TestCase[2];

        cases[0] = new TestCase<String>();
        cases[0].hArray = new ArrayExpander<Integer>(5, 3, 6);
        cases[0].setExpected("[ 5 3 6]");
        cases[0].setActual(cases[0].hArray.toString());

        cases[1] = new TestCase<String>();
        cases[1].hArray = new ArrayExpander<String>("m", "t", "g");
        cases[1].setExpected("[ m t g]");
        cases[1].setActual(cases[1].hArray.toString());

        TestCase.runTests(cases);
    }

    // test insertList method
    private static void testInsertList() {
        System.out.print("testing insertList method...");

        TestCase[] cases = new TestCase[1];

        cases[0] = new TestCase<String>();
        cases[0].hArray = new ArrayExpander<Integer>(3);
        cases[0].hArray.insertList(5, 3, 6);
        cases[0].setExpected("[ 5 3 6]");
        cases[0].setActual(cases[0].hArray.toString());

        TestCase.runTests(cases);
    }

     // test insert method
     private static void testInsert() {
        System.out.print("testing insert method...");

        TestCase[] cases = new TestCase[2];

        cases[0] = new TestCase<String>();
        cases[0].hArray = new ArrayExpander<Integer>(3);
        cases[0].hArray.insert(5);
        cases[0].hArray.insert(3);
        cases[0].hArray.insert(6);
        cases[0].setExpected("[ 5 3 6]");
        cases[0].setActual(cases[0].hArray.toString());

        cases[1] = new TestCase<String>();
        cases[1].hArray = new ArrayExpander<Integer>(2);
        cases[1].hArray.insert(5);
        cases[1].hArray.insert(3);
        cases[1].hArray.insert(6);
        cases[1].hArray.insert(6);
        cases[1].setExpected("[ 5 3 6 6]");
        cases[1].setActual(cases[1].hArray.toString());

        TestCase.runTests(cases);
    }

    // test constructor with size
    private static void testConstructorSize() {
        System.out.print("testing constructor with size...");
        TestCase[] cases = new TestCase[2];

        cases[0] = new TestCase<String>();
        cases[0].hArray = new ArrayExpander<Integer>(5);
        cases[0].setExpected("[]");
        cases[0].setActual(cases[0].hArray.toString());

        cases[1] = new TestCase<String>();
        cases[1].hArray = new ArrayExpander<String>(5);
        cases[1].setExpected("[]");
        cases[1].setActual(cases[0].hArray.toString());

        TestCase.runTests(cases);
    }

}

// TestCase Class
class TestCase<T> {

    // colors for console
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    // test result messages
    public static final String TEST_PASS = " " + ANSI_GREEN + "PASS" + ANSI_RESET;
    public static final String TEST_FAIL = " " + ANSI_RED + "FAIL" + ANSI_RESET;

    // class attributes
    ArrayExpander hArray;
    T expected;
    T actual;

    public void setExpected(T exp) {
        this.expected = exp;
    }

    public void setActual(T ac) {
        this.actual = ac;
    }

    public static void runTests(TestCase[] cases) {
        boolean pass = true;
        for(int i = 0; i < cases.length; i++) {
            if(cases[i].expected == null && cases[i].actual == null)
                continue;
            if(cases[i].expected == null && cases[i].expected != cases[i].actual) {
                System.out.print(TEST_FAIL + (i+1));
                pass = false;
                cases[i] = null;
                continue;
            }
            if(!cases[i].expected.equals(cases[i].actual)) {
                System.out.print(TEST_FAIL + (i+1));
                pass = false;
                System.out.println(cases[i].actual);
            }
            cases[i] = null;
        }
        if(pass)
            System.out.print(TEST_PASS);
        System.out.println();
    }

    public static void runArrayTest(TestCase<String[]>[] cases) {
        boolean pass = true;
        for(int i = 0; i < cases.length; i++) {
            if(!Arrays.equals(cases[i].expected, cases[i].actual)) {
                System.out.print(TEST_FAIL + (i+1));
                pass = false;
            }
            cases[i] = null;
        }
        if(pass)
            System.out.print(TEST_PASS);
        System.out.println();
    }

}