package sorting;

public class SetIntersection {
    /*
     * Intersection of two sets. Given two arrays a[] and b[], each containing n
     * distinct 2D points in the plane, design a subquadratic algorithm to count
     * the number of points that are contained both in array a[] and array b[]
     */
    static int countIntersection(Point[] a, Point[] b) {
        SortTools.shellSort(a); //Sort each Array using subquadratic algo (ShellSort ~O(a^2))
        SortTools.shellSort(b); //Sort each Array using subquadratic algo (ShellSort ~O(b^2))

        int i = 0, j = 0, interSectionCount = 0;
        //Compare each Point to count equality with Point class implementing Comparable
        while (i < a.length && j < b.length) {
            if (a[i].compareTo(b[j]) == 0) {
                interSectionCount++;
                i++;
                j++;
            } else if (a[i].compareTo(b[j]) <= 0) {
                i++;
            } else
                j++;
        }
        //Return numb of equal Points
        return interSectionCount;
    }

    public static void main(String[] args) {
        Point[] a = new Point[] { new Point(1, 0), new Point(1, 0),
                new Point(1, 3), new Point(4, 0), new Point(1, 5),
                new Point(7, 17) };
        Point[] b = new Point[] { new Point(1, 1), new Point(1, 1),
                new Point(3, 1), new Point(0, 0), new Point(15, 0),
                new Point(1, 0) };

        int result = countIntersection(a, b);
        System.out.println(result);
    }
}
