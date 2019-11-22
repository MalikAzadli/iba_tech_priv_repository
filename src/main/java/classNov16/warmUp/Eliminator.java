package classNov16.warmUp;

public class Eliminator {

    public static void main(String[] args) {
        Eliminator eliminator = new Eliminator();
        String line = "Baku";
        System.out.println(eliminator.eliminateVowel(line));

    }

    public String eliminateVowel(String string) {
        String holder = "";
        for (int i = 0; i < string.length(); i++) {
            String ch = String.format("%s",string.charAt(i));
            if (!isVowel(ch)) holder += ch;
        }
        return holder;
    }

    private boolean isVowel(String ch) {
        return ch.equalsIgnoreCase("A")
                || ch.equalsIgnoreCase("E")
                || ch.equalsIgnoreCase("I")
                || ch.equalsIgnoreCase("O")
                || ch.equalsIgnoreCase("U");
    }

}
