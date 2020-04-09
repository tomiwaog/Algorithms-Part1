import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size;
    private Item[] arrayQueue;

    private class ListIterator implements Iterator<Item> {
        int i = 0;

        @Override
        public boolean hasNext() {
            return (i <= size - 1 && arrayQueue[i] != null);
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return arrayQueue[i++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // construct an empty randomized queue

    public RandomizedQueue() {
        arrayQueue = (Item[]) new Object[2];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        if (size > 0 && size == arrayQueue.length) {
            resizeArray(arrayQueue.length * 2);
        }
        arrayQueue[size++] = item;

    }

    // remove and return a random item
    public Item dequeue() {
        if (size == 0)
            throw new NoSuchElementException();
        int randomNum = StdRandom.uniform(size);
        Item randomItemRemoved = arrayQueue[randomNum];
        for (int i = randomNum; i < size - 1; i++) {
            arrayQueue[i] = arrayQueue[i + 1];
        }
        arrayQueue[--size] = null;
        if (size > 0 && size <= arrayQueue.length / 4) {
            resizeArray(arrayQueue.length / 2);
        }
        return randomItemRemoved;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size == 0)
            throw new NoSuchElementException();
        int randomNum = StdRandom.uniform(size);
        return arrayQueue[randomNum];

    }

    // Resizes the array based on current occupancy size
    private void resizeArray(int newSizeRequirement) {
        Item[] copyArray = (Item[]) new Object[newSizeRequirement];
        for (int i = 0; i < size; i++) {
            copyArray[i] = arrayQueue[i];
        }
        arrayQueue = copyArray;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> myQueue = new RandomizedQueue<String>();
        myQueue.enqueue("Tomiwa");
        myQueue.enqueue("Adetona");
        myQueue.enqueue("Sikiru");
        myQueue.enqueue("Ogunbamowo");

        for (String x : myQueue) {
            StdOut.println(x);
        }

        String removed = myQueue.dequeue();

        StdOut.println("\ndequeued: " + removed + "\n");

        for (String x : myQueue) {
            StdOut.println(x);
        }

        myQueue.enqueue(removed);

        for (String x : myQueue) {
            StdOut.println(x);
        }
    }

}