import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {
    static private final double CONFIDENCE_95 = 1.96;
    final private int trialTimes;
    final private double[] percolationtrialScores;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException();
        trialTimes = trials;
        int grid = n;
        percolationtrialScores = new double[trialTimes];
        for (int i = 0; i < trials; i++) {
            // Repeat experiment trials times
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                // Open random sites till percolation
                int randNum = StdRandom.uniform(n * n);
                int row = (randNum / grid), col = randNum % grid;
                if (!p.isOpen(row + 1, col + 1))
                    p.open(row + 1, col + 1); // accommodates for +1 on open
            }
            double fractionofSitesOpen = (double) (p.numberOfOpenSites())
                    / (n * n);
            percolationtrialScores[i] = fractionofSitesOpen;
            // StdOut.println("took " + fractionofSitesOpen +
            // "p | Opened sites: "
            // + p.numberOfOpenSites() + " of " + (n * n));
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(percolationtrialScores);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(percolationtrialScores);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((stddev() * CONFIDENCE_95) / Math.sqrt(trialTimes));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((stddev() * CONFIDENCE_95) / Math.sqrt(trialTimes));
    }

    // test client (see below)
    public static void main(String[] args) {
        int grid = 0;
        int trials = 0;
        if (args.length > 0) {
            grid = Integer.parseInt(args[0]);
            trials = Integer.parseInt(args[1]);
        }

        // int grid = 10;
        // int trials = 3;
        PercolationStats ps = new PercolationStats(grid, trials);
        StdOut.println("STD: " + ps.stddev());
    }

}
