package sorting;

import java.util.Arrays;

public class DutchNationalFlag {
    private String[] bucket;

    DutchNationalFlag(String[] buckets) {
        this.bucket = buckets;
    }

    void swap(int i, int j) {
        if (i < 0 || j < 0 || j >= bucket.length || i > bucket.length)
            throw new IndexOutOfBoundsException();

        String swap = bucket[i];
        bucket[i] = bucket[j];
        bucket[j] = swap;
    }

    String color(int i) {
        if (i < 0 || i >= bucket.length)
            throw new IndexOutOfBoundsException();
        return bucket[i];
    }

    void sort() {
        int low = 0, iterator = 0, high = bucket.length - 1;
        while (iterator <= high) {
            if (color(iterator).equals("white")) {
                // skips the color white and increases iterator
                iterator++;
            }
            if (color(iterator).equals("red")) {
                // Red colors are placed in the last end of the series of first
                // reds
                // Iterator continue and low is increased
                swap(iterator++, low++);
            } else {
                // Blue pebbles are placed at the beginning of other blues
                swap(iterator++, high--);
            }
        }
    }

    public static void main(String[] args) {
        String[] arr = new String[] { "white", "red", "white", "red", "blue",
                "blue" };
        DutchNationalFlag flag = new DutchNationalFlag(arr);

        System.out.println(Arrays.toString(flag.bucket));

        flag.sort();
        System.out.println(Arrays.toString(flag.bucket));
    }
}
