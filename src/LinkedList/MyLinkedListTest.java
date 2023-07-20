package LinkedList;

public class MyLinkedListTest {

    public static void main(String[] args) {
        MyLinkedList<Integer> myList = new MyLinkedList<>();

        for (int i = 0; i < 2000000; i++) {
            myList.add(i);
        }

        System.out.println("List size: " + myList.size());

        int index = 1000000;
        System.out.println("Element with an index " + index + ": " + myList.get(index));

        myList.remove(index);

        System.out.println("List size after deletion: " + myList.size());

        System.out.println("Element with index " + index + " after deletion: " + myList.get(index));

        myList.clear();

        System.out.println("List size after cleaning: " + myList.size());
    }
}
