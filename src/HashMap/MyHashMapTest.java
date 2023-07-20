package HashMap;

public class MyHashMapTest {

    public static void main(String[] args) {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();

        for (int i = 0; i < 2000000; i++) {
            myHashMap.put(i, "Value" + i);
        }

        System.out.println("Hashmap size: " + myHashMap.size());

        int keyToGet = 1000000;
        System.out.println("Value by key " + keyToGet + ": " + myHashMap.get(keyToGet));

        myHashMap.remove(keyToGet);

        System.out.println("Hashmap size after deletion: " + myHashMap.size());

        System.out.println("Value by key " + keyToGet + " after deletion: " + myHashMap.get(keyToGet));

        myHashMap.clear();

        System.out.println("Hashmap size after cleaning: " + myHashMap.size());
    }
}
