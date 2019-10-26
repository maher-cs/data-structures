public class HighArrayPersonTest {
    public static void main(String[] args) {
        Person p1 = new Person("maher", 20, 180);
        Person p2 = new Person("ahmad", 24, 175);
        Person p3 = new Person("majed", 23, 185);
        Person p4 = new Person("omar", 18, 170);

        HighArray<Person> hArray = new HighArray(p1, p2, p3, p4);
        System.out.println(hArray);
        
    }
}