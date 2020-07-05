package sorting;

public class QuickSort {

    public static int partition(Comparable [] arr, int start, int end){
        Comparable pivot = arr[start];
        int i=start, j=end+1;
        
        while(true){
            while(!SortTools.isLess(arr, start, ++i)){
                if (i==end)break;
            }
            
            while(SortTools.isLess(arr, start, --j));
            
            if (i>=j)break;
            SortTools.swap(arr,i, j);
        }
        SortTools.swap(arr, start, j);
        return j;
    }
    
    public static void sort (Comparable[] arr, int start, int end){
        if (start>end)return;
        int pivotLoc = partition(arr, start, end);
        sort(arr, start, pivotLoc-1);
        sort(arr, pivotLoc+1, end);
    }
}
