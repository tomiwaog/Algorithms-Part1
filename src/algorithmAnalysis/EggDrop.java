package algorithmAnalysis;

import java.util.Arrays;
import java.util.Random;

public class EggDrop {

    public int oneEggDrop(int egg, boolean[] building) {
        for (int i = 0; i < building.length; i++)
            if (building[i])
                return i-1;
        return 0;
    }

    public int eggDropBinarySearch(int eggs, boolean[] building, int start, int end) {
        while(start<=end){
            if (eggs==1){ //If only 1 egg left. Use linear search
                if (!building[start]){
                    System.out.println("linearly searching:"+start + " to "+end);
                    start++;
                    continue;
                }
                System.out.println("Eggs left :"+ eggs);
                return start-1;
            }
            int midFloor = start+ (end-start)/2;
            if (midFloor==0 || midFloor==building.length-1) return midFloor;
            if (building[midFloor] && !building[midFloor-1]) return midFloor-1;
            if (building[midFloor]){ 
                end=midFloor-1;
                System.out.println("Broke an egg at floor: "+ midFloor);
                eggs--;
            }
            else if (!building[midFloor]) start = midFloor+1;
        }
        return -1;
    }
    
    
    /*
     * method randomly choose a floor from which an egg is breakable. Indexing from 1 to @param building.length
     * @param building array of building
     */
    public int fillBuildingFromFloor(boolean building[]){
        int randomGenerator = new Random().nextInt(building.length)+1;; //Generate randomNum from 1 to length of @param Building
        randomGenerator--;
        Arrays.fill(building, randomGenerator, building.length, true);
        return randomGenerator+1;
    }
}
