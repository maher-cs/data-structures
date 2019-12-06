import java.util.*;

class TreeApp {
    public static void main(String[] args) {
        Integer value;
        Tree<Integer> theTree = new Tree<Integer>();

        theTree.insert(50);
        theTree.insert(25);
        theTree.insert(75);
        theTree.insert(12);
        theTree.insert(37);
        theTree.insert(43);
        theTree.insert(30);
        theTree.insert(33);
        theTree.insert(87);
        theTree.insert(93);
        theTree.insert(97);

        while (true) {
            System.out.print("Enter first letter of show, ");
            System.out.print("insert, find, delete, or traverse: ");
            Scanner in = new Scanner(System.in);

            char choice = in.next().charAt(0);
            switch (choice) {
            case 's':
                theTree.displayTree();
                break;
            case 'i':
                System.out.print("Enter value to insert: ");
                value = (Integer) in.nextInt();
                theTree.insert(value);
                break;
            case 'f':
                System.out.print("Enter value to find: ");
                value = (Integer) in.nextInt();
                TNode<Integer> found = theTree.find(value);
                if (found != null) {
                    System.out.print("Found: ");
                    System.out.println(found);
                    System.out.print("\n");
                } else
                    System.out.print("Could not find ");
                System.out.print(value + '\n');
                break;
            case 'd':
                System.out.print("Enter value to delete: ");
                value = (Integer) in.nextInt();
                boolean didDelete = theTree.delete(value);
                if (didDelete)
                    System.out.print("Deleted " + value + '\n');
                else
                    System.out.print("Could not delete ");
                System.out.print(value + '\n');
                break;
            case 't':
                System.out.print("Enter type 1, 2 or 3: ");
                value = (Integer) in.nextInt();
                theTree.traverse(value);
                break;
            default:
                System.out.print("Invalid entry\n");
            }
        }
    }

}
