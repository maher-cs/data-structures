public class TreePerformanceTest {

    public static Integer[] generateNumbersArray(int elements) {

        Integer[] array = new Integer[elements];
        for (int i = 0; i < elements; i++) {
            array[i] = (Integer) (int) (Math.random() * 100);
        }
        return array;
    }

    public static double testMethod(int methodNumber, int n) {
        
        Integer[] array = generateNumbersArray(n);

        Tree<Integer> tree = new Tree<Integer>(array);

        double starttime = System.nanoTime();
        switch (methodNumber) {
        case 1:
            tree.find(array[(int) (Math.random() * n)]);
        }
        double endtime = System.nanoTime();
        return ((endtime - starttime) / 1000000);
    }

    public static void runTest() {
        int[] nArray = { 100, 1000, 100000, 1000000 };
        String[] titles = {"find"};
        int[] methodsID = {1};

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