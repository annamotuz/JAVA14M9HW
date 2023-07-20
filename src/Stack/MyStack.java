package Stack;

public class MyStack<E> {
    private Node<E> top;
    private int size;

    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    public void push(E value) {
        Node<E> newNode = new Node<>(value);

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
            Node<E> previousNode = getNodeAtIndex(index - 1);
            Node<E> nodeToRemove = previousNode.next;
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

    public E peek() {
        if (top == null) {
            return null;
        }

        return top.value;
    }

    public E pop() {
        if (top == null) {
            return null;
        }

        Node<E> removedNode = top;
        top = top.next;
        size--;

        return removedNode.value;
    }

    private Node<E> getNodeAtIndex(int index) {
        Node<E> currentNode = top;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }
}
