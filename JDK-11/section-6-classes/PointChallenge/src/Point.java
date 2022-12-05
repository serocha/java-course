public class Point {
    private int x;
    private int y;

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance() {
        // distance from origin -> sqrt( (Xb-Xa)*(Xb-Xa) + (Yb-Ya)*(Yb-Ya) )
        return Math.sqrt( x*x + y*y ); // first point is 0
    }

    public double distance(int x, int y) {
        // distance from coordinate
        return Math.sqrt( (this.x - x)*(this.x - x) + (this.y - y) * (this.y - y));
    }

    public double distance(Point point) {
        // distance from other Point object
        return Math.sqrt( (x - point.getX())*(x - point.getX()) +
                (y - point.getY())*(y - point.getY()) );
    }
}
