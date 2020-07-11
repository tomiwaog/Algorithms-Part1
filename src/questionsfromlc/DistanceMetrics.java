package questionsfromlc;

import java.util.ArrayList;
import java.util.HashMap;


public class DistanceMetrics {

    //o(n2)
    static int[] getDistanceMetrics3(int [] numbers){
        int [] result = new int[numbers.length];
        int it=0;
        for (int i =0; i<numbers.length;i++){
            int item = numbers[i]; int totalDiff =0;
            for (int j=0; j<numbers.length; j++){
                if (i!=j && numbers[j] == item){
                    totalDiff += (i-j)<0?-(i-j):(i-j);
                }
            }
            result[it++] = totalDiff;
        }
        return result;
    }
    
    //o(n2) but better
    static int[] getDistanceMetrics(int [] numbers){
        int [] result = new int[numbers.length];
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i=0; i<numbers.length; i++){
            //Add occurence as key and index of occurence as values;
            map.putIfAbsent(numbers[i],  new ArrayList<Integer>());
            map.get(numbers[i]).add(i);
        }
        
        for (int i =0; i<numbers.length;i++){
            int item = numbers[i]; int totalDiff =0;
            for (int j: map.get(item)){
                if (j!=item){
                    totalDiff+= (i - j)<0?-(i-j):(i-j);
                }
            }
            result[i] = totalDiff;
        }
        return result;
    }

}


/*
 * Distance Metric
For each element in a given array, calculate the absolute value
of index differences between it and all other elements of the
same value. Return the resulting values in an array. For example,
if the array elements at indices 2 and 3 are equal, the distance
metric for element 2 is 12-31 = 1. For element 3 it is 13 - 21 = 1.
Example:
n = 6
arr = (1, 2, 1, 1, 2, 3].
The element arr[0] = 1. Similar elements are at indices 2 and 3.
The distance metric for arr[0] = 10-21 + 10-31 = 5
Similar logic follows:
The distance metric for arr[1] = 11-41 = 3
The distance metric for arr[2] = 12-01 + 12-31 = 3
The distance metric for arr[3] = 13-01 + 13-21 = 4
The distance metric for arr14] = 14-11 = 3
The distance metric for arr[5] = 0
Thus, distance metrics = (5, 3, 3, 4, 3, 0)
Function Description
Complete the function getDistanceMetrics in the editor below.
getDistanceMetrics has the following parameter(s):
int arrin): an array of integers
Returns:
int[n] : array of integers representing the sum of the distance metric of each element in the array arr Constraints
 */
