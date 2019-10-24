import java.util.Random;

public class RandomChars {

    public static void main(String[] args) {
        RandomChars randomChars = new RandomChars();
        int size1 = 10;
        int size2 = 5;
        String s1 = randomChars.genRandom(size1);
        String s2 = randomChars.genRandom(size2);
        System.out.println(s1);
        System.out.println(s2);
    }


    public String genRandom(int size) {
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
