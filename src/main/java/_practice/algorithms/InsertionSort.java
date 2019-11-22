package _practice.algorithms;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        int[] array = new Random().ints(30, 0, 30).toArray();
        int[] sorted = sort.sort(array);

        System.out.println("origin: " + Arrays.toString(array));
        System.out.println("sorted: " + Arrays.toString(sorted));
    }

    // Complexity : O(n^2)
    private int[] sort(int[] array) {
        int[] arr = array.clone();
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }

        return arr;
    }
}
