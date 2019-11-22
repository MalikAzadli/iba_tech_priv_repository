package classNov16.warmUp;

import java.util.Arrays;
import java.util.Random;

public class Sorting {

    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        Random rand = new Random();
        int[] array = new int[30];
        for (int i = 0; i < array.length; i++) array[i] = rand.nextInt(101);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sorting.sort1(array)));
        System.out.println(Arrays.toString(sorting.sort2(array)));
    }

    private int[] sort1(int[] arr) {
        int[] array = arr.clone();

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[i]) {
                    array[i] = array[i] ^ array[j];
                    array[j] = array[i] ^ array[j];
                    array[i] = array[i] ^ array[j];
                }
            }
        }

        return array;
    }

    private int[] sort2(int[] arr) {
        int[] array = arr.clone();


        return array;
    }

}
