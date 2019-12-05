public class DataItem<K, V> {
    private K key;
    private V value;

    public DataItem(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object anObject) {
        if ((anObject != null) && (anObject instanceof DataItem)) {
            DataItem d = (DataItem) anObject;
            return key.equals(d.getKey());
        }
        return false;
    }

    @Override
    public String toString() {
        return "(Key:" + this.getKey() + ", Value:" + getValue() + ")";
    }

}