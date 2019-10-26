package warmup.oct26;

import mix.RandomChars;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LetterAnalyzer {

    private String text;
    private ArrayList<Integer> currentArray;

    public LetterAnalyzer(String text){
        this.text = text;
    }

    public void getIndices(Character ch){
        for(int i = 0; i < this.text.length(); i++){
            if(ch.equals(text.charAt(i))) currentArray.add(i+1);
        }
    }

    public Map<Character, ArrayList<Integer>> getPairs(){
        Map<Character, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < this.text.length(); i++){
            Character character = this.text.charAt(i);
            this.currentArray = new ArrayList<>();
            if(map.containsKey(character)) continue;
            getIndices(character);
            map.put(character, currentArray);
        }
        return map;
    }

    public void printMap(Map<Character, ArrayList<Integer>> map){
        Set<Character> characters = map.keySet();
        for(char c: characters){
            ArrayList<Integer> indices = map.get(c);
            System.out.println(c + ": " + indices.size()+"; " + indices.toString());
        }
    }

}
