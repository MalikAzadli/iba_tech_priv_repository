
import java.util.ArrayList;
import java.util.Random;

public class Testing {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[20];
        for(int i = 0; i < arr.length; i++){
            arr[i] = rand.nextInt(21) -10;
        }

        {
        System.out.print("Array: ");
        printArray(arr);

        System.out.print("Reversed: ");
        reverse(arr);
        printArray(arr);

        System.out.print("Negatives: ");
        getNegatives(arr);

        System.out.print("Odd Positives: ");
        getOddPositives(arr);

        System.out.print("Even Positives: ");
        getEvenPositives(arr);}
    }

    private static void getOddPositives(int[] arr) {
        ArrayList<Integer> arr_1 = new ArrayList<>();
        for(int i : arr){
            if(i >= 0 && i%2==1) arr_1.add(i);
        }
        System.out.println(arr_1);
    }

    private static void getEvenPositives(int[] arr){
        ArrayList<Integer> arr_1 = new ArrayList<>();
        for(int i : arr){
            if(i >= 0 && i%2==0) arr_1.add(i);
        }
        System.out.println(arr_1);
    }

    private static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if(i != arr.length-1) System.out.print(", ");
        }
        System.out.println();
    }

    private static void reverse(int[] arr){
        for(int i = 0; i < arr.length/2; i++){
            arr[i]= arr[i] ^ arr[arr.length-i-1];
            arr[arr.length-i-1] = arr[i] ^ arr[arr.length-i-1];
            arr[i] = arr[i] ^ arr[arr.length-i-1];
        }
    }

    private static void getNegatives(int[] arr){
        ArrayList<Integer> arr_1 = new ArrayList<>();
        for(int i: arr){
            if(i < 0) arr_1.add(i);
        }
        System.out.println(arr_1);
    }

}
