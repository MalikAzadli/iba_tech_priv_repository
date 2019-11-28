package october.classOct26.letterAnalyzer;

import java.util.*;

public class LetterAnalyzer {

    private final String text;

    public LetterAnalyzer(String text) {
        this.text = text;
    }

    public Map<Character, ArrayList<Integer>> getPairs() {
        Map<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < this.text.length(); i++) {
            Character character = this.text.charAt(i);
            if (map.containsKey(character)) map.get(character).add(i + 1);
            else map.put(character, new ArrayList<>(Arrays.asList(i + 1)));
        }
        return map;
    }

    public void printMap(Map<Character, ArrayList<Integer>> map) {
//        Set<Character> characters = map.keySet();
//        for (char c : characters) {
//            ArrayList<Integer> indices = map.get(c);
//            System.out.println(c + ": " + indices.size() + "; " + indices.toString());
//        }

//        for(Map.Entry entry: map.entrySet()){
//            ArrayList<Integer> indices = (ArrayList) entry.getValue();
//            System.out.println(entry.getKey() + ": " + indices.size() + "; " + indices.toString());
//        }

        map.forEach((k, v) -> System.out.printf("%c : %d : %s\n", k, v.size(), v.toString()));
    }

}
