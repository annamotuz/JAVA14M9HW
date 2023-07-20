package Stack;

public class MyStackTest {

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();

        for (int i = 0; i < 2000000; i++) {
            myStack.push(i);
        }

        System.out.println("Stack size: " + myStack.size());

        System.out.println("Top of stack: " + myStack.peek());

        myStack.pop();

        System.out.println("Stack size after deletion: " + myStack.size());

        System.out.println("Top stack element after removal: " + myStack.peek());

        myStack.clear();

        System.out.println("Stack size after cleanup: " + myStack.size());
    }
}
