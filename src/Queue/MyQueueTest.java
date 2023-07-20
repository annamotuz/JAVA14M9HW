package Queue;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();

        for (int i = 0; i < 1000000; i++) {
            myQueue.add(i);
        }

        System.out.println("Queue size: " + myQueue.size());

        System.out.println("The first element of the queue: " + myQueue.peek());

        myQueue.poll();

        System.out.println("Queue size after deletion: " + myQueue.size());

        System.out.println("First queue element after deletion: " + myQueue.peek());

        myQueue.clear();

        System.out.println("Queue size after cleaning: " + myQueue.size());
    }
}
