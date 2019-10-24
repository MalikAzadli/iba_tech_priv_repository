package Geometry;

public class Circle extends Figure {
    private Point c1;
    private Point c2;
    private double radius;

    public Circle(Point c1, Point c2){
        this.c1 = c1;
        this.c2 = c2;
        radius = Math.sqrt(Math.pow(c1.getX()-c2.getX(), 2.0) + Math.pow(c1.getY()-c2.getY(), 2.0));
    }
    @Override
    public double area() {
        return Math.abs(3.14*(radius*radius));
    }
}
