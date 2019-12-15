public class Database {

    private final int DEFAULT_SIZE = 10;
    private Account[] accounts;
    private int nElms = 0;

    public Database() {
        this.accounts = new Account[DEFAULT_SIZE];
    }

    public Database(int size) {
        if(size > 0) {
            this.accounts = new Account[size];
        } else {
            this.accounts = new Account[DEFAULT_SIZE];
        }
    }

    public boolean add(String name, double balance) {
        if(this.isFull()) {
            return false;
        }
        this.accounts[nElms++] = new Account(name, balance);
        return true;
    }

    public boolean remove(String name) {
        for(int i = 0; i < this.nElms; i++) {
            if(this.accounts[i].getName().equals(name)) {
                this.deleteAt(i);
                return true;
            }
        }
        return false;
    }

    public Account search(String name) {
        for(int i = 0; i < this.nElms; i++) {
            if(this.accounts[i].getName().equals(name)) {
                return this.accounts[i];
            }
        }
        return null;
    }

    public void dump() {
        if(this.isEmpty()) {
            System.out.println("Empty");
            return;
        }
        for(int i = 0; i < this.nElms; i++) {
            System.out.println(accounts[i]);
        }
    }

    public double total() {
        double sum = 0;
        for(int i = 0; i < this.nElms; i++) {
            sum += this.accounts[i].getBalance();
        }
        return sum;
    }

    private Account deleteAt(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= this.nElms) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 1; i < this.nElms; i++) {
            this.accounts[i - 1] = this.accounts[i];
        }
        this.nElms--;
        return null;
    }

    private boolean isFull() {
        return this.nElms == this.accounts.length;
    }

    private boolean isEmpty() {
        return this.nElms == 0;
    }
}