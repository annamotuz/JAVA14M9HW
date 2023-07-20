package LinkedList;

public class MyLinkedList<E> {

    private Node<E> firstElement;
    private Node<E> lastElement;
    private int listSize;

    private static class Node<E> {
        E value;
        Node<E> prevElement;
        Node<E> nextElement;

        Node(E value) {
            this.value = value;
            this.prevElement = null;
            this.nextElement = null;
        }
    }

    public void add(E value) {
        Node<E> newNode = new Node<>(value);

        if (firstElement == null) {
            lastElement = newNode;
            firstElement = newNode;
        } else {
            lastElement.nextElement = newNode;
            newNode.prevElement = lastElement;
            lastElement = newNode;
        }

        listSize++;
    }

    public void remove(int index) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> nodeToRemove;

        if (index == 0) {
            nodeToRemove = firstElement;
            firstElement = firstElement.nextElement;
        } else if (index == listSize - 1) {
            nodeToRemove = lastElement;
            lastElement = lastElement.prevElement;
        } else {
            nodeToRemove = getNodeAtIndex(index);
            nodeToRemove.prevElement.nextElement = nodeToRemove.nextElement;
            nodeToRemove.nextElement.prevElement = nodeToRemove.prevElement;
        }

        nodeToRemove.prevElement = null;
        nodeToRemove.nextElement = null;
        listSize--;
    }

    public void clear() {
        firstElement = null;
        lastElement = null;
        listSize = 0;
    }

    public int size() {
        return listSize;
    }

    public E get(int index) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> node = getNodeAtIndex(index);
        return node.value;
    }

    private Node<E> getNodeAtIndex(int index) {
        Node<E> currentNode = firstElement;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.nextElement;
        }

        return currentNode;
    }
}
