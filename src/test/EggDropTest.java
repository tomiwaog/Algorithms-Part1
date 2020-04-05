package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algorithmAnalysis.EggDrop;

public class EggDropTest {
    EggDrop eggDrop;
    
    @Before
    public void init(){
        eggDrop = new EggDrop();
    }
    
    
    @Test
    public void testEggDropOneEgg(){
        boolean [] building = new boolean[50];
        int expected = eggDrop.fillBuildingFromFloor(building)-1; //Returns random location
        int actual = eggDrop.oneEggDrop(1, building);
        System.out.printf("Expected floor: %d | Actual floor: %d ", expected, actual);
        Assert.assertEquals(expected,actual+1);
    }
    
    @Test
    public void testEggDropBinarySearch(){
        boolean [] building = new boolean[50];
        int expected = eggDrop.fillBuildingFromFloor(building)-1; //Returns random location
        int actual = eggDrop.eggDropBinarySearch(4, building, 0 , building.length-1);
        
        System.out.printf("Expected floor: %d | Actual floor: %d ", expected, actual);
        Assert.assertEquals(expected,actual+1);
    }
}
