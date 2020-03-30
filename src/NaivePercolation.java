public class NaivePercolation {
	int [][]grid;
	int numberOfOpenSites=0;
	int top =555, bottom = 0;
	int []sites;
    // creates n-by-n grid, with all sites initially blocked
    public NaivePercolation(int n){
    	if (n<=0) throw new IllegalArgumentException();
    	grid = new int[n][n];
    	sites = new int[n*n];
    	for (int i=0;i<n*n;i++)sites[i]=i;
    }
    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
    	if (row<0 || row>=grid.length || col <0 || col>=grid[row].length) throw new IllegalArgumentException();
    	if (grid[row][col]==0){
    		grid[row][col]=1;
    		numberOfOpenSites++;
    	}
    }

    public void union(int site1, int site2){
    	int s1 = sites[site1];
    	int s2 = sites[site2];

    	if (s1== top || s2==top){
    		sites[site2]= top;
    		sites[site1]=top;
    	}
//    	System.out.printf("index %d points to=%d | index %s points to=%d \n", site1,sites[site1],site2,sites[site2]);

    }
    
    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
    	if (row<0 || row>=grid.length || col <0 || col>=grid[row].length) throw new IllegalArgumentException();
    	return grid[row][col] ==1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col){
    	if (row<0 || row>=grid.length || col <0 || col>=grid[row].length) throw new IllegalArgumentException();
    	int location = (grid.length*row)+col;
    	return sites[location] ==top;
    }
    

    // returns the number of open sites
    public int numberOfOpenSites(){
    	return numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates(){
    	for (int i=0; i<grid.length;i++){
    		for (int j=0; j<grid[i].length;j++){
    			if (grid[i][j]==1){
    				
    				int location = (grid.length*i)+j;
    				if (i==0) sites[location] = top; //top row
    				else{
    					if (i>0 && grid[i-1][j]==1)union(location, (grid.length*(i-1))+j);//u up
    					if (j+1<grid[i].length && grid[i][j+1]==1)union(location, location+1); //u right
    					if (j>0 && grid[i][j-1]==1)union(location, (grid.length*i+j)-1); //u left
    					if (i+1<grid.length && grid[i+1][j]==1)union(location, (grid.length*(i+1)+j)); //u down
    				}
    			}
    		}
    	}
    	
    	int[] lastRow = grid[grid.length-1];
    	for (int i=0; i < lastRow.length; i++){
    		int location = (grid.length-2)*grid.length+i;			
    		if (lastRow[i]==1 && sites[location] ==top){
    			return true;
    		}
    	}
    	return false;
    }
    
    void printGrid(){
    	for (int[] i: grid){
    		for (int j: i) System.out.print(j+ " ");
    		System.out.println();
    	}
    }
    // test client (optional)
    public static void main(String[] args){
    	/*
    	 * 1 1 0 0 0
    	 * 1 1 0 0 1
    	 * 0 1 1 1 0
    	 * 0 0 0 1 1 
    	 * 0 0 0 0 1
    	 */
    	NaivePercolation p = new NaivePercolation(5);
    	p.open(0,0); p.open(0, 1);
    	p.open(1,1);p.open(1,0);p.open(1,4);
    	p.open(2,1);p.open(2,2);p.open(2,3);
    	p.open(3,3);p.open(3,4);
    	p.open(4,4);
    	
    	p.percolates();
    	p.printGrid();
    	System.out.println("Percolates?: "+ p.percolates() );
    	System.out.println("Number of open sites: "+ p.numberOfOpenSites);
    }
}