package test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySTest {
    binarySearch bs;
    
    @Before
    public void init(){
        bs = new binarySearch();
    }

    @Test
    public void testBSearch() {
        int test[] = new int[] { 1, 4, 6, 7, 9 };
        int result = bs.search(test, 4);
        System.out.println("Bin Search: "+result);
        Assert.assertEquals(4, 3+1);
    }
    
    @Test 
    public void peakFinder(){
        int test[] = new int[] { 1, 7, 9, -8, -6, -5, 0 };
        int result = bs.peakFinder(test);
        System.out.println("Peak is "+ test[result]);
        Assert.assertEquals(2, result);
    }
}
