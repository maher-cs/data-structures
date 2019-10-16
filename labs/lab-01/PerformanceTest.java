public class PerformanceTest {

    public static void linearTest(long n) {
        long loopcount = 0;
        double starttime = System.currentTimeMillis();
        System.out.print("O(" + n + ") took.. ");
        for (long i = 0; i < n; i++)
            loopcount++;
        double endtime = System.currentTimeMillis();
        System.out.println(((endtime - starttime) / 1000) + " seconds");
        System.out.println("loops count: " + loopcount);
        System.out.println("============");
    }

    public static void quadraticTest(long n) {
        long loopcount = 0;
        double starttime = System.currentTimeMillis();
        System.out.print("O(" + n + "^2) took.. ");
        for (long i = 0; i < n; i++)
            for (long j = 0; j < n; j++)
                loopcount++;
        double endtime = System.currentTimeMillis();
        System.out.println(((endtime - starttime) / 1000) + " seconds");
        System.out.println("loops count: " + loopcount);
        System.out.println("============");
    }

    public static void cubicTest(long n) {
        long loopcount = 0;
        double starttime = System.currentTimeMillis();
        System.out.print("O(" + n + "^3) took.. ");
        for(long i = 0; i < n; i++)
            for(long j = 0; j < n; j++)
                for(long k = 0; k < n; k++)
                    loopcount++;
        double endtime = System.currentTimeMillis();
        System.out.println(((endtime - starttime) / 1000) + " seconds");
        System.out.println("loops count: " + loopcount);
        System.out.println("============");
    }

    public static void main(String[] args) {
        long n;

        n = 1000;
        System.out.println("n = " + n);
        linearTest(n);
        quadraticTest(n);
        cubicTest(n);
        System.out.println("##############\n");

        n = 10000;
        System.out.println("n = " + n);
        linearTest(n);
        quadraticTest(n);
        cubicTest(n);
        System.out.println("##############\n");
    }
}