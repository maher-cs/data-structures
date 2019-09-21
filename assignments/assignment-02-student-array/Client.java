import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        UniversityClient university = new UniversityClient();

        System.out.println("Welcome to University Students Program:");
        System.out.println("input 1: for entering student manualy.");
        System.out.println("input 2: for get random marks.");
        System.out.print(">>> ");
        byte choice = in.nextByte();

        if(choice != 1 && choice != 2) {
            System.err.println("invalid choice number!");
            return;
        }

        System.out.print("Enter the number of students: ");
        int numberOfStudents = in.nextInt();
        university.setNumberOfStudents(numberOfStudents);

        switch(choice) {
            case 1:
                enterMarks(university);
                break;
            case 2:
                createRandomMarks(university);
                break;
        }

        System.out.println("\n===========\n");

        System.out.println( university.createReport() );
    }

    public static void enterMarks(UniversityClient university) {
        Scanner in = new Scanner(System.in);
        int[] studentsMarks = new int[university.getNumberOfStudents()];
        for(int i = 0; i < studentsMarks.length; i++) {
            System.out.print("Enter mark for #" + (i+1) + " student: ");
            studentsMarks[i] = in.nextInt();
        }
        university.fillStudentsMarks(studentsMarks);
    }

    public static void createRandomMarks(UniversityClient university) {
        final int MAX_MARK = 100;
        int[] studentsMarks = new int[university.getNumberOfStudents()];
        for(int i = 0; i < studentsMarks.length; i++) {
            studentsMarks[i] = ( (int) (Math.random() * (MAX_MARK + 1)) );
            System.out.println("mark for #" + (i+1) + " student: " + studentsMarks[i]);
        }
        university.fillStudentsMarks(studentsMarks);
    }
}