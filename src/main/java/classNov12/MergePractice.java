package classNov12;

import java.util.Arrays;

public class MergePractice {
    public static void main(String[] args) {
        int[] arr = {2, 5, 9, 10};
        int[] arr1 = {1, 4, 7, 11, 13};
        int[] joined = join(arr, arr1);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(joined));
    }

    public static int[] join(int[] a, int[] b) {
        int[] joined = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) joined[k++] = a[i++];
            else joined[k++] = b[j++];
        }
        while (i < a.length) joined[k++] = a[i++];

        while (j < b.length) joined[k++] = b[j++];

        return joined;
    }
}
