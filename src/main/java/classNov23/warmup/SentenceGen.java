package classNov23.warmup;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SentenceGen {
    public static void main(String[] args) {
        SentenceGen sentence = new SentenceGen();
        List<String> subjects = new ArrayList<>(Arrays.asList("Noel", "The cat", "The dog"));
        List<String> verbs = new ArrayList<>(Arrays.asList("wrote", "chased", "slept on"));
        List<String> objects = new ArrayList<>(Arrays.asList("the book", "the ball", "the bed"));

//        List<String> sentences = sentence.make(subjects, verbs, objects);
//        List<String> sentences = sentence.makeWithoutFor(subjects, verbs, objects);
        List<String> sentences = sentence.makeWithMap(subjects, verbs, objects);
        sentences.forEach(System.out::println);
    }

    public List<String> make(List<String> subjects, List<String> verbs, List<String> objects) {
        List<String> sentences = new ArrayList<>();
        subjects.forEach(s -> {
            verbs.forEach(v -> {
                objects.forEach(o -> {
                    sentences.add(String.format("%s %s %s", s, v, o));
                });
            });
        });
        return sentences;
    }

    public List<String> makeWithoutFor(List<String> subjects, List<String> verbs, List<String> objects) {
//        return subjects.stream()
//                .flatMap(s -> verbs.stream().map(v -> String.format("%s %s", s, v)))
//                .flatMap(e -> objects.stream().map(o -> String.format("%s %s", e, o)))
//                .collect(Collectors.toList());

        return subjects.stream()
                .flatMap(s ->
                        verbs.stream().flatMap(v ->
                                objects.stream().map(o ->
                                        String.format("%s %s %s", s, v, o))))
                .collect(Collectors.toList());
    }

    public List<String> makeWithMap(List<String> subjects, List<String> verbs, List<String> objects) {
        Map<String, List<String>> assoc_subj_verb = map(
                of("Noel", list("wrote", "chased", "slept on")),
                of("The cat", list("meowed at", "chased", "slept on")),
                of("The dog", list("barked at", "chased", "slept on")));

        Map<String, List<String>> assoc_verb_obj = map(
                of("wrote", list("the book", "the letter", "the code")),
                of("chased", list("the ball", "the dog", "the cat")),
                of("slept on", list("the bed", "the mat", "the train")),
                of("meowed at", list("Noel", "the door", "the food cupboard")),
                of("barked at", list("the postman", "the car", "the cat")));

        return assoc_subj_verb.keySet().stream()
                .flatMap(key ->
                        assoc_subj_verb.get(key).stream().flatMap(v ->
                                assoc_verb_obj.get(v).stream()
                                        .map(o -> combine(key, v, o))))
                .collect(Collectors.toList());

    }

    public <T> Map<T, List<T>> map(Entry<T, List<T>>...items){
        HashMap<T, List<T>> hashMap = new HashMap<>();
        for(Entry<T, List<T>> t: items){
            hashMap.put(t.getKey(), t.getVal());
        }
        return hashMap;
    }

    public <T> Entry<T, List<T>> of(T key, List<T> values){
        return new Entry<>(key, values);
    }

    public static <T> List<T> list(T... strings) {
        return Arrays.asList(strings);
    }

    public static <T> String combine(T... words) {
        StringJoiner sj = new StringJoiner(" ");
        for (T word: words) sj.add(word.toString());
        return sj.toString();
    }
}