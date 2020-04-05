package test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algorithmAnalysis.BitonicSearch;

public class SerachBitonicTest {
    BitonicSearch bts ;
    
    @Before
    public void init(){
        bts = new BitonicSearch();
    }

    @Test public void testPeakFinder(){
        int [] arr = new int[]{5,50,60,70,80,90};
        int findPeak = bts.peakFinder(arr);
        System.out.printf("Peak is %s at Position %s", arr[findPeak], findPeak);
        Assert.assertEquals(5, findPeak);
    }
    
    @Test public void testBinarySearch(){
        int [] array = new int[]{5,50,60,70,80,90};
        int bs = bts.ascBinarySearch(array, 0, 5, 50);
        Assert.assertEquals(1, bs);
    }
    
    @Test public void testBinarySearch2(){
        int [] array = new int[]{1,3,5,6,10};
        int bs = bts.ascBinarySearch(array, 0, array.length-1,2);
        Assert.assertEquals(-1, bs);
    }
    
    @Test public void testBitonicSearch(){
        int [] arr = new int[]{1,3,5,6,10,7,2,0};
        int findElementInBitonic = bts.searchBitonic(arr, 0);
        Assert.assertEquals(7, findElementInBitonic);
    }
    
    @Test public void testPeakFinder2(){
        int [] arr = new int[]{1,3,5,6,10,7,2,0};
        int findPeak = bts.peakFinder(arr);
        System.out.printf("Peak is %s at Position %s \n", arr[findPeak], findPeak);
        Assert.assertEquals(4, findPeak);
    }
    
    @Test
    public void testBitonic(){
        int[] arr = new int[] { 5, 50, 60, 70, 80, 90 , 20, 10, 7, 4, 1};
        int findTarget = bts.searchBitonic(arr, 7);
        Assert.assertEquals(arr.length-3, findTarget);
    }
}
