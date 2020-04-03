package algorithmAnalysis;

public class BitonicSearch {

    public int searchBitonic(int[] numbers, int target) {
        // Get peak Location
        int peak = peakFinder(numbers);
        // Search target Item before peak
        int result = ascBinarySearch(numbers, 0, peak, target);
        // If target isn't found in first ascending array
        if (result < 0) {
            // Search Descending array
            result = descBinarySearch(numbers, peak + 1, numbers.length - 1,
                    target);
        }
        return result;
    }

    public int peakFinder(int[] numbers) {
        int low = 0, high = numbers.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || numbers[mid] >= numbers[mid - 1])
                    && (mid == numbers.length - 1 || numbers[mid] >= numbers[mid + 1])) {
                return mid;
            } else if ((numbers[mid] > numbers[mid - 1])
                    && numbers[mid] < numbers[mid + 1]) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        System.out.println("Sucks");
        return 0;
    }

    public int ascBinarySearch(int[] array, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] > target)
                end = mid - 1;
            else if (array[mid] < target)
                start = mid + 1;
            else if (array[mid] == target)
                return mid;
        }
        return -1;
    }

    public int descBinarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target)
                start = mid + 1;
            else if (arr[mid] < target)
                end = mid - 1;
            else if (arr[mid] == target)
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        // BitonicSearch bts = new BitonicSearch();
        // int[] arr = new int[] { 1, 3, 5, 6, 10, 7, 2, 0 };
        // int findPeak = bts.peakFinder(arr);
        // System.out.printf("Peak is %s at Position %s \n", arr[findPeak],
        // findPeak);

        // BitonicSearch bts = new BitonicSearch();
        // int [] arr = new int[]{1,3,5,6,10,7,2,0};
        // int findTarget = bts.searchBitonic(arr, 20);
        // System.out.println( findTarget>=0
        // ?"FOUND at "+(findTarget):"NOT FOUND");
    }
}
