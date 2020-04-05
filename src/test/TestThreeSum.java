package test;

import org.junit.Assert;
import org.junit.Test;

import algorithmAnalysis.ThreeSumN2;

public class TestThreeSum {

    @Test
    public void testCountThreeSum(){
        ThreeSumN2 three = new ThreeSumN2();
        int count = three.countThreeSum(new int[]{5,-4,0,-1,-5});
        Assert.assertEquals(2, count);
    }
}
