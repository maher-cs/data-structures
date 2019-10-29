import java.util.Scanner;

public class StackBracketTest {

    private final String[] BRACKETS = {"(", ")", "[", "]", "{", "}"};
    private String expression;

    // default constructor
    public StackBracketTest() {
        this.expression = null;
    }

    // constructor with parameters
    public StackBracketTest(String expression) {
        this.expression = expression;
    }

    // setter
    public void setExpression(String exp) {
        this.expression = exp;
    }

    // check if brackets are matching
    public boolean check() {
        int expSize = this.expression.length();
        StackArray<String> theStack = new StackArray(expSize);

        for(int i = 0; i < expSize; i++) {
            String bracket = this.expression.charAt(i) + "";
            if(this.isNotBracket(bracket)) {
                continue;
            } else if (this.isOpeningBracket(bracket)) {
                theStack.push(bracket);
            } else if (this.isClosingBracket(bracket)) {
                String top = theStack.pop();
                if(!this.isClosingBracketFor(top, bracket)) {
                    return false;
                }
                
            }
        }

        if(!theStack.isEmpty()) {
            return false;
        }

        return true;
    }

    // return index of the bracket in the constant array of bracket
    // for logic reasons:
    // [isClosingBracket: if index is odd]
    // [isOpeningBracket: if index is even]
    // [isClosingBracketFor: if index of open + 1 == index of close]
    // [isNotBracket: if index is -1]
    private int indexOf(String input) {
        // System.out.println(input);
        for(int i = 0; i < this.BRACKETS.length; i++) {
            if(input.equals(this.BRACKETS[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean isClosingBracket(String bracket) {
        return this.indexOf(bracket) % 2 == 1;
    }

    private boolean isClosingBracketFor(String open, String close) {
        if(open == null || close == null) {
            System.out.println("isClosingBracketFor: false");
            return false;
        }
        return ((this.indexOf(open)+1) == this.indexOf(close));
    }

    private boolean isOpeningBracket(String bracket) {
        return this.indexOf(bracket) % 2 == 0;
    }

    private boolean isNotBracket(String bracket) {
        return this.indexOf(bracket) == -1;
    }

    public static void test() {
        // colors for console
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";
        
        // class to test
        StackBracketTest sb = new StackBracketTest();

        // testing data and expected results
        String[] exp = {"([{}][])", "([{}][)", "([{}]])", "({aa[}]c)", "[][][]"};
        boolean[] expected = {true, false, false, false, true};

        // run tests
        for(int i = 0; i < exp.length; i++) {
            System.out.print("testing " + exp[i] + "...");
            sb.setExpression(exp[i]);
            boolean actual = sb.check();
            if(actual == expected[i]) {
                System.out.println(ANSI_GREEN + "PASS" + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + "FAIL: " + ANSI_RESET + actual);
            }
        }

    }
    public static void main(String[] args) {

        // test();

        Scanner in = new Scanner(System.in);
        String input = "";
        StackBracketTest sb = new StackBracketTest();

        do {
            System.out.print("Enter the expression: ");
            input = in.nextLine();
            System.out.println();
            if(!input.equals("")) {
                sb.setExpression(input);
                boolean isMatch = sb.check();
                if(isMatch) {
                    System.out.println("the expression is correct!");
                } else {
                    System.out.println("the expression is NOT correct");
                }
            }
        } while(!input.equals(""));
        
        
        
    }
}