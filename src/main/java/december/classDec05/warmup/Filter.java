package december.classDec05.warmup;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Filter {
    public static void main(String[] args) {
        Filter filter = new Filter();
        String origin = "abscadsn";
        String filtered = filter.filter(origin);

        System.out.printf("Origin: %s\n", origin);
        System.out.printf("Filtered: %s\n", filtered);

    }

    public String filter(String origin){
        return origin.chars()
                .distinct()
                .mapToObj(i -> String.format("%s", (char) i))
                .collect(Collectors.joining());
    }
}
