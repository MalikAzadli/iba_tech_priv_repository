package classNov12.bit;

public class Conversion {
    public static void main(String[] args) {
        int decimal = 43;
        String binary = convert2Binary(decimal);

        String binary2 = "111111";
        int decimal2 = convert2Decimal(binary2);
        System.out.println(decimal);
        System.out.println(binary);

        System.out.println(binary2);
        System.out.println(decimal2);
    }

    private static String convert2Binary(int decimal) {
        String binary = "";

        while (decimal > 0){
            binary = decimal%2 + binary;
            decimal/=2;
        }
    //think about using only bit operations
        return binary;
    }



    private static int convert2Decimal(String binary){
        int decimal = 0;

        int power = 0;
        int index = binary.length()-1;
        while (index!=-1){
            int bit = Integer.parseInt(binary.substring(index));
            decimal += bit * Math.pow(2,power);
            power++;
            binary = binary.substring(0, index);
            index = binary.length()-1;
        }

        return decimal;
    }
}
