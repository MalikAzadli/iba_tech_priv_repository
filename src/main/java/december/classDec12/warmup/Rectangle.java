package december.classDec12.warmup;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Rectangle {
    private final Point a;
    private final Point b;

    public Rectangle(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public Point a() {
        return a;
    }

    public Point b() {
        return b;
    }

    public int right(){
        return Math.max(a.x(), b.x());
    }

    public int left(){
        return Math.min(a.x(), b.x());
    }

    public int top(){
        return Math.max(a.y(), b.y());
    }

    public int bottom(){
        return Math.min(a.y(), b.y());
    }

    public Stream<Integer> x_range(){
        return IntStream.range(left(), right()).boxed();
    }

    public Stream<Integer> y_range(){
        return IntStream.range(bottom(), top()).boxed();
    }

    public Stream<Point> points(){
        return x_range().flatMap(x -> y_range().map(y -> new Point(x, y)));
    }

}
