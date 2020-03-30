import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[] oneD;
    final private WeightedQuickUnionUF wqu;
    private int numberOfOpenSites = 0;
    final private int top, bottom, gridNum;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
        wqu = new WeightedQuickUnionUF(n * n + 2); // Spaces for top+bottom
        oneD = new boolean[n * n]; // Storage for tracking open sites O(1)
        top = n * n; // Root element avoiding linear traversal of top elements
        bottom = n * n + 1; // temporary node for open bottom elements
        gridNum = n;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (isOpen(row, col))
            return;
        col--;
        row--;

        int currentSiteIndex = rowCellToID(row, col);
        if (row >= gridNum || row < 0 || col < 0 || col >= gridNum)
            throw new IllegalArgumentException();

        int down = rowCellToID(row + 1, col);
        int up = rowCellToID(row - 1, col);
        int left = rowCellToID(row, col - 1);
        int right = rowCellToID(row, col + 1);
        oneD[currentSiteIndex] = true; // Assigns current site to open
        if (row == 0)
            wqu.union(currentSiteIndex, top);
        if (row == gridNum - 1)
            wqu.union(currentSiteIndex, bottom);

        if (up >= 0 && row - 1 >= 0 && oneD[up])
            wqu.union(currentSiteIndex, up);
        if (left >= 0 && col - 1 >= 0 && oneD[left])
            wqu.union(currentSiteIndex, left);
        if (right < (gridNum * gridNum) && (col + 1) <= gridNum - 1
                && oneD[right])
            wqu.union(currentSiteIndex, right);
        if (down < gridNum * gridNum && (row + 1 <= gridNum - 1) && oneD[down])
            wqu.union(currentSiteIndex, down);
        numberOfOpenSites++;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        col--;
        row--;
        if (row >= gridNum || row < 0 || col < 0 || col >= gridNum)
            throw new IllegalArgumentException();
        int currentSiteIndex = rowCellToID(row, col);
        return oneD[currentSiteIndex];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        col--;
        row--;
        if (row >= gridNum || row < 0 || col < 0 || col >= gridNum)
            throw new IllegalArgumentException();
        int currentSiteIndex = rowCellToID(row, col);
        return wqu.find(currentSiteIndex) == wqu.find(top);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    // Maps cells row to eligible location in 1D area.
    private int rowCellToID(int row, int col) {
        int output = ((gridNum) * row + col);
        return output;
    }

    // does the system percolate?
    public boolean percolates() {
        return wqu.find(bottom) == wqu.find(top);
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation percolation = new Percolation(3);
        percolation.open(2, 1);
        percolation.open(3, 3); // 8
        percolation.open(3, 2);
        percolation.open(1, 2);
        percolation.open(1, 3);
        percolation.open(1, 3);
        percolation.open(3, 1);
        percolation.open(2, 3); // 5

        System.out.println("percolate? " + percolation.percolates());
        // System.out.println("Number of open sites: "
        // + percolation.numberOfOpenSites);
    }
}