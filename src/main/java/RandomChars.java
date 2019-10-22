import java.util.Random;

public class RandomChars {
    public static void main(String[] args) {
        int size1 = 10;
        int size2 = 5;
        String s1 = genRandom(size1);
        String s2 = genRandom(size2);
        System.out.println(s1);
        System.out.println(isLegal(s1, size1));
        System.out.println(s2);
        System.out.println(isLegal(s2, size2));

    }

    public static boolean isLegal(String s, int size){
        boolean flag = true;
        if(s.length() != size){
            System.out.println("Different size.");
            flag = false;
        }
        for(int i = 0; i < s.length(); i++){
            if((s.charAt(i) > 'Z' && s.charAt(i) < 'A') || (s.charAt(i) > 'z' && s.charAt(i) < 'a')){
                System.out.println("Not in range.");
                flag = false;
            }
        }

        return flag;
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
