package classOct29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class ComparatorApplication {

    public Comparator<Integer> sortArr() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                if ((o1 % 2 == 0 && o2 % 2 == 0)) return o2 - o1;
                if ((o1 % 2 != 0 && o2 % 2 != 0)) return o1 - o2;
                if (o1 % 2 == 0) return -1;

                return 0;
            }
        };
        return comparator;
    }

    public static void main(String[] args) {
        ComparatorApplication app = new ComparatorApplication();
        Random rand = new Random();
        ArrayList<Integer> randomArray = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            randomArray.add(rand.nextInt(100));
        }
        System.out.println(randomArray.toString());
        Comparator<Integer> comparator = app.sortArr();
        Collections.sort(randomArray, comparator);
        System.out.println(randomArray.toString());

    }

}
