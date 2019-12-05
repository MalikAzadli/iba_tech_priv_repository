package december.classDec03.warmup;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WorkingWithArrays {
    public static void main(String[] args) {
        int[][] origin = {{1, 6, 3}, {}, {5, 4}, {7, 8, 2, 9}, {}};
        IntStream intStream = Arrays.stream(origin)
                .flatMap(arr -> Arrays.stream(arr)
                        .mapToObj(op -> op))
                .mapToInt(o -> o);
        IntStream intStream1 = intStream;

//        IntStream intStream = Arrays.stream(origin).flatMapToInt(Arrays::stream);
        IntSummaryStatistics intSummaryStatistics = intStream.summaryStatistics();
        int min = intSummaryStatistics.getMin();
        int len = (int) intSummaryStatistics.getCount();
        int max = intSummaryStatistics.getMax();
        int sum = (int) intSummaryStatistics.getSum();
        int average = (int) intSummaryStatistics.getAverage();

        System.out.printf("NON nested structure: %s\n" +
                "min: %d\n" +
                "max: %d\n" +
                "size : %d\n" +
                "average : %d\n" +
                "total sum : %d", "collect", min, max, len, average, sum);
    }
}
