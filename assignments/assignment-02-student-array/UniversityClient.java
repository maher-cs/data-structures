import java.util.Arrays;
import java.util.Scanner;

public class UniversityClient {
    private static Student[] students;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

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

        students = new Student[numberOfStudents];
        createStudentsObjects();

        switch(choice) {
            case 1:
                enterMarks();
                break;
            case 2:
                createRandomMarks();
                break;
        }

        System.out.println("\n===========\n");

        Arrays.sort(students);

        claculateAllAndPrint();

    }

    // ## claculate method
    private static void claculateAllAndPrint() {
        System.out.println("Statistics: ");

        String output = "";
        output += "number of students: " + students.length + "\n";
        output += String.format("avarage: %.2f\n", getAvarageOfMarks() );
        output += "number of faild students: " + getNumberOfFaildStudents() + "\n";
        output += "number of students above the avarage: " + getNumberOfAboveMark((int) getAvarageOfMarks()) + "\n";
        output += "max mark: " + getMaxMark().getMark() + "\n";
        output += "min mark: " + getMinMark().getMark() + "\n";

        System.out.println(output);
        
    }

    // ## fill data methods

    private static void enterMarks() {
        Scanner in = new Scanner(System.in);
        
        for(Student student : students) {
            System.out.print("Enter mark for " + student.getId() + " student: ");
            student.setMark(in.nextInt());
        }
    }

    private static void createRandomMarks() {
        for(Student student : students) {
            student.setMark( (int) (Math.random() * 101) );
            System.out.println("mark for " + student.getId() + " student: " + student.getMark());
        }
    }

    // ## operations methods

    private static double getAvarageOfMarks() {
        double avarage = getMarksSum() / (double) students.length;
        return avarage;
    }

    private static int getNumberOfFaildStudents() {
        int faild = students.length - getNumberOfAboveMark(Student.PASS_MARK - 1);
        return faild;
    }

    private static int getNumberOfAboveMark(int mark) {
        int counter = 0;
        for(Student student : students) {
            if(student.getMark() > mark)
                counter++;
        }
        return counter;
    }

    private static int getMarksSum() {
        int sum = 0;
        for(Student student : students) {
            sum += student.getMark();
        }
        return sum;
    }

    private static Student getMaxMark() {
        return students[students.length - 1];
    }

    private static Student getMinMark() {
        return students[0];
    }

    private static void createStudentsObjects() {
        for(int i = 0; i < students.length; i++) {
            students[i] = new Student();
        }
    }
}