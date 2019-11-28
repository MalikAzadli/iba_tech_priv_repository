package november.classNov12.bit;

public class Operations {
    public static void main(String[] args) {
        int and = 43 & 56;
        int or = 43 | 56;
        int xor = 43 ^ 56;
        int inversion = ~43;
        int rightShift = 11>>1;
        int leftShift = 11<<1;

        System.out.println(and);
        System.out.println(or);
        System.out.println(xor);
        System.out.println(inversion);
        System.out.println(rightShift);
        System.out.println(leftShift);
    }
}
