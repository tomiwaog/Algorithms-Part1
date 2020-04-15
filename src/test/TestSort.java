package test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import sorting.Sort;

public class TestSort {

    @Test
    public void testIsSortedAsc(){
        int [] arr = new int []{-3,0,4,18,18,20};
        boolean sorted = Sort.isSortedAsc(arr);
        Assert.assertEquals(true, sorted);
    }
    
    @Test
    public void testIsSortedEq(){
        int [] arr = new int []{20,20,20,20};
        boolean sorted = Sort.isSortedAsc(arr);
        Assert.assertEquals(true, sorted);
    }
    
    @Test
    public void testIsSortedAscFalse(){
        int [] arr = new int []{-3,0,4,3,18,18,20};
        boolean sorted = Sort.isSortedAsc(arr);
        Assert.assertEquals(false, sorted);
    }
    
    @Test
    public void testIsSortedDesc(){
        int [] arr = new int []{10,5,0,-5,-5,-9};
        boolean sorted = Sort.isSortedAsc(arr);
        Assert.assertEquals(false, sorted);
    }
    
    @Test
    public void testIsSortedDescFalse(){
        int [] arr = new int []{10,5,0,-5, -4,-5,-9};
        boolean sorted = Sort.isSortedAsc(arr);
        Assert.assertEquals(false, sorted);
    }
    
    @Test
    public void testInsertionSort(){
        int [] arr = new int []{10,5,0,-5,-5,-9,21,-1};
        Sort.insertionSort(arr);
        boolean sorted = Sort.isSortedAsc(arr);
        System.out.println(Arrays.toString(arr));
        Assert.assertEquals(true, sorted);
    }
    
    @Test
    public void testSelectionSort(){
        int [] arr = new int []{10,5,0,-5,-5,-9,21,-1};
        Sort.selectionSort(arr);
        boolean sorted = Sort.isSortedAsc(arr);
        System.out.println(Arrays.toString(arr));
        Assert.assertEquals(true, sorted);
    }
    
    @Test
    public void testBubbleSort(){
        int [] arr = new int []{13, 7, 6, 45, 21, 9, 101, 102, -1};
        Sort.bubbleSort(arr);
        boolean sorted = Sort.isSortedAsc(arr);
        System.out.println(Arrays.toString(arr));
        Assert.assertEquals(true, sorted);
    }
}
