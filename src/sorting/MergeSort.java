package sorting;

public class MergeSort {
    public static void sort(Comparable[] arr, Comparable[] aux, int low,
            int high) {
        if (high <= low)
            return;
        int mid = low + (high - low) / 2;
        sort(arr, aux, low, mid);
        sort(arr, aux, mid + 1, high);
        merge(arr, aux, low, mid, high);
    }

    public static void merge(Comparable[] arr, Comparable[] aux, int left,
            int mid, int right) {
        for (int i = left; i <= right; i++)
            aux[i] = arr[i];

        int leftIt = left;
        int rightIt = mid + 1;
        for (int i = left; i <= right; i++) {
            if (leftIt > mid)
                arr[i] = aux[rightIt++];
            else if (rightIt > right)
                arr[i] = aux[leftIt++];
            else if (SortTools.isLess(aux, rightIt, leftIt))
                arr[i] = aux[rightIt++];
            else
                arr[i] = aux[leftIt++];
        }
    }

    public static Comparable[] mergeTwo(Integer[] array1, Integer[] array2) {
        
        Comparable resultArr[] =new Comparable[array1.length+array2.length];
        
        int left=0; int right =0;
        for (int i=0; i<resultArr.length;i++){
            if (left==array1.length) resultArr[i] = array2[right++];
            else if (right==array2.length) resultArr[i] = array1[left++];
            else if (array2[right] < array1[left]) resultArr[i] = array2[right++];
            else resultArr[i] = array1[left++];
        }
        return resultArr;
    }
}
