package october.classOct31.divison;

public class Fraction {
    private int nominator;
    private int denominator;

    public Fraction(String string) {
        String[] components = string.split("/");
        nominator = Integer.parseInt(components[0]);
        denominator = Integer.parseInt(components[1]);
    }

    public int nom() {
        return nominator;
    }

    public int denom() {
        return denominator;
    }

    public void setNom(int nominator) {
        this.nominator = nominator;
    }

    public void setDenom(int denominator) {
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return nominator + "/" + denominator;
    }
}
