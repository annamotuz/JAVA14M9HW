package Queue;

public class MyQueue<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    public void add(E value) {
        Node<E> newNode = new Node<>(value);

        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

        size++;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        if (first == null) {
            return null;
        }

        return first.value;
    }

    public E poll() {
        if (first == null) {
            return null;
        }

        Node<E> removedNode = first;
        first = first.next;

        if (first == null) {
            last = null;
        }

        size--;

        return removedNode.value;
    }
}
