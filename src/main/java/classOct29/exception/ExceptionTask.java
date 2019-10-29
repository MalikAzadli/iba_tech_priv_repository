package classOct29.exception;

import java.util.Arrays;
import java.util.Scanner;

public class ExceptionTask {

    //return int[] -> JS approach
    //return new object -> Java approach
    public Holder addIntegers(String string) {
        if (string == null) return new Holder(0, 0);
        String[] arr = string.split(" ");
        int sum = 0;
        int counter = 0;
        for (String str : arr) {
            try {
                sum += Integer.parseInt(str);
            } catch (NumberFormatException ex) {
                counter++;
            }
        }
        return new Holder(sum, counter);
    }

    public static void main(String[] args) {
        ExceptionTask exceptionTask = new ExceptionTask();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Holder sum = exceptionTask.addIntegers(line);
        System.out.printf("%d, %d", sum.getSum(), sum.getCount());
    }
}
