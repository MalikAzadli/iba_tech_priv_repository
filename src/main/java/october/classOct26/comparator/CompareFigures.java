package october.classOct26.comparator;

import october.classOct24.*;


import java.util.ArrayList;
import java.util.Collections;

public class CompareFigures {
    public static void main(String[] args) {
        ArrayList<Figure> figures = new ArrayList<>();
        figures.add(new Rectangle(new Point(3, 6), new Point(4, 8)));
        figures.add(new Rectangle(new Point(5, 6), new Point(0, 0)));
        figures.add(new Triangle(new Point(3, 6), new Point(4, 8), new Point(0, 0)));
        figures.add(new Circle(new Point(3, 6), 7));

        figures.forEach(figure -> System.out.println(">>" + figure));

        Collections.sort(figures, (p1, p2) -> (int) (p1.area() - p2.area()));

        figures.forEach(figure -> System.out.println("<<" + figure));


    }
}
