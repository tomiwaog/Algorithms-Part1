package sorting;

import java.util.Arrays;

public class SortZeroOnes {
    static void sort(int[] numbers) {
        // Runtime O(2N)
        if (numbers == null)
            throw new IllegalArgumentException();
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0)
                zeroCount++;
            else if (numbers[i] == 1)
                oneCount++;
            else
                throw new IllegalArgumentException();
        }
        for (int i = 0; i < zeroCount; i++)
            numbers[i] = 0;
        for (int i = zeroCount; i < numbers.length; i++)
            numbers[i] = 1;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 0, 1, 0, 1, 0, 0, 1 };
        System.out.println(Arrays.toString(arr));

        sort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[] { 1, 1, 1, 1, 1, 1, 1, 1 };
        arr = new int[] { 1, 0, 1, 0, 1, 0, 0, 1 };
        System.out.println(Arrays.toString(arr));

        sortOnePass(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sortOnePass(int[] numbers) {
        if (numbers == null)
            throw new IllegalArgumentException();

        int zeroDriver = 0, oneDriver = numbers.length - 1;
        while (zeroDriver < oneDriver) {
            while (numbers[zeroDriver] == 0 && zeroDriver < oneDriver)
                zeroDriver++;
            while (numbers[oneDriver] == 1 && zeroDriver < oneDriver)
                oneDriver--;

            if (zeroDriver < oneDriver) {
                numbers[zeroDriver++] = 0;
                numbers[oneDriver--] = 1;
            }
        }
    }

    static void sort3Items(int[] numbers) {
        if (numbers == null)
            throw new IllegalArgumentException();

        int low = 0, reader =0, high = numbers.length-1;
        while(low<high){
            
        }
    }
}
