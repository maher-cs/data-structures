public class Person {

    // class attributes
    protected String name;
    protected int age;
    protected double height;

    // default constructor
    public Person() {
        this.setName("NO_NAME");
        this.setAge(0);
        this.setHeight(100);
    }

    // constructor with parameters
    public Person(String name, int age, double height) {
        this.setName(name);
        this.setAge(age);
        this.setHeight(height);
    }

    // setters
    public void setName(String name) {
        if(isValidName(name)) {
            this.name = name;
        } else {
            this.name = "";
            System.err.println("invalid name!");
        }
    }

    public void setAge(int age) {
        if(isValidAge(age)) {
            this.age = age;
        } else {
            this.age = 0;
            System.err.println("invalid age!");
        }
    }

    public void setHeight(double height) {
        if(isValidHeight(height)) {
            this.height = height;
        } else {
            this.height = 100;
            System.err.println("invalid height!");
        }
    }

    // getters
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getHeight() {
        return this.height;
    }

    // toString method
    @Override
    public String toString() {
        String output = "";
        output += "name: " + this.getName() + "\n";
        output += "age : " + this.getAge() + "\n";
        return output;
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

    private boolean isValidAge(int age) {
        final int MAX_AGE = 150;
        final int MIN_AGE = 0;
        if(age < MIN_AGE) {
            System.err.println("the age " + age + " is too small!");
            return false;
        }
        if(age > MAX_AGE) {
            System.err.println("the age " + age + " is too big!");
            return false;
        }
        return true;
    }

    private boolean isValidHeight(double height) {
        final double MAX_HEIGHT = 300;
        final double MIN_HEIGHT = 50;
        if(height < MIN_HEIGHT) {
            System.err.println("the height " + height + " is too small!");
            return false;
        }
        if(height > MAX_HEIGHT) {
            System.err.println("the height " + height + " is too large!");
            return false;
        }
        return true;
    }

}