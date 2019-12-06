public class HashTableLinear<K, V> {

    private DataItem[] hashArray;
    private int nElems;

    private static final int DEFAULT_SIZE = 5;

    public HashTableLinear() {
        this(DEFAULT_SIZE);
    }

    public HashTableLinear(int size) {
        nElems = 0;
        hashArray = new DataItem[size];
        for (int i = 0; i < hashArray.length; i++) {
            hashArray[i] = null;
        }
    }

    public int hashFunc(K key, int tableSize) {
        int sum = key.hashCode() * 11;

        return sum % tableSize;
    }

    public int insert(DataItem<K, V> item) {

        if (this.isFull()) {
            return -1;
        }

        if (this.find(item.getKey()) != null) {
            return -2;
        }

        int hashVal = hashFunc(item.getKey(), hashArray.length);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].equals(item)) {
                return -2;
            }
            hashVal++;
            hashVal = hashVal % hashArray.length;
        }

        hashArray[hashVal] = item;
        nElems++;
        return 0;
    }

    public DataItem<K, V> delete(K target) {
        int hashVal = hashFunc(target, hashArray.length);
        int counter = 0;

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey().equals(target)) {
                DataItem<K, V> temp = hashArray[hashVal];
                hashArray[hashVal] = null;
                nElems--;
                return temp;
            }
            hashVal++;
            counter++;
            hashVal = hashVal % hashArray.length;
            if (counter == this.nElems) {
                return null;
            }
        }
        return null;
    }

    public DataItem<K, V> find(K target) {
        int hashVal = hashFunc(target, hashArray.length);
        int counter = 0;

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey().equals(target)) {
                return hashArray[hashVal];
            }
            hashVal++;
            counter++;
            hashVal = hashVal % hashArray.length;
            if (counter == this.nElems) {
                return null;
            }
        }
        return null;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < hashArray.length; i++) {
            if (hashArray[i] == null) {
                buffer.append("empty\n");
            } else {
                buffer.append(hashArray[i] + "\n");
            }
        }
        return buffer.toString();
    }

    public boolean isFull() {
        return this.nElems == this.hashArray.length;
    }

    public void print() {
        System.out.println(this.toString());
    }

}