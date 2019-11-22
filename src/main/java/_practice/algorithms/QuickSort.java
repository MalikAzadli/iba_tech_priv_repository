package _practice.algorithms;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] array = new Random().ints(30, 0, 30).toArray();
        int[] sorted = array.clone();
        sort.sort(sorted, 0, sorted.length - 1);

        System.out.println("origin: " + Arrays.toString(array));
        System.out.println("sorted: " + Arrays.toString(sorted));
    }

    //Complexity: O(n^2)
    private void sort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        sort(array, begin, pivot - 1);
        sort(array, pivot + 1, end);
    }

    private int partition(int[] array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }

        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }
}
