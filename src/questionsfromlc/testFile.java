package questionsfromlc;

import org.junit.Assert;
import org.junit.Test;

public class testFile {

    @Test
    public void testDistanceMetrics(){
        int [] numbers = new int[]{1, 2, 1, 1, 2, 3};
        int [] actuals = DistanceMetrics.getDistanceMetrics(numbers);
        int expecteds[] = new int[]{5, 3, 3, 4, 3, 0};
        Assert.assertArrayEquals(expecteds, actuals);
    }
}
