package _practice.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        int[] array = new Random().ints(30, 0, 30).toArray();
        int[] sorted = array.clone();
        sort.sort(sorted);

        System.out.println("origin: " + Arrays.toString(array));
        System.out.println("sorted: " + Arrays.toString(sorted));
    }

//    Complexity: O(nlogn)
    private void sort(int[] array) {
        if (array.length == 0) return;

        int length = array.length;

        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }


    private void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < length && array[left] > array[largest]) {
            largest = left;
        }

        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        //swap
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, length, largest);
        }
    }
}
