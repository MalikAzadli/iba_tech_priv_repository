import java.util.ArrayList;
import java.util.Random;

public class RandomChars {
    public static void main(String[] args) {
        int sizeSet = 32;
        Random rand = new Random();
        ArrayList<Character> charList = new ArrayList<>();
        for(int i=0; i<sizeSet; i++){
            int index = rand.nextInt((int)'Z' - (int)'A' + 1) + (int)'A' + rand.nextInt(2)*32;
            charList.add((char) index);
        }
        System.out.println(charList);
    }
}
