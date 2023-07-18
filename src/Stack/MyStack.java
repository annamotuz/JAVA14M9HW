package Stack;

public class MyStack {
    private Node top;
    private int size;

    private class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
            this.next = null;
        }
    }

    public void push(Object value) {
        Node newNode = new Node(value);

        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }

        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            top = top.next;
        } else {
            Node previousNode = getNodeAtIndex(index - 1);
            Node nodeToRemove = previousNode.next;
            previousNode.next = nodeToRemove.next;
        }

        size--;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (top == null) {
            return null;
        }

        return top.value;
    }

    public Object pop() {
        if (top == null) {
            return null;
        }

        Node removedNode = top;
        top = top.next;
        size--;

        return removedNode.value;
    }

    private Node getNodeAtIndex(int index) {
        Node currentNode = top;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }
}

