package algorithmAnalysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSumN2 {

    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);   
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){ //Writes sorted array to HashMap
            map.put(nums[i], i);
        }
        
        for (int i=0; i<nums.length; i++){
            if (i>0 && nums[i] == nums[i-1]) continue; //Ignores duplicates of i
            for (int j=i+1; j<nums.length;j++){ 
                if (j>i+1 && nums[j] == nums[j-1]) continue; //Ignores duplicates of j
                int sumBoth = nums[i]+ nums[j];
                int location = map.get(-sumBoth)!=null?map.get(-sumBoth):-1; 
                if (location > j){
                    ArrayList<Integer> builder = new ArrayList<Integer>();
                    builder.add(nums[i]);
                    builder.add(nums[j]);
                    builder.add(nums[location]);
                    result.add(builder);
                }
            }
        }
        return result;
    }
    
    public int countThreeSum(int[] nums) {        
        Arrays.sort(nums);   
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){ //Writes sorted array to HashMap
            map.put(nums[i], i);
        }
        int counter=0;
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length;j++){ 
                int sumBoth = nums[i]+ nums[j];
                int location = map.get(-sumBoth)!=null?map.get(-sumBoth):-1; 
                if (location > j){
                    counter++;
                }
            }
        }
        return counter;
    }
}
