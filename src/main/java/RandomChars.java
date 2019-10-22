
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Set size: ");
        int size = scan.nextInt();
        printRandomChars(size);
    }

    public static void printRandomChars(int size) {
        int sizeSet = size;
        Random rand = new Random();
        ArrayList<Character> charList = new ArrayList<>();
        for(int i=0; i<sizeSet; i++){
            int index = rand.nextInt((int)'Z' - (int)'A' + 1) + (int)'A' + rand.nextInt(2)*32;
            charList.add((char) index);
        }
        System.out.println(charList);
    }
}
