package _practice.algorithms;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] array = new Random().ints(30, 0, 30).toArray();
        int[] sorted = array.clone();
        sort.sort(sorted, 0, sorted.length - 1);

        System.out.println("origin: " + Arrays.toString(array));
        System.out.println("sorted: " + Arrays.toString(sorted));
    }

//    Complexity: O(nlogn)
    private void sort(int[] array, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        sort(array, left, mid);
        sort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        int[] leftArray = new int[lengthLeft];
        int[] rightArray = new int[lengthRight];

        for (int i = 0; i < lengthLeft; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < lengthRight; i++) {
            rightArray[i] = array[mid + 1 + i];
        }

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = left; i < right + 1; i++) {
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if(leftArray[leftIndex] < rightArray[rightIndex]){
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }

            else if(leftIndex < lengthLeft){
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }

            else if(rightIndex < lengthRight){
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }

    }
}
