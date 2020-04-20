package sorting;

public class Point implements Comparable<Point>{
    private int x, y;
    
    public Point(int x, int y){
        this.x =x;
        this.y =y;
    }
    
    @Override
    public int compareTo(Point thatPoint) {
        if (this.x>thatPoint.x) return 1;
        if (this.x<thatPoint.x)return -1;
        if (this.y>thatPoint.y)return 1;
        if (this.y<thatPoint.y) return -1;
        return 0;
    }
    
}
