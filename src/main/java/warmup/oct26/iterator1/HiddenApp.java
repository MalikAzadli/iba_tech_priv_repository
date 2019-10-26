package warmup.oct26.iterator1;

import java.util.Iterator;

public class HiddenApp {
    public static void main(String[] args) {
        HiddenData months = new HiddenData();
//
//        for (String month : months) {
//            System.out.printf("** %s **\n", month);
//        }
//
//        Iterator<String> it = months.reverseIterator();
//        while (it.hasNext()) {
//            System.out.printf(">> %s <<\n", it.next());
//        }
//
//        months.forEach(m -> System.out.printf("<< %s >>\n", m));
//
        Iterator<String> randomIterator = months.randomIterator();

        while (randomIterator.hasNext()) {
            System.out.println(randomIterator.next());
        }
    }
}
