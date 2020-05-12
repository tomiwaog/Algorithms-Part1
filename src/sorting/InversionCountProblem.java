package sorting;

import java.util.Arrays;

public class InversionCountProblem {
    int totalInversionCount;
    public static void main(String[] args) {
        int [] numbers = new int[]{5,4,5,2,1,8};
        InversionCountProblem x = new InversionCountProblem();
        x.countInversion(numbers);
        System.out.println(Arrays.toString(numbers));
        
        System.out.println("Total InversionCount was "+ x.totalInversionCount);
    }

    public int countInversion(int[] array) {
        split(array, new int[array.length], 0, array.length-1);
        return 0;
    }

    public void split(int[] arr, int[] aux, int low, int high) {
        if (high<=low) return;
        int mid = low + (high - low) / 2;
        split(arr, aux, low, mid);
        split(arr, aux, mid + 1, high);
        merge(arr, aux, low, mid, high);
    }

    private void merge(int[] arr, int[] aux, int low, int mid, int high) {

        for (int i=low;i<=high;i++)aux[i]=arr[i]; //Copy to Aux-array
        int left =low, right = mid+1;
        
        for (int k=low; k<=high; k++){
            if (left>mid) arr[k] = aux[right++];
            else if (right>high)arr[k] = aux[left++];
            else if (aux[right]<aux[left]){
                System.out.println("Found"+ (mid-left+1) );
                totalInversionCount+= (mid-left+1);
                arr[k]=aux[right++];
            }
            else arr[k] = aux[left++];
        }
    }
}
