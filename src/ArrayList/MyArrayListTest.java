package ArrayList;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();

        myArrayList.add("Element 1");
        myArrayList.add("Element 2");
        myArrayList.add("Element 3");

        System.out.println("After adding elements:");
        printElements(myArrayList);

        myArrayList.remove(1);

        System.out.println("After removing element at index 1:");
        printElements(myArrayList);

        myArrayList.clear();

        System.out.println("After clearing the list:");
        printElements(myArrayList);

        System.out.println("Size of the list: " + myArrayList.size());

        myArrayList.add("Element 1");
        myArrayList.add("Element 2");

        System.out.println("Element at index 0: " + myArrayList.get(0));
        System.out.println("Element at index 1: " + myArrayList.get(1));
    }

    private static void printElements(MyArrayList myArrayList) {
        int size = myArrayList.size();
        for (int i = 0; i < size; i++) {
            System.out.println("Element at index " + i + ": " + myArrayList.get(i));
        }
    }
}
