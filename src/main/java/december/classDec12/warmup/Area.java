package december.classDec12.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Area {
    public static void main(String[] args) {
        Area area = new Area();
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(new Point(1, 10), new Point(5, 5)));
        rectangles.add(new Rectangle(new Point(3, 7), new Point(7, 9)));
        rectangles.add(new Rectangle(new Point(6, 5), new Point(12, 4)));
        int total = area.compute(rectangles);
        System.out.println(total);
    }

    private int compute(List<Rectangle> objects) {
        int result = objects.stream().flatMap(rectangle -> rectangle.points()).collect(Collectors.toSet()).size();

        return result;
    }

}
