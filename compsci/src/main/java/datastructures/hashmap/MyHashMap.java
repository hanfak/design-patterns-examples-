package datastructures.hashmap;

import java.util.HashMap;

public class MyHashMap<K, V> {

    private static class Entry<K, V> {

        private final K key;
        private V value;

        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            Entry<K, V> temp = this;
            StringBuilder sb = new StringBuilder();
            while (temp != null) {
                sb.append(temp.key)
                        .append(" -> ")
                        .append(temp.value)
                        .append(",");
                temp = temp.next;
            }
            return sb.toString();
        }
    }

    private final int SIZE = 1;
    private Entry<K, V> table[];
    public MyHashMap() {
        table = new Entry[SIZE];
    }

    public void put(K key, V value) {
        int keyHash = key.hashCode() % SIZE;
        Entry<K, V> e = table[keyHash];
        // Check if not exist, then add
        if ( e == null) {
            table[keyHash] = new Entry<>(key, value);
        } else {
            // if entry exists, and contains same key then replace the value
            while (e.next != null) {
                if (e.getKey().equals(key)) {
                    e.setValue(value);
                    return;
                }
                e = e.next;
            }
            // replace the last entry value of LL if exist
            // as the loop will end before checking the key in the last element of the LL
            if (e.getKey().equals(key)) {
                e.setValue(value);
                return;
            }

            // if no entry exists in LL with same key, then add to last key
            e.next = new Entry<K, V>(key, value);
        }

    }

    public V get(K key) {
        int keyHash = key.hashCode() % SIZE;
        Entry<K, V> e = table[keyHash];
        if (e == null) return null;

        while (e.next != null) {
            if (e.getKey().equals(key)) {
                return e.getValue();
            }
            e = e.next;
        }
        return null;

    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            if (table[i] != null) {
                sb.append(i)
                        .append(" ")
                        .append(table[i])
                        .append("\n");
            } else {
                sb.append(i)
                        .append(" ")
                        .append("null")
                        .append("\n");
            }
        }

        return sb.toString();
    }

    public static void main(String... args) {
        MyHashMap<Key, String> myHashMap = new MyHashMap<Key, String>();
        myHashMap.put(new Key("A", 4), "B");
        myHashMap.put(new Key("E", 3), "F");
        myHashMap.put(new Key("H", 5), "P");
        myHashMap.put(new Key("P", 1), "2");
        myHashMap.put(new Key("1",3 ),  "G");
        myHashMap.put(new Key("2", 6), "6");
        myHashMap.put(new Key("3", 8), "2");
        myHashMap.put(new Key("4", 3), "4");
        myHashMap.put(new Key("1", 9),  "H");


        System.out.println(myHashMap);
    }
}
