import java.util.ArrayList;
import java.util.Random;

public class RandomChars {
    public static void main(String[] args) {
        int sizeSet = 5;
        Random rand = new Random();
        ArrayList<Character> charList = new ArrayList<>();
        for(int i=0; i<sizeSet; i++){
            int margin = 0;
            if(rand.nextBoolean()) margin = 32;
            int index = rand.nextInt((int)'Z' - (int)'A' + 1) + (int)'A' + margin;
            charList.add((char) index);
        }
        System.out.println(charList);
    }
}
