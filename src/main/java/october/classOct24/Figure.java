package october.classOct24;

public abstract class Figure implements Comparable<Figure> {

    public abstract double area();

    @Override
    public int compareTo(Figure o) {
        return (int) (this.area() - o.area());
    }

    @Override
    public String toString() {
        return String.format("Figure: %s Area: %d",this.getClass().getSimpleName(), area());
    }
}
