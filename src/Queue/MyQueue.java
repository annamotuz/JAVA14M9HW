package Queue;

public class MyQueue {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
            this.next = null;
        }
    }

    public void add(Object value) {
        Node newNode = new Node(value);

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

    public Object peek() {
        if (first == null) {
            return null;
        }

        return first.value;
    }

    public Object poll() {
        if (first == null) {
            return null;
        }

        Node removedNode = first;
        first = first.next;

        if (first == null) {
            last = null;
        }

        size--;

        return removedNode.value;
    }
}

