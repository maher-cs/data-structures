public class QueueStackPerformanceTest {

    public static Integer[] generateNumbersArray(int elements) {

        Integer[] array = new Integer[elements];
        for (int i = 0; i < elements; i++) {
            array[i] = (Integer) (int) (Math.random() * 100);
        }
        return array;
    }

    public static double testMethod(int methodNumber, int n) {
        StackArray<Integer> stackA = new StackArray<Integer>(n);
        StackLinkList<Integer> stackL = new StackLinkList<Integer>();
        QueueArray<Integer> queueA = new QueueArray<Integer>(n);
        QueueLinkList<Integer> queueL = new QueueLinkList<Integer>();

        Integer[] array = generateNumbersArray(n);

        double starttime = System.nanoTime();
        switch (methodNumber) {
        case 1:
            for (int i = 0; i < n; i++)
                stackA.push(array[i]);
        case 2:
            for (int i = 0; i < n; i++)
                stackL.push(array[i]);
        case 3:
            for (int i = 0; i < n; i++)
                stackA.pop();
        case 4:
            for (int i = 0; i < n; i++)
                stackL.pop();
        case 5:
            for (int i = 0; i < n; i++)
                queueA.enqueue(array[i]);
        case 6:
            for (int i = 0; i < n; i++)
                queueL.enqueue(array[i]);
        case 7:
            for (int i = 0; i < n; i++)
                queueA.dequeue();
        case 8:
            for (int i = 0; i < n; i++)
                queueL.dequeue();
        }
        double endtime = System.nanoTime();
        return ((endtime - starttime) / 1000000);
    }

    public static void runTest() {
        int[] nArray = { 100, 1000, 100000, 1000000 };
        String[] titles = { "StackArray push", "StackLinkList push", "StackArray pop", "StackLinkList pop",
                "QueueArray enqueue", "QueueLinkList enqueue", "QueueArray dequeue", "QueueLinkList dequeue" };
        int[] methodsID = { 1, 2, 3, 4, 5, 6, 7, 8 };

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