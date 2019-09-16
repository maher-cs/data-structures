import java.util.Scanner;

public class DateMain {
    public static void main(String[] args) {

        // for coloring output on console
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_RESET = "\u001B[0m";

        Date date;

        // Initializing Tests
        System.out.println(ANSI_YELLOW + "<< Initializing tests: >>" + ANSI_RESET);
        System.out.println();

        System.out.println("case 1:" + "EMPTY CONSTRUCTOR");
        date = new Date();
        System.out.println(date);
        System.out.println("=========\n");

        System.out.println("case 2:" + "2,5,1990");
        date = new Date(2,5,1990);
        System.out.println(date);
        System.out.println("=========\n");

        System.out.println("case 3:" + "-1,-1,-3");
        date = new Date(-1,-1,-3);
        System.out.println(date);
        System.out.println("=========\n");

        System.out.println("case 4:" + "2-5-1990");
        date = new Date("2-5-1990");
        System.out.println(date);
        System.out.println("=========\n");

        // commented because it throws error string to integer
        // System.out.println("case 5:" + "fdas-fdsa-fdsa");
        // date = new Date("fdas-fdsa-fdsa");
        // System.out.println(date);
        // System.out.println("=========\n");

        System.out.println("case 6:" + "191040");
        date = new Date("191040");
        System.out.println(date);
        System.out.println("=========\n");
        
        System.out.println("case 7:" + "31,2, 10000");
        date = new Date(31,2, 10000);
        System.out.println(date);
        System.out.println("=========\n");

        System.out.println("#######################");
        // Operation methods test
        System.out.println(ANSI_YELLOW + "<< Operations tests: >>" + ANSI_RESET);
        System.out.println();
        date = new Date(29,7,2017);

        // add days
        int[] testDays = {40, 800, 50000, 1000000, -5, -100, -700, -11000, -250000};        
        for(int days : testDays) {
            System.out.println("add days: " + "(29-7-2017): " + days);
            date.addDays(days);
            System.out.println(date);
            System.out.println("=========\n");

            date = new Date(29,7,2017);
        }

    }
}