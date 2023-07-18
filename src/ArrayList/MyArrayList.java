package ArrayList;

public class MyArrayList {

    private Object[] arrayElements;
    private int arraySize;

    public MyArrayList() {
        arrayElements = new Object[10];
        arraySize = 0;
    }

    public void add(Object value) {

        if (arraySize == arrayElements.length) {
            increaseCapacity();
        }

        arrayElements[arraySize] = value;
        arraySize++;
    }

    public void remove(int index) {
        if (index < 0 || index >= arraySize) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < arraySize - 1; i++) {
            arrayElements[i] = arrayElements[i + 1];
        }

        arrayElements[arraySize - 1] = null;
        arraySize--;
    }

    public void clear() {

        for (int i = 0; i < arraySize; i++) {
            arrayElements[i] = null;
        }

        arraySize = 0;
    }

    public int size() {
        return arraySize;
    }

    public Object get(int index) {
        if (index < 0 || index >= arraySize) {
            throw new IndexOutOfBoundsException();
        }

        return arrayElements[index];
    }

    private void increaseCapacity() {
        int newCapacity = arrayElements.length * 2;
        Object[] newElements = new Object[newCapacity];

        for (int i = 0; i < arraySize; i++) {
            newElements[i] = arrayElements[i];
        }

        arrayElements = newElements;
    }
}


