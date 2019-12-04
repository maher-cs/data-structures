import java.util.*;

class InterIterApp {
    public static void main(String[] args) {
        LinkList<Integer> theList = new LinkList<Integer>();
        ListIterator iter1 = new ListIterator(theList);
        int value;

        iter1.insertAfter(20);
        iter1.insertAfter(40);
        iter1.insertAfter(80);
        iter1.insertBefore(60);

        while (true) {
            System.out.print("Enter first letter of show, reset, ");
            System.out.print("next, get, before, after, delete, exit: ");
            System.out.flush();
            Scanner in = new Scanner(System.in);

            char choice = in.next().charAt(0);
            switch (choice) {
            case 's':
                if (!theList.isEmpty())
                    theList.displayList();
                else
                    System.out.println("List is empty");
                break;
            case 'r':
                iter1.reset();
                break;
            case 'n':
                if (!theList.isEmpty() && !iter1.atEnd())
                    iter1.nextLink();
                else
                    System.out.println("Can't go to next link");
                break;
            case 'g':
                if (!theList.isEmpty()) {
                    value = iter1.getCurrent().getData();
                    System.out.println("Returned " + value);
                } else
                    System.out.println("List is empty");
                break;
            case 'b':
                System.out.print("Enter value to insert: ");
                System.out.flush();
                value = in.nextInt();
                iter1.insertBefore(value);
                break;
            case 'a':
                System.out.print("Enter value to insert: ");
                System.out.flush();
                value = in.nextInt();
                iter1.insertAfter(value);
                break;
            case 'd':
                if (!theList.isEmpty()) {
                    value = iter1.deleteCurrent();
                    System.out.println("Deleted " + value);
                } else
                    System.out.println("Can't delete");
                break;
            case 'e':
                System.exit(0);
            default:
                System.out.println("Invalid entry");
            }
        }
    }

}
