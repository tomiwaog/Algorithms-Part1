package test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import sorting.*;

public class TestSortTools {

    @Test
    public void testisSortedAsc() {
        Integer[] arr = new Integer[] { -3, 0, 4, 18, 18, 20 };
        boolean SortToolsed = SortTools.isSortedAsc(arr);
        Assert.assertEquals(true, SortToolsed);
    }

    @Test
    public void testisSortedAscStrFalse() {
        String[] arr = new String[] { "bbb", "bbc", "bab", "aaa" };
        boolean SortToolsed = SortTools.isSortedAsc(arr);
        Assert.assertEquals(false, SortToolsed);
    }

    @Test
    public void testisSortedAscStr() {
        String[] arr = new String[] { "aaa", "bab", "bbb", "bbc", };
        boolean SortToolsed = SortTools.isSortedAsc(arr);
        Assert.assertEquals(true, SortToolsed);
    }

    @Test
    public void testIsSortedEq() {
        Integer[] arr = new Integer[] { 20, 20, 20, 20 };
        boolean SortToolsed = SortTools.isSortedAsc(arr);
        Assert.assertEquals(true, SortToolsed);
    }

    @Test
    public void testisSortedAscFalse() {
        Integer[] arr = new Integer[] { -3, 0, 4, 3, 18, 18, 20 };
        boolean SortToolsed = SortTools.isSortedAsc(arr);
        Assert.assertEquals(false, SortToolsed);
    }

    @Test
    public void testIsSortedDesc() {
        Integer[] arr = new Integer[] { 10, 5, 0, -5, -5, -9 };
        boolean SortToolsed = SortTools.isSortedAsc(arr);
        Assert.assertEquals(false, SortToolsed);
    }

    @Test
    public void testIsSortedDescFalse() {
        Integer[] arr = new Integer[] { 10, 5, 0, -5, -4, -5, -9 };
        boolean sorted = SortTools.isSortedAsc(arr);
        Assert.assertEquals(false, sorted);
    }

    @Test
    public void testInsertionSort() {
        Integer[] arr = new Integer[] { 10, 5, 0, -5, -5, -9, 21, -1 };
        ElementarySort.insertionSort(arr);
        boolean sorted = SortTools.isSortedAsc(arr);
        System.out.println(Arrays.toString(arr));
        Assert.assertEquals(true, sorted);
    }

    @Test
    public void testSelectionSort() {
        Integer[] arr = new Integer[] { 10, 5, 0, -5, -5, -9, 21, -1 };
        ElementarySort.selectionSort(arr);
        boolean SortToolsed = SortTools.isSortedAsc(arr);
        System.out.println(Arrays.toString(arr));
        Assert.assertEquals(true, SortToolsed);
    }

    @Test
    public void testBubbleSort() {
        Integer[] arr = new Integer[] { 13, 7, 6, 45, 21, 9, 101, 102 };
        ElementarySort.bubbleSort(arr);
        boolean isSorted = SortTools.isSortedAsc(arr);
        System.out.println(Arrays.toString(arr));
        Assert.assertEquals(true, isSorted);
    }

    @Test
    public void testShellSort() {
        Integer[] arr = new Integer[] { 100, 80, 70, 60, 90, 40, 30, 20, 10,
                -3, 14 };
        SortTools.shellSort(arr);
        boolean sorted = SortTools.isSortedAsc(arr);
        System.out.println(Arrays.toString(arr));
        Assert.assertEquals(true, sorted);
    }

    @Test
    public void testShellSortString() {
        String[] arr = new String[] { "bbb", "bbc", "bab", "aaa" };
        SortTools.shellSort(arr);
        boolean sorted = SortTools.isSortedAsc(arr);
        System.out.println(Arrays.toString(arr));
        Assert.assertEquals(true, sorted);
    }

    @Test
    public void testMerge() {
        Integer arr[] = new Integer[] { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10 };
        MergeSort.merge(arr, new Integer[arr.length], 0, 4, arr.length - 1);
        boolean sorted = SortTools.isSortedAsc(arr);
        System.out.println("Merge Func: " + Arrays.toString(arr));
        Assert.assertEquals(true, sorted);
    }

    @Test
    public void testMergeTwo() {
        Integer array1[] = new Integer[] { 0, 1, 1, 3, 5, 7, 9 };
        Integer array2[] = new Integer[] { 2, 3, 4, 6, 8, 10 };
        Comparable[] arr = MergeSort.mergeTwo(array1, array2);
        boolean sorted = SortTools.isSortedAsc(arr);
        System.out.println("Merge Func2: " + Arrays.toString(arr));
        Assert.assertEquals(true, sorted);
    }

    @Test
    public void testMergeSort() {
        Integer[] arr = new Integer[] { 100, 80, 70, 60, 90, 40, 30, 20, 10,
                -3, 14 };
        MergeSort.sort(arr, new Integer[arr.length], 0, arr.length - 1);
        boolean sorted = SortTools.isSortedAsc(arr);
        System.out.println("MergeSort: " + Arrays.toString(arr));
        Assert.assertEquals(true, sorted);
    }

    @Test
    public void testQuickSort() {
        Integer[] arr = new Integer[] { 100, 80, 70, 60, 90, 40, 30, 20, 10,
                -3, 14 };
        QuickSort.sort(arr, 0, arr.length - 1);
        boolean sorted = SortTools.isSortedAsc(arr);
        System.out.println("QuickSort: " + Arrays.toString(arr));
        Assert.assertEquals(true, sorted);
    }

    @Test
    public void testQuickSelect(){
        Integer arr[] = new Integer[] { -1, -3, 5, 7, 9,10, 2, 4, 6, 8};
        Integer result = (Integer)QuickSelect.selectPosition(arr,1);
        System.out.println("Quick Select: " + result);
        Assert.assertEquals(new Integer(-3), result);
    }
    
    @Test
    public void testPartitionQuickSelect(){
        Integer arr[] = new Integer[] { 10, 3, 5, 7, 9, 1, 2, 4, 6, 8};
        int partition = QuickSelect.partition(arr, 0, arr.length-1);
        System.out.println("10 is partition for location "+ partition);
        Assert.assertEquals(9, partition);
    }
    
    @Test
    public void testKLargestElement(){
        Integer x[] = new Integer[]{3,-5,10,2,8};
        Integer l = (Integer) QuickSelect.findKthLargest(x,2);
        System.out.println("Kth Largest: " + l);
        Assert.assertEquals(new Integer(8), l);
    }
    
    @Test
    public void testMergeSortSpaceOptimized() {
        Integer[] arr = new Integer[] { 100, 80, 70, 60, 90, 40, 30, 20, 10,
                -3, 14 };
        // Integer[] arr = new Integer[] {100, 80, 70, 60, 90 };
        SortTools.mergeSortSpaceOptimization(arr);
        boolean sorted = SortTools.isSortedAsc(arr);
        System.out.println("MergeSort Optimized: " + Arrays.toString(arr));
        Assert.assertEquals(true, sorted);
    }


}
