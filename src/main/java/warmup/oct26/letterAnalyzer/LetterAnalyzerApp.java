package warmup.oct26.letterAnalyzer;

import mix.RandomChars;

import java.util.ArrayList;
import java.util.Map;

public class LetterAnalyzerApp {
    public static void main(String[] args) {

        RandomChars randomChars = new RandomChars();
        String origin = randomChars.genRandom(80);

        LetterAnalyzer letterAnalyzer = new LetterAnalyzer(origin.toUpperCase());
        Map<Character, ArrayList<Integer>> map = letterAnalyzer.getPairs();

        System.out.println(origin);
        letterAnalyzer.printMap(map);
    }
}
