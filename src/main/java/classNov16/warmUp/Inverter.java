package classNov16.warmUp;

public class Inverter {

    public static void main(String[] args) {
        Inverter inverter = new Inverter();
        String line = "My BEAUtiFul LaunDreTTe";
        System.out.println(line);
        System.out.println(inverter.invert(line));
    }

    private String invert(String line) {
        String holder = "";

        for(int i = 0; i < line.length(); i++){
            char ch = line.charAt(i);
            holder+= (char) (ch^32);
        }

        return holder;
    }
}
