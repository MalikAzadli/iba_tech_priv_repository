package _practice.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] array = new Random().ints(30, 0, 30).toArray();
        int[] sorted = sort.sort(array);

        System.out.println("origin: " + Arrays.toString(array));
        System.out.println("sorted: " + Arrays.toString(sorted));
    }

    // Complexity : O(n^2)
    private int[] sort(int[] array) {
        int[] arr = array.clone();

        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    arr[i] = arr[i] ^ arr[i + 1];
                    arr[i + 1] = arr[i] ^ arr[i + 1];
                    arr[i] = arr[i] ^ arr[i + 1];
                    sorted = false;
                }
            }
        }

        return arr;
    }
}
