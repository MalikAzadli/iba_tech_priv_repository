package oct24.geometry;

public abstract class Figure implements Comparable<Figure> {

    public abstract double area();

    @Override
    public int compareTo(Figure o) {
        return (int) (this.area() - o.area());
    }


}
