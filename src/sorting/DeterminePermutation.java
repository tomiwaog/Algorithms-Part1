package sorting;

public class DeterminePermutation {
    /*
     * Permutation. Given two integer arrays of size nn, design a subquadratic
     * algorithm to determine whether one is a permutation of the other. That
     * is, do they contain exactly the same entries but, possibly, in a
     * different order.
     */

    static boolean isPermutation(Integer[] a, Integer b[]) {
        if (a == null || b == null)
            return false;
        if (a.length != b.length)
            return false;

        // Use subquadratic Sort for a and b, with ~O(N^2)
        SortTools.shellSort(a);
        SortTools.shellSort(b);

        // Compare value at indices of each array
        for (int i = 0; i < a.length; i++)
            if (!a[i].equals(b[i]))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Integer a[] = new Integer[] { 1, 2, 3, 4, 5 };
        Integer b[] = new Integer[] { 5, 4, 3, 2, 1, 0 };
        boolean result = isPermutation(a, b);
        System.out.println(result);
    }
}
