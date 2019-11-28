package october.classOct26.passingValues;

public class PassingByValues {
    public static void main(String[] args) {
        int  i =5;
        int k = 7;
        System.out.println("Before:");
        System.out.printf("i=%d\n", i);
        System.out.printf("k=%d\n", k);
        swap(i,k);
        System.out.println("After:");
        System.out.printf("i=%d\n", i);
        System.out.printf("k=%d\n", k);
    }
    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }
}





