package mix;

public class Envelope {
    public static void main(String[] args) {
        int width = 20;
        int height = 10;
        int indexLeft = 0;
        int indexRight = width;
        double tan  = (double) width / height;
        for(int i = 0; i < height; i--){

            for(int z = 0; z < width; z++){
                if(i == height || i== 1) {
                    System.out.print("*");
                    continue;
                }
                if(z==0 || z == (width-1)){System.out.print("*");}
                if(z == Math.round(i*tan)) {
                    System.out.print("*");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
