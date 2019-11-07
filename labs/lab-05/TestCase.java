// TestCase Class
public class TestCase<T> {

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
                System.out.println(": " + cases[i].actual);
                pass = false;
            }
            cases[i] = null;
        }
        if(pass)
            System.out.print(TEST_PASS);
        System.out.println();
    }

}