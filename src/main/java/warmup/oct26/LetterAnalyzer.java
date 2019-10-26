package warmup.oct26;

import java.util.*;

public class LetterAnalyzer {

    private final String text;
    private ArrayList<Integer> currentArray;

    public LetterAnalyzer(String text) {
        this.text = text;
    }

    public Map<Character, ArrayList<Integer>> getPairs() {
        Map<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < this.text.length(); i++) {
            Character character = this.text.charAt(i);
            if (map.containsKey(character)) map.get(character).add(i + 1);
            else map.put(character, new ArrayList<Integer>(Arrays.asList(i + 1)));
        }
        return map;
    }

    public void printMap(Map<Character, ArrayList<Integer>> map) {
        Set<Character> characters = map.keySet();
        for (char c : characters) {
            ArrayList<Integer> indices = map.get(c);
            System.out.println(c + ": " + indices.size() + "; " + indices.toString());
        }
    }

}
