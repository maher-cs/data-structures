public class HighArrayPerformanceTest {

    public static HighArray<Integer> generateNumbersArray(int elements) {
        HighArray<Integer> output = new HighArray(elements*2);
        for(int i = 0; i < elements; i++) {
            output.insert((int) Math.random());
        }
        return output;
    }

    public static double testMethod(int methodNumber, int n) {
        HighArray<Integer> numbers = generateNumbersArray(n);
        numbers.bubbleSort();
        double starttime = System.nanoTime();
        switch(methodNumber) {
            case 1:
                numbers.insertOrdered(5);
                break;
            case 2:
                numbers.insert(5);
                break;
            case 3:
                numbers.find(5);
                break;
            case 4:
                numbers.binarySearch(5);
                break;
        }
        double endtime = System.nanoTime();
        return ((endtime - starttime) / 1000000);
    }
    
    public static void runTest() {
        int[] nArray = {100, 1000, 100000, 1000000};
        int method;
    
        // method 1
        method = 1;
        System.out.println("Method insertOrdered: ");
        for(int i : nArray) {
            System.out.println("" + i + ": " + testMethod(method, i) + " ms");
        }
        System.out.println("===========\n");
    
        // method 2
        method = 2;
        System.out.println("Method insert:");
        for(int i : nArray) {
            System.out.println("" + i + ": " + testMethod(method, i) + " ms");
        }
        System.out.println("===========\n");
    
        // method 3
        method = 3;
        System.out.println("Method linearSearch: ");
        for(int i : nArray) {
            System.out.println("" + i + ": " + testMethod(method, i) + " ms");
        }
        System.out.println("===========\n");

        // method 4
        method = 4;
        System.out.println("Method binarySearch: ");
        for(int i : nArray) {
            System.out.println("" + i + ": " + testMethod(method, i) + " ms");
        }
        System.out.println("===========\n");
    }
    
    public static void main(String[] args) {
        runTest();
    }
}