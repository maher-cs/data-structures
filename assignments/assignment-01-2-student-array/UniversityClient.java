import java.util.Arrays;

public class UniversityClient {

    // class attributes
    private String name;
    private Student[] students;

    // constructors
    public UniversityClient() {
        this.setName("NO_NAME");
    }
    public UniversityClient(int numberOfStudents) {
        this.setName("NO_NAME");
        this.setNumberOfStudents(numberOfStudents);
    }
    public UniversityClient(String name, int numberOfStudents) {
        this.setName(name);
        this.setNumberOfStudents(numberOfStudents);
    }

    // setters
    public void setName(String name) {
        if(isValidName(name)) {
            this.name = name;
        } else {
            this.name = "NO_NAME";
            System.err.println("invalid name: " + name + "!");
        }
    }
    public void setNumberOfStudents(int numberOfStudents) {
        this.students = new Student[numberOfStudents];
        this.createStudentsObjects();
    }

    // getters
    public String getName() {
        return this.name;
    }
    public int getNumberOfStudents() {
        return this.students.length;
    }

     // ## fill marks method with immutibilty
    public void fillStudentsMarks(int[] studentsMarks) {
        for(int i = 0; i < studentsMarks.length; i++) {
            this.students[i].setMark(studentsMarks[i]);
        }
        this.sortStudentsByMark();
    }

    // ## report method
    public String createReport() {
        String output = "";
        output += "number of students: " + getNumberOfStudents() + "\n";
        output += String.format("avarage: %.2f\n", getAvarageOfMarks() );
        output += "number of faild students: " + getNumberOfFaildStudents() + "\n";
        output += "number of students above the avarage: " + getNumberOfAboveMark((int) getAvarageOfMarks()) + "\n";
        output += "max mark: " + getMaxMark().getMark() + "\n";
        output += "min mark: " + getMinMark().getMark() + "\n";

        return output;
    }

    // ## operations methods

    private double getAvarageOfMarks() {
        double avarage = getMarksSum() / (double) getNumberOfStudents();
        return avarage;
    }

    private int getNumberOfFaildStudents() {
        int faild = getNumberOfStudents() - getNumberOfAboveMark(Student.PASS_MARK - 1);
        return faild;
    }

    private int getNumberOfAboveMark(int mark) {
        int counter = 0;
        for(Student student : students) {
            if(student.getMark() > mark)
                counter++;
        }
        return counter;
    }

    private int getMarksSum() {
        int sum = 0;
        for(Student student : students) {
            sum += student.getMark();
        }
        return sum;
    }

    private Student getMaxMark() {
        return students[getNumberOfStudents() - 1];
    }

    private Student getMinMark() {
        return students[0];
    }

    // ## utils methods
    private void sortStudentsByMark() {
        Arrays.sort(students);
    }

    private void createStudentsObjects() {
        for(int i = 0; i < getNumberOfStudents(); i++) {
            students[i] = new Student();
        }
    }

    // ## validation methods
    private boolean isValidName(String name) {
        final int MAX_LENGHT = 56;
        final int MIN_LENGTH = 3;
        if(name.length() < MIN_LENGTH) {
            System.err.println("the name " + name + " is too short!");
            return false;
        }
        if(name.length() > MAX_LENGHT) {
            System.err.println("the name " + name + " is too long!");
            return false;
        }
        return true;
    }
}