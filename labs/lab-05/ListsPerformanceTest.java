public class ListsPerformanceTest {

    public static Integer[] generateNumbersArray(int elements) {

        Integer[] array = new Integer[elements];
        for (int i = 0; i < elements; i++) {
            array[i] = (Integer) (int) (Math.random() * 100);
        }
        return array;
    }

    public static double testMethod(int methodNumber, int n) {
        LinkList<Integer> normalList = new LinkList<Integer>();
        FirstLastLinkList<Integer> flList = new FirstLastLinkList<Integer>();
        CircularDoublyLinkList<Integer> cdList = new CircularDoublyLinkList<Integer>();

        int fact = 4;

        Integer[] array = generateNumbersArray(n);

        double starttime = System.nanoTime();
        switch (methodNumber) {
        case 1:
            for (int i = 0; i < n; i++)
                normalList.insertFirst(array[i]);
        case 2:
            for (int i = 0; i < n; i++)
                flList.insertFirst(array[i]);
        case 3:
            for (int i = 0; i < n; i++)
                cdList.insertFirst(array[i]);
        case 4:
            for (int i = 0; i < n; i++)
                normalList.insertLast(array[i]);
        case 5:
            for (int i = 0; i < n; i++)
                flList.insertLast(array[i]);
        case 6:
            for (int i = 0; i < n/fact; i++)
                cdList.insertLast(array[i]);
        case 7:
            for (int i = 0; i < n/fact; i++)
                normalList.delete(array[i]);
        case 8:
            for (int i = 0; i < n/fact; i++)
                flList.delete(array[i]);
        case 9:
            for (int i = 0; i < n/fact; i++)
                cdList.delete(array[i]);
        case 10:
            for (int i = 0; i < n/fact; i++)
                normalList.deleteFirst();
        case 11:
            for (int i = 0; i < n/fact; i++)
                flList.deleteFirst();
        case 12:
            for (int i = 0; i < n/fact; i++)
                cdList.deleteFirst();
        case 13:
            for (int i = 0; i < n/fact; i++)
                normalList.deleteLast();
        case 14:
            for (int i = 0; i < n/fact; i++)
                flList.deleteLast();
        case 15:
            for (int i = 0; i < n/fact; i++)
                cdList.deleteLast();
        }
        double endtime = System.nanoTime();
        return ((endtime - starttime) / 1000000);
    }

    public static void runTest() {
        int[] nArray = {10, 100, 1000};
        String[] titles = { 
            "normal list insert first", "first last list insert first", "circular double list insert first",
            "normal list insert last", "first last list insert last", "circular double list insert last",
            "normal list delete", "first last list delete", "circular double list delete",
            "normal list delete first", "first last list delete first", "circular double list delete first",
            "normal list delete last", "first last list delete last", "circular double list delete last",
        };
        int[] methodsID = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

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