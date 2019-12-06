import java.util.Scanner;

public class HashTableChainingPersonTest {

    private HashTableChaining<String, Person> theHashTable;
    
    public HashTableChainingPersonTest() {
        theHashTable = new HashTableChaining<String, Person>();
        
        theHashTable.insert(new DataItem<String, Person>("1", new Person("Maher", 20, 180.0)));
        theHashTable.insert(new DataItem<String, Person>("2", new Person("Anas", 20, 180.0)));
        theHashTable.insert(new DataItem<String, Person>("3", new Person("Osama", 20, 180.0)));
        theHashTable.insert(new DataItem<String, Person>("4", new Person("Omar", 20, 180.0)));

        theHashTable.print();
    }

    public void menu() {
        DataItem<String, Person> aDataItem;
        String key;
        String info;
        Scanner Console = new Scanner(System.in);
        while (true) {
            System.out.print("(p)rint (i)nsert (d)elete (f)ind (q)uit: ");
            char choice = Console.nextLine().charAt(0);
            switch (choice) {
            case 'p':
                theHashTable.print();
                break;

            case 'i':
                System.out.print("Enter key value: ");
                key = Console.nextLine();
                System.out.println("Enter info value: ");
                Person p = new Person();
                p.scan();
                aDataItem = new DataItem<String, Person>(key, p);
                theHashTable.insert(aDataItem);
                break;

            case 'd':
                System.out.print("Enter key value to delete: ");
                key = Console.nextLine();
                DataItem<String, Person> d = theHashTable.delete(key);
                if (d == null) {
                    System.out.println("Not Deleted..");
                }
                break;

            case 'f':
                System.out.print("Enter key value to find: ");
                key = Console.nextLine();
                aDataItem = theHashTable.find1(key);

                if (aDataItem != null) {
                    System.out.println("Found " + aDataItem);
                } else {
                    System.out.println("Could not find " + key);
                }
                break;

            case 'q':
                return;
            default:
                System.out.println("Invalid entry\n");
            }
        }
    }

    public static void main(String[] args) {
        HashTableChainingPersonTest test = new HashTableChainingPersonTest();

        test.menu();
    }
}