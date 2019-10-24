package Geometry;

public class GeomApp {
    public static void main(String[] args) {
        Figure rectangle = new Rectangle(new Point(0,0), new Point(7,8));
        Figure triangle = new Triangle(new Point(0,0), new Point(3,5), new Point(7,0));
        Figure circle = new Circle(new Point(0,0), 5);
        System.out.println("Rectangle area: " + rectangle.area());
        System.out.println("Triangle area: " + triangle.area());
        System.out.println("Circle area: " + circle.area());
    }
}
