package sorting;

public class QuickSelect {

    public static Comparable selectPosition(Comparable[] arr, int position) {
        position--;
        Comparable result = select(arr, position, 0, arr.length - 1);
        return result;
    }

    private static Comparable select(Comparable[] arr, int position, int start,
            int end) {
        int positionI = partition(arr, start, end);
        if (positionI < position) {
            return select(arr, position, positionI + 1, end);
        } else if (positionI > position) {
            return select(arr, position, start, positionI - 1);
        } else
            return arr[positionI];
    }

    public static int partition(Comparable[] arr, int start, int end) {
        Comparable pivot = arr[start];
        int i = start, j = end + 1;
        while (true) {
            while (!SortTools.isLess(arr, start, ++i)) {
                if (i == end)
                    break;
            }
            while (SortTools.isLess(arr, start, --j))
                ;
            if (i >= j)
                break;
            SortTools.swap(arr, i, j);
        }
        SortTools.swap(arr, start, j);
        return j;
    }

    public static Comparable findKthLargest(Comparable[] arr, int k) {
        if (k >= arr.length || k < 0){
            System.err.println("NOT VALID");
            return -1; 
        }
            
        k = arr.length - k;
        Comparable result = findK(arr, k, 0, arr.length - 1);
//        Comparable result = select(arr, k, 0, arr.length - 1);
        return result;
    }

    private static Comparable findK(Comparable[] arr, int k, int start, int end) {
        int p = partition(arr, start, end);
        if (p < k) {
            return findK(arr, k, p+ 1, end);
        } else if (p > k) {
            return findK(arr, k, start, p-1);
        } else
            return arr[p];
    }
}
