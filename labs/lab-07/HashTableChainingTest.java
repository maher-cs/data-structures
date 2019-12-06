import java.util.Scanner;

public class HashTableChainingTest {

    private HashTableChaining<String, String> theHashTable;
    
    public HashTableChainingTest() {
        theHashTable = new HashTableChaining<String, String>();
        
        theHashTable.insert(new DataItem<String, String>("1", "aiden"));
        theHashTable.insert(new DataItem<String, String>("2", "tom"));
        theHashTable.insert(new DataItem<String, String>("3", "fred"));
        theHashTable.insert(new DataItem<String, String>("4", "kieran"));

        theHashTable.print();
    }

    public void menu() {
        DataItem<String, String> aDataItem;
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
                System.out.print("Enter info value: ");
                info = Console.nextLine();
                aDataItem = new DataItem<String, String>(key, info);
                theHashTable.insert(aDataItem);
                break;

            case 'd':
                System.out.print("Enter key value to delete: ");
                key = Console.nextLine();
                DataItem<String, String> d = theHashTable.remove(key);
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
        HashTableChainingTest test = new HashTableChainingTest();

        test.menu();
    }
}