package homePractice;

import java.util.*;
import java.util.stream.Stream;

public class Practice {

    public static <T> T getAway(T element){
        return element;
    }

    public static void main(String[] args) {
        System.out.println(getAway("Jane"));

        List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");

        strings.stream().filter(string -> string.length()<= 6).map(String::length).sorted().limit(3)

                .distinct().forEach(System.out::println);

        Random rand = new Random();
        rand.ints().limit(30).forEach(System.out::println);
    }
}
