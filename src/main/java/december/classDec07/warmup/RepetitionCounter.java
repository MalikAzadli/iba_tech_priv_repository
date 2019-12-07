package december.classDec07.warmup;

import java.util.*;
import java.util.stream.Collectors;

public class RepetitionCounter {
    public static void main(String[] args) {
        RepetitionCounter repetitionCounter = new RepetitionCounter();
        int[] rand_ints = (new Random()).ints(50, 10, 25).toArray();
        int minRepetition = repetitionCounter.getMinRepetition2(rand_ints);

        System.out.println(Arrays.toString(rand_ints));
        System.out.println(minRepetition);
    }

    private int getMinRepetition1(int[] origin) {
        int[] arr = origin.clone();
        int num = Arrays.stream(arr)
                .distinct()
                .mapToObj(i -> new Pair(i, (int) Arrays.stream(arr).filter(numb -> numb == i).count()))
                .min(Comparator.comparingInt(Pair::getCount))
                .get()
                .getNumber();

        return num;
    }

    private int getMinRepetition2(int[] origin) {
        List<Integer> arr = Arrays.stream(origin)
                .boxed()
                .collect(Collectors.toList());

        Integer integer = arr.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .min(((o1, o2) -> (int) (o1.getValue() - o2.getValue())))
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new IllegalArgumentException());

        return integer;
    }
}
