package stacksandQueues;

import java.util.Stack;

public class QueuesWithStacks<T> {
    Stack<T> primary = new Stack<>();
    Stack<T> reverse = new Stack<>();

    public T dequeue() {
        if (primary.isEmpty() & reverse.isEmpty())
            return null;

        if (reverse.isEmpty()) {
            while (!primary.isEmpty()) {
                reverse.push(primary.pop());
            }
        }
        T top = reverse.pop();
        return top;
    }

    public boolean isEmpty() {
        return primary.isEmpty() && reverse.isEmpty();
    }

    public void enqueue(T object) {
        primary.push(object);
    }

    public static void main(String[] args) {
        QueuesWithStacks<String> myStack = new QueuesWithStacks<String>();
        myStack.enqueue("Hello");
        myStack.enqueue("Tom");
        myStack.dequeue();
        myStack.enqueue("Ogunbamowo");

        String it = myStack.dequeue();
        while (it != null) {
            System.out.println(it);
            it = myStack.dequeue();
        }
    }
}
