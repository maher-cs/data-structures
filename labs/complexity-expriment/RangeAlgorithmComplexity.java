public class RangeAlgorithmComplexity {
    public static int range1(int[] numbers) {
        int maxDiff = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                int diff = Math.abs(numbers[j] - numbers[i]);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        return maxDiff;
    }

    public static int range2(int[] numbers) {
        int maxDiff = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int diff = Math.abs(numbers[j] - numbers[i]);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        return maxDiff;
    }

    public static int range3(int[] numbers) {
        int max = numbers[0];
        int min = max;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max - min;
    }

    public static int[] generateNumbersArray(int elements) {
        int[] output = new int[elements];
        for(int i = 0; i < elements; i++) {
            output[i] = (int) Math.random();
        }
        return output;
    }

    public static double testMethod(int methodNumber, int n) {
        int[] numbers = generateNumbersArray(n);
        double starttime = System.nanoTime();
        switch(methodNumber) {
            case 1:
                range1(numbers);
                break;
            case 2:
                range2(numbers);
                break;
            case 3:
                range3(numbers);
                break;
        }
        double endtime = System.nanoTime();
        return ((endtime - starttime) / 1000000);
    }

    public static void runTest() {
        int[] nArray = {1000, 2000, 4000, 8000, 16000, 32000, 64000};
        int method;

        // method 1
        method = 1;
        System.out.println("Method " + method + ":");
        for(int i : nArray) {
            System.out.println("" + i + ": " + testMethod(method, i) + " ms");
        }
        System.out.println("===========\n");

        // method 2
        method = 2;
        System.out.println("Method " + method + ":");
        for(int i : nArray) {
            System.out.println("" + i + ": " + testMethod(method, i) + " ms");
        }
        System.out.println("===========\n");

        // method 3
        int[] nArray2 = new int[19];
        for(int i = 0; i < nArray2.length; i++) {
            nArray2[i] = 1000 *  (int) Math.pow(2, i);
        }
        method = 3;
        System.out.println("Method " + method + ":");
        for(int i : nArray2) {
            System.out.println("" + i + ": " + testMethod(method, i) + " ms");
        }
        System.out.println("===========\n");
    }

    public static void main(String[] args) {
        runTest();
    }
}