package _practice.mess;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        // 0 => from right
        // 1 => from left
//        test.regular_scan(arr);
        test.directed_scan(arr, 0);
    }

    private void directed_scan(int[][] arr, int dir) {
        System.out.println("Directed Scan:");
        int step = dir * 2 - 1;
        for (int r = 0, c = (dir + 1) % 2 * (arr[r].length - 1); r < arr.length; ) {
            System.out.printf("r: %d, c: %d val:[%d]\n", r, c, arr[r][c]);

            c += step;
            int length = arr[r].length;
            r = (c % length) + r;
            c = c % length;
            step = (c / 2) * 9;
        }
    }

    private void regular_scan(int[][] arr) {
        System.out.println("Regular Scan:");
        for (int r = 0, c = 0; r < arr.length; ) {
            System.out.printf("r: %d, c: %d val:[%d]\n", r, c, arr[r][c]);
            int length = arr[r].length;
            c++;
            r = (c / length) + r;
            c = c % length;
        }
    }
}
