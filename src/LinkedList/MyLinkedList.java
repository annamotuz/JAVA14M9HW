package LinkedList;

public class MyLinkedList {

    private Node firstElement;
    private Node lastElement;
    private int listSize;

    private class Node {
        Object value;
        Node prevElement;
        Node nextElement;

        Node(Object value) {
            this.value = value;
            this.prevElement = null;
            this.nextElement = null;
        }
    }

    public void add(Object value) {
        Node newNode = new Node(value);

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

        Node nodeToRemove;

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

    public Object get(int index) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException();
        }

        Node node = getNodeAtIndex(index);
        return node.value;
    }

    private Node getNodeAtIndex(int index) {
        Node currentNode = firstElement;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.nextElement;
        }

        return currentNode;
    }
}
