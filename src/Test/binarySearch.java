package Test;

public class binarySearch {

    public int search(int[] nums, int target) {
        int res = binSearch(nums, 0, nums.length, target);
        return res;
    }
    
    int binSearch(int [] nums, int low, int high, int target){
        if (low>high) return -1;
        
        int mid = low+(high-low)/2;  
        
        if (target ==nums[mid]) return mid;
        else if (target < nums[mid] ) return binSearch(nums, low, mid-1, target);
        else if (target > nums[mid])return binSearch(nums, mid+1, high, target);
        
        return 666;
    }
    
    public int peakFinder(int [] nums){
        int low =0, high =nums.length-1;
        int mid=0;
        while(low<=high){
            mid = low + (high-low)/2;
            System.out.println("mid is currently, "+ nums[mid]);
            if (nums[mid]>nums[mid-1] && nums[mid]> nums[mid+1]){//Peak found
                return mid;
            }
            else if (nums[mid]>nums[mid-1] && nums[mid]< nums[mid+1]){//Crawling up
                low=mid+1;
            }else high=mid-1;
        }
        return mid;
    }
    
    public static void main(String [] args){
        System.out.println("Running main");
        binarySearch bs = new binarySearch();
        int test[] = new int[] { 1, 7, -8, -6, -5, 0 };
        int result = bs.peakFinder(test);
        System.out.println("Peak is "+ test[result]);
    }
}
