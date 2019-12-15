import java.util.Scanner;

public class App {

    Database database;

    public App() {
        this.database = new Database();
    }

    public void menu() {
        String name;
        double balance;
        String prompt = "(a)dd, (r)emove, (s)earch, (d)ump, (t)otal, (q)uit > ";
        Scanner console = new Scanner(System.in);
        while (true) {
            System.out.print(prompt);
            char choice = console.next().charAt(0);
            switch (choice) {
            case 'a':
                System.out.print("Enter the name: ");
                name = console.next();
                System.out.print("Enter the balance: ");
                balance = console.nextDouble();
                if(this.database.add(name, balance)) {
                    System.out.println("account added succesfully!");
                } else {
                    System.out.println("account not added!");
                }
                break;

            case 'r':
                System.out.print("Enter the name: ");
                name = console.next();
                if(this.database.remove(name)) {
                    System.out.println("account deleted succesfully!");
                } else {
                    System.out.println("account not deleted!");
                }
                break;

            case 's':
                System.out.print("Enter the name: ");
                name = console.next();
                Account accnount = this.database.search(name);
                if(accnount != null) {
                    System.out.println("founded: " + accnount);
                } else {
                    System.out.println("account not founded!");
                }
                break;

            case 'd':
                this.database.dump();
                break;

            case 't':
                System.out.println("Total: " + this.database.total());
                break;

            case 'q':
                return;
            default:
                System.out.println("Invalid entry\n");
            }
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.menu();
    }
}