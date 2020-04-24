package sorting;

public class SortTools {
    public static void insertionSort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (isLess(arr, j, j - 1))
                    swap(arr, j, j - 1);
                else
                    break;
            }
        }
    }

    public static void selectionSort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (isLess(arr, j, min))
                    min = j;
            }
            swap(arr, i, min);
        }
    }

    public static void shellSort(Comparable[] arr) {
        int length = arr.length;
        int gap = 1;
        while (gap < length / 3)
            gap = 3 * gap + 1;

        while (gap >= 1) {
            for (int i = gap; i < length; i++) {
                for (int j = i; j >= gap && isLess(arr, j, j - gap); j -= gap) {
                    swap(arr, j, j - gap);
                }
            }
            gap = gap / 3;
        }
    }

    public static void bubbleSort(Comparable[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (isLess(arr, j + 1, j))
                    swap(arr, j, j + 1);
            }
        }
    }

    public static boolean isSortedAsc(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (isLess(arr, i + 1, i))
                return false;
        }
        return true;
    }

    public static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isLess(Comparable[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    public static void merge(Comparable[] array, Comparable auxArr[], int low,
            int mid, int high) {

        for (int i = 0; i < array.length; i++)
            auxArr[i] = array[i];

        int firstIt = low, secondIt = mid + 1;
        for (int i = low; i <=high; i++) {
            if (firstIt > mid) {
                array[i] = auxArr[secondIt++];
            } else if (secondIt > high) {
                array[i] = auxArr[firstIt++];
            } else if (SortTools.isLess(auxArr, firstIt, secondIt)) {
                array[i] = auxArr[firstIt++];
            } else {
                array[i] = auxArr[secondIt++];
            }
        }
    }

    public static void mergeSort(Comparable[] array, Comparable auxArr[],
            int low, int high) {
        int mid = low + (high - low) / 2;
        if (high <= low)
            return;
        mergeSort(array, auxArr, low, mid);
        mergeSort(array, auxArr, mid + 1, high);
        merge(array, auxArr, low, mid, high);

    }

    public static Comparable[] mergeTwo(Comparable[] array1, Comparable[] array2) {
        // Merging Two Separate Arrays
        Comparable[] newArray = new Comparable[array1.length + array2.length];

        int firstIt = 0, secondIt = 0;
        for (int i = 0; i < newArray.length; i++) {
            if (firstIt >= array1.length) {
                newArray[i] = array2[secondIt++];
            } else if (secondIt >= array2.length) {
                newArray[i] = array1[firstIt++];
            } else if ((Integer) array1[firstIt] < (Integer) array2[secondIt]) {
                newArray[i] = array1[firstIt++];
            } else {
                newArray[i] = array2[secondIt++];
            }
        }
        return newArray;
    }
}
