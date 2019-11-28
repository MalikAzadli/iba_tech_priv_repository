package november.classNov19.binary;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = IntStream.rangeClosed(0, 100).limit(1000).toArray();

        BinarySearch binarySearch = new BinarySearch();

        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch.contains(98, arr));
    }

    public boolean contains(int number, int[] data) {
        int l = 0;
        int r = data.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (number == data[m]) return true;
            if (number > data[m]) l = m + 1;
            else r = m - 1;
        }
        return false;
    }
}
