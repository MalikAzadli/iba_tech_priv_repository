package _practice.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        int[] array = new Random().ints(30, 0, 30).toArray();
        int[] sorted = sort.sort(array);

        System.out.println("origin: " + Arrays.toString(array));
        System.out.println("sorted: " + Arrays.toString(sorted));
    }

    // Complexity : O(n^2)
    private int[] sort(int[] array) {
        int[] arr = array.clone();
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minId = i;
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[j] < min){
                    min = arr[j];
                    minId = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[minId] = temp;
        }

        return arr;
    }
}
