public class Student implements Comparable<Student> {

    // static constants
    public static final int PASS_MARK = 60;

    // class attributes
    private String name;
    private int id;
    private int mark;

    // static variables
    private static int idCounter;

    // default constructor
    public Studnet() {
        this.setName("NO_NAME");
        this.setId();
        this.setMark(0);
    }
    // constructor with mark input
    public Student(int mark) {
        this.setName("NO_NAME");
        this.setId();
        this.setMark(mark);
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

    public void setMark(int mark) {
        if(isValidMark(mark)) {
            this.mark = mark;
        } else {
            this.mark = 0;
            System.err.println("invalid mark: " + mark + "!");
        }
    }

    // private setter for id
    public void setId() {
        this.id = ++this.idCounter;
    }

    // getters
    public String getName() {
        return this.name;
    }
    public int getId() {
        return this.id;
    }
    public int getMark() {
        return this.mark;
    }

    // compareTo method based on mark
    @Override
    public int compareTo(Student other) {
        if(this.getMark() > other.getMark()) {
            return 1;
        }
        if(this.getMark() < other.getMark()) {
            return -1;
        }
        return 0;
    }

    // validation methods
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

    private boolean isValidMark(int mark) {
        final int MAX_MARK = 100;
        final int MIN_MARK = 0;
        if(mark < MIN_MARK) {
            System.err.println("the mark " + mark + " less than " + MIN_MARK + "!");
            return false;
        }
        if(mark > MAX_MARK) {
            System.err.println("the age " + mark + " is more than " + MAX_MARK + "!");
            return false;
        }
        return true;
    }
    
}