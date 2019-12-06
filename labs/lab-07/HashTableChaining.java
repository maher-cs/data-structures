import java.util.*;

public class HashTableChaining<K, V> {
    private LinkedList<DataItem<K, V>>[] hashArray;
    private int nElems;

    public HashTableChaining() {
        this(11);
    }

    public HashTableChaining(int size) {
        nElems = 0;
        this.hashArray = new LinkedList[size];
        for (int i = 0; i < size; i++)
            this.hashArray[i] = new LinkedList<DataItem<K, V>>();
    }

    public int hashFunc(K key, int tableSize) {
        int sum = ((key.hashCode() % tableSize) + tableSize);
        return sum % tableSize;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();

        for (int j = 0; j < this.hashArray.length; j++) {
            buffer.append(this.hashArray[j] + "\n");
        }
        return buffer.toString();
    }

    public void print() {
        System.out.println(this.toString());
    }

    public void insert(DataItem<K, V> item) {
        int hashVal = hashFunc(item.getKey(), this.hashArray.length);
        if(this.hashArray[hashVal].indexOf(new DataItem<K, V>(item.getKey(), null)) >= 0) {
            System.out.println("this key is exist!");
            return;
        }
        this.hashArray[hashVal].add(item);

    }

    public DataItem delete(K key) {
        int hashVal = hashFunc(key, this.hashArray.length);
        return this.hashArray[hashVal].remove(this.hashArray[hashVal].indexOf(new DataItem<K, V>(key, null)));
    }

    public DataItem remove(K key) {
        int hashVal = hashFunc(key, this.hashArray.length);
        java.util.Iterator iter = this.hashArray[hashVal].iterator();
        DataItem<K, V> dummy = new DataItem<K, V>(key, null);
        DataItem<K, V> elm = null;
        while(iter.hasNext()) {
            elm = (DataItem<K, V>) iter.next();
            if(elm.equals(dummy)) {
                iter.remove();
            }
        }
        return elm;
    }

    public DataItem find1(K key) {
        int hashVal = hashFunc(key,this.hashArray.length);  
        return this.hashArray[hashVal].get(this.hashArray[hashVal].indexOf(new DataItem<K, V>(key, null)));
    }

}