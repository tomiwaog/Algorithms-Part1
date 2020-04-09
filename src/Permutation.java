import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    // Client Test
    public static void main(String[] args) {
        RandomizedQueue<String> myQueue = new RandomizedQueue<>();
        int k = Integer.parseInt(args[0]);

        while (!StdIn.isEmpty()) {
            String input = StdIn.readString();
            myQueue.enqueue(input);
        }

        for (int i = 0; i < k; i++) {
            StdOut.println(myQueue.dequeue());
        }

    }
}