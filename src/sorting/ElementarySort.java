package sorting;

public class ElementarySort {

    public static void bubbleSort(Comparable arr[]) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (SortTools.isLess(arr, j + 1, j)) {
                    SortTools.swap(arr, j + 1, j);
                }
            }
        }
    }

    public static void selectionSort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (SortTools.isLess(arr, j, min))
                    min = j;
            }
            SortTools.swap(arr, i, min);
        }
    }

    public static void insertionSort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (SortTools.isLess(arr, j, j - 1)) {
                    SortTools.swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
