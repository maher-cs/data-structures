public class FibPerformanceTest {

    public static double testMethod(int methodNumber, int n) {

        double starttime = System.nanoTime();
        switch (methodNumber) {
        case 1:
            Fibonacci.fibR(n);
        case 2:
            Fibonacci.fibN(n);
        }
        double endtime = System.nanoTime();
        return ((endtime - starttime) / 1000000);
    }

    public static void runTest() {
        int[] nArray = { 1, 2, 4, 8, 16 };
        String[] titles = {"fib-recursive", "fib-non-recursive"};
        int[] methodsID = {1, 2};

        for (int i = 0; i < methodsID.length; i++) {
            int method = methodsID[i];
            String title = titles[i];
            System.out.println(title + ": ");
            for (int j : nArray) {
                System.out.println("" + j + ": " + testMethod(method, j) + " ms");
            }
            System.out.println("===========\n");
        }
    }

    public static void main(String[] args) {
        runTest();
    }
}