package november.classNov12.warmup;

import java.util.Arrays;
import java.util.Random;

public class WarmUp {
    public static void main(String[] args) {

        int[] source = generate(25);
        int[] sorted = sort2(source);
        System.out.println(Arrays.toString(source));
        System.out.println(Arrays.toString(sorted));
    }

    public static int[] generate(int size) {
        Random rand = new Random();
        int[] set = new int[size];
        for (int i = 0; i < set.length; i++) {
            set[i] = rand.nextInt(40) + 10;
        }

        return set;
    }

    public static int[] sort1(int[] arr) {
        int[] sorted = arr.clone();
        int index = 0;
        while (true) {
            if (index == sorted.length - 1) break;

            if (sorted[index] > sorted[index + 1]) {
                sorted[index] = sorted[index] ^ sorted[index + 1];
                sorted[index + 1] = sorted[index] ^ sorted[index + 1];
                sorted[index] = sorted[index] ^ sorted[index + 1];
                index = 0;
            } else index++;
        }

        return sorted;
    }

    public static int[] sort2(int[] arr) {
        int[] sorted = arr.clone();
        for (int i = 0; i < sorted.length; i++) {
            for (int j = 0; j < sorted.length; j++){
                if(sorted[i] < sorted[j]){
                    sorted[i] = sorted[i] ^ sorted[j];
                    sorted[j] = sorted[i] ^ sorted[j];
                    sorted[i] = sorted[i] ^ sorted[j];
                }
            }
        }

        return sorted;
    }
}
