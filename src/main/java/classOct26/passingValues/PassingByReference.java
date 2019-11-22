package classOct26.passingValues;

public class PassingByReference {
    public static void main(String[] args) {
        IntContainer ic = new IntContainer(5);
        IntContainer kc = new IntContainer(7);
        System.out.println("Before:");
        System.out.printf("i=%d\n", ic.value);
        System.out.printf("k=%d\n", kc.value);
        swap(ic,kc);
        System.out.println("After:");
        System.out.printf("i=%d\n", ic.value);
        System.out.printf("k=%d\n", kc.value);
    }

    public static void swap(final IntContainer a, final IntContainer b){
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }
}
