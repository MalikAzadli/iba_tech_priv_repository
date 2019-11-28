package november.classNov21.warmup;

import java.util.Arrays;
import java.util.Random;

public class SwapperDiff {
    public static void main(String[] args) {
        Random random = new Random();
        SwapperDiff swapper = new SwapperDiff();
//        int[] arr = random.ints(30, -10, 10).toArray();
        int[] arr = {7,-6,1,2,-3,3,4,5,-1,6,7,-2,8,9,-3,8};
        int[] swapped = swapper.swapNegatives(arr);
        System.out.println("origin : " + Arrays.toString(arr));
        System.out.println("swapped: " + Arrays.toString(swapped));

    }

    public int[] swapNegatives(int[] origin) {
        int[] arr = origin.clone();
        int holder = 0;
        int initPos = 0;
        boolean isFirst = true;
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            if (current < 0 && isFirst) {
                initPos = i;
                holder = current;
                isFirst = false;
                continue;
            }
            if (current < 0) {
                holder = arr[i] ^ holder;
                arr[i] = arr[i] ^ holder;
                holder = arr[i] ^ holder;
            }
            if (i == arr.length - 1) arr[initPos] = holder;

        }

        return arr;
    }

    private int[] swapAll(int[] origin) {
        int[] arr = origin.clone();


        return arr;
    }

}
