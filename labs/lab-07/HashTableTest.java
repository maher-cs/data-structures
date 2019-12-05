import java.util.Scanner;

public class HashTableTest {

    private HashTableLinear<String, String> theHashTable;
    
    public HashTableTest() {
        theHashTable = new HashTableLinear<String, String>();
        
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
                if(theHashTable.isFull()) {
                    System.out.println("the table is full");
                    break;
                }
                System.out.print("Enter key value: ");
                key = Console.nextLine();
                System.out.print("Enter info value: ");
                info = Console.nextLine();
                aDataItem = new DataItem<String, String>(key, info);
                int result = theHashTable.insert(aDataItem);
                if(result < 0) {
                    switch(result) {
                        case -1:
                            System.out.println("the table is full");
                            break;
                        case -2:
                            System.out.println("the element is already exist");
                            break;
                    }
                }
                break;

            case 'd':
                System.out.print("Enter key value to delete: ");
                key = Console.nextLine();
                DataItem<String, String> d = theHashTable.delete(key);
                if (d == null) {
                    System.out.println("Not Deleted..");
                }
                break;

            case 'f':
                System.out.print("Enter key value to find: ");
                key = Console.nextLine();
                aDataItem = theHashTable.find(key);

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
        HashTableTest test = new HashTableTest();

        test.menu();
    }
}