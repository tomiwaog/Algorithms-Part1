package sorting;

public class Sort {
    public static void insertionSort(int[] arr){
        for (int i=0; i<arr.length;i++){
            for (int j=i; j>0; j--){
                if (isLess(arr, j, j-1)) swap(arr, j, j-1);
            }
        }
    }
    
    public static void selectionSort(int [] arr){
        for (int i=0; i<arr.length;i++){
            int min=i;
            for (int j=i+1; j<arr.length;j++){
                if (Sort.isLess(arr, j, min)) min=j;
            }
            swap(arr, i,min);
        }
    }
    
    public static void bubbleSort(int [] arr){
        for (int i=arr.length-1; i>=0; i--){
            for (int j=0;j<i;j++){
                if (Sort.isLess(arr, j+1, j)) Sort.swap(arr, j, j+1);
            }
        }
    }
    
    public static boolean isSortedAsc(int[] arr){
        for (int i=0; i<arr.length-1;i++){
            if (arr[i]>arr[i+1])return false;
        }
        return true;   
    }
    
    public  static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    
    public static boolean isLess(int [] arr, int i, int j){
       return (arr[i]< arr[j]);
    }
}
