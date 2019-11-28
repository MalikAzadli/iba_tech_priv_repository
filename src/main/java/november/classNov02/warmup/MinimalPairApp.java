package november.classNov02.warmup;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MinimalPairApp {
    public static void main(String[] args) {
        List<Integer> arr = Stream
                .generate(() -> (int) (Math.random() * 100))
                .limit(31)
                .collect(Collectors.toList());

        Pair pair = IntStream.range(0, arr.size() - 1)
                .mapToObj(index -> new Pair(index, arr.get(index) + arr.get(index + 1)))
                .min(Comparator.comparingInt(Pair::getSum))
                .orElseThrow(() -> new IllegalArgumentException("Not considered to work with empty object"));

        System.out.println(arr.toString());
        System.out.println("Left index: " + pair.getIndex());
        System.out.println("Right index: " + (pair.getIndex()+1));
        System.out.println("Sum " + pair.getSum());


    }
}
