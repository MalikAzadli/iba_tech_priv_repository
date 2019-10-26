package oct24.geometry;

public class Rectangle extends Figure {
    private Point p1;
    private Point p2;

    public Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public double area() {
        return Math.abs((p1.getX()-p2.getX())*(p1.getY()-p2.getY()));
    }
}
