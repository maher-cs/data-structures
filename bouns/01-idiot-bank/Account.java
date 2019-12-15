public class Account {

    String name;
    double balance;

    public Account(String name, double balance) {
        this.setName(name);
        this.setBalance(balance);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        String output = "";
        output += "[\"" + this.getName() + "\", " + String.format("%.2f", this.getBalance()) + "]";
        return output;
    }
}