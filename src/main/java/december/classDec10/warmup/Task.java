package december.classDec10.warmup;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {
    public static void main(String[] args) {
        Task task = new Task();
        Stream<Integer> generate = Stream.generate(() -> (int) (Math.random() * 51 - 25)).limit(50);
//        int[] arr = (new Random()).ints(10, -25, 25).toArray();
        task.group(generate);
    }

    public void group(Stream<Integer> origin) {
        Function<Integer, String> c1 = element -> {
            if(element < -10) return "negative";
            else if(element > 10) return "positive";
            else return "rest";
        };

        Function<Integer, String> c2 = element -> Math.abs(element)%2==0 ? "Even" : "Odd";

        Map<String, Map<String, List<Integer>>> collected = origin
                .collect(Collectors.groupingBy(c1, Collectors.groupingBy(c2)));

//        origin.collect(Collectors.groupingBy(c1, Collectors.groupingBy(c2)))

        collected.forEach((k,v) -> System.out.printf("%s: %s \n", k, v));

    }
}
