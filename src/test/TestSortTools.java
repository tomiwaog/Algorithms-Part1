package test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import sorting.SortTools;

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
        boolean SortToolsed = SortTools.isSortedAsc(arr);
        Assert.assertEquals(false, SortToolsed);
    }

    @Test
    public void testInsertionSort() {
        Integer[] arr = new Integer[] { 10, 5, 0, -5, -5, -9, 21, -1 };
        SortTools.insertionSort(arr);
        boolean SortToolsed = SortTools.isSortedAsc(arr);
        System.out.println(Arrays.toString(arr));
        Assert.assertEquals(true, SortToolsed);
    }

    @Test
    public void testSelectionSort() {
        Integer[] arr = new Integer[] { 10, 5, 0, -5, -5, -9, 21, -1 };
        SortTools.selectionSort(arr);
        boolean SortToolsed = SortTools.isSortedAsc(arr);
        System.out.println(Arrays.toString(arr));
        Assert.assertEquals(true, SortToolsed);
    }

    @Test
    public void testBubbleSort() {
        Integer[] arr = new Integer[] { 13, 7, 6, 45, 21, 9, 101, 102 };
        SortTools.bubbleSort(arr);
        boolean SortToolsed = SortTools.isSortedAsc(arr);
        System.out.println(Arrays.toString(arr));
        Assert.assertEquals(true, SortToolsed);
    }

    @Test
    public void testShellSort() {
        Integer[] arr = new Integer[] { 100, 80, 70, 60, 90, 40, 30, 20, 10,
                -3, 14 };
        SortTools.shellSort(arr);
        boolean SortToolsed = SortTools.isSortedAsc(arr);
        System.out.println(Arrays.toString(arr));
        Assert.assertEquals(true, SortToolsed);
    }

    @Test
    public void testShellSortString() {
        String[] arr = new String[] { "bbb", "bbc", "bab", "aaa" };
        SortTools.shellSort(arr);
        boolean SortToolsed = SortTools.isSortedAsc(arr);
        System.out.println(Arrays.toString(arr));
        Assert.assertEquals(true, SortToolsed);
    }
}
