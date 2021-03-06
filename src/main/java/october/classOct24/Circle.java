package october.classOct24;

public class Circle extends Figure {
    private Point c1;
    private Point c2;
    private double radius;

    public Circle(Point c1, double radius){
        this.c1 = c1;
        this.c2 = c2;
        this.radius = radius;
    }
    @Override
    public double area() {
        return Math.abs(3.14*(radius*radius));
    }
}
