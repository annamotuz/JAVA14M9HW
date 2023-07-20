package HashMap;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private Node<K, V>[] buckets;
    private int size;

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public MyHashMap() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> newNode = new Node<>(key, value);

        if (buckets[index] == null) {
            buckets[index] = newNode;
        } else {
            Node<K, V> currentNode = buckets[index];
            while (currentNode.next != null) {
                if (currentNode.key.equals(key)) {
                    currentNode.value = value;
                    return;
                }
                currentNode = currentNode.next;
            }

            if (currentNode.key.equals(key)) {
                currentNode.value = value;
            } else {
                currentNode.next = newNode;
            }
        }

        size++;

        if (size >= buckets.length * 0.75) {
            resizeBuckets(buckets.length * 2);
        }
    }

    public void remove(K key) {
        int index = getIndex(key);

        if (buckets[index] == null) {
            return;
        }

        Node<K, V> prevNode = null;
        Node<K, V> currentNode = buckets[index];

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                if (prevNode == null) {
                    buckets[index] = currentNode.next;
                } else {
                    prevNode.next = currentNode.next;
                }
                size--;
                return;
            }

            prevNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public void clear() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int index = getIndex(key);

        Node<K, V> currentNode = buckets[index];
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }

        return null;
    }

    private int getIndex(K key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % buckets.length);
    }

    private void resizeBuckets(int newCapacity) {
        Node<K, V>[] newBuckets = new Node[newCapacity];

        for (Node<K, V> node : buckets) {
            while (node != null) {
                Node<K, V> newNode = new Node<>(node.key, node.value);
                int newIndex = Math.abs(node.key.hashCode() % newCapacity);

                if (newBuckets[newIndex] == null) {
                    newBuckets[newIndex] = newNode;
                } else {
                    Node<K, V> currentNode = newBuckets[newIndex];
                    while (currentNode.next != null) {
                        if (currentNode.key.equals(node.key)) {
                            currentNode.value = node.value;
                            return;
                        }
                        currentNode = currentNode.next;
                    }

                    if (currentNode.key.equals(node.key)) {
                        currentNode.value = node.value;
                    } else {
                        currentNode.next = newNode;
                    }
                }

                node = node.next;
            }
        }

        buckets = newBuckets;
    }
}
