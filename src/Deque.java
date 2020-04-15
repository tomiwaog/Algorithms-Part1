import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {
    private Node first, last;
    private int size = 0;

    private class ListIterator implements Iterator<Item> {
        Node curr = first;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();

            Node oldItem = curr;
            curr = curr.next;
            return oldItem.value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Node {
        Item value;
        Node next;

        Node(Item value) {
            this.value = value;
        }
    }

    // construct an empty deque
    public Deque() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        Node node = new Node(item);
        if (first == null) {
            first = node;
            last = node;
        } else {
            Node oldFirst = first;
            first = node;
            node.next = oldFirst;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        Node node = new Node(item);
        if (last == null) {
            first = node;
            last = node;
        } else {
            Node oldLast = last;
            last = node;
            oldLast.next = last;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size <= 0)
            throw new NoSuchElementException();
        Node oldFirst = first;
        first = oldFirst.next;
        if (first == null)
            last = null;
        size--;
        return oldFirst.value;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (size <= 0)
            throw new NoSuchElementException();

        Node current = first;
        while (current.next != null && current.next.next != null) {
            current = current.next;
        }
        Node toDelete = last;

        if (current.next == null) {
            first = null;
            last = null;
        } else {
            current.next = null;
            last = current;
        }
        size--;
        return toDelete.value;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> queue = new Deque<>();
        queue.addFirst("Ogunbamowo");
        queue.addFirst("Tomiwa");
        queue.addLast(".io");
        for (String x : queue) {
            StdOut.println(x);
        }
        StdOut.println();
        StdOut.println(queue.removeLast());
        StdOut.println(queue.removeFirst());
        for (String x : queue) {
            StdOut.println(x);
        }
    }

}
