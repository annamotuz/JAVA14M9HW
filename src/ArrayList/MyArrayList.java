package ArrayList;

public class MyArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private E[] arrayElements;
    private int arraySize;

    public MyArrayList() {
        arrayElements = (E[]) new Object[DEFAULT_CAPACITY];
        arraySize = 0;
    }

    public void add(E value) {
        if (arraySize == arrayElements.length) {
            increaseCapacity();
        }

        arrayElements[arraySize] = value;
        arraySize++;
    }

    public void remove(int index) {
        checkIndex(index);

        System.arraycopy(arrayElements, index + 1, arrayElements, index, arraySize - index - 1);

        arrayElements[arraySize - 1] = null;
        arraySize--;
    }

    public void clear() {
        arrayElements = (E[]) new Object[10];
        arraySize = 0;
    }

    public int size() {
        return arraySize;
    }

    public E get(int index) {
        checkIndex(index);
        return arrayElements[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= arraySize) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseCapacity() {
        int newCapacity = arrayElements.length * 2;
        E[] newElements = (E[]) new Object[newCapacity];

        System.arraycopy(arrayElements, 0, newElements, 0, arraySize);

        arrayElements = newElements;
    }
}
