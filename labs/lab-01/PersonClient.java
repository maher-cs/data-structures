public class PersonClient {
    public static void main(String[] args) {

        Person p;

        // case-01: dafault constructor and toString
        System.out.println("Test 01: dafault constructor and toString:");
        p = new Person();
        System.out.println(p);
        System.out.println("==========\n");

        // case-02: constructor with parameters
        System.out.println("Test 02: constructor with parameters:");
        p = new Person("Maher", 20, 180);
        System.out.println(p);
        System.out.println("==========\n");

        // case-03: with invalid parameters 1
        System.out.println("Test 03: with invalid parameters 1:");
        p = new Person("Ma", -1, 40);
        System.out.println(p);
        System.out.println("==========\n");

        // case-04: with invalid parameters 2
        System.out.println("Test 03: with invalid parameters 2:");
        p = new Person("Lorem-ipsum-dolor-sit-amet-consectetur-adipiscing-elit-in-felis-auctor,-pharetra-molestie-tempor-fermentum", 160, 350);
        System.out.println(p);
        System.out.println("==========\n");

    }
}