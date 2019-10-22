
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomChars {
    public static void main(String[] args) {
        String s1 = genRandom(10);
        String s2 = genRandom(5);
        System.out.println(s1);
        System.out.println(s2);
    }

    public static String genRandom(int size) {
        int sizeSet = size;
        Random rand = new Random();
        String stream = "";
        for(int i=0; i<sizeSet; i++){
            int index = rand.nextInt((int)'Z' - (int)'A' + 1) + (int)'A' + rand.nextInt(2)*32;
            stream += ((char) index);
        }

        return stream;
    }
}
