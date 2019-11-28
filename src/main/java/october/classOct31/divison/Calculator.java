package october.classOct31.divison;

public class Calculator {

    private Fraction total;
    private Fraction operand;

    public Calculator() {
        total = new Fraction("0/0");
    }

    public String process(String string) {
        String[] operands = string.split("\\+");

        for (String comp : operands) {
            if (comp.contains("/")) {
                this.operand = new Fraction(comp);
                add();
            }
            else if(total.nom() != 0 || total.denom() != 0) {
                int num = Integer.parseInt(comp);
                total.setDenom(total.nom() + num * total.denom());
            } else {
                int num = Integer.parseInt(comp);
                total.setNom(num);
                total.setDenom(1);
            }
        }
        gcd();
        return total.toString();
    }

    public void add() {
        int nom = operand.nom();
        int denom = operand.denom();
        if(total.nom() != 0 || total.denom() != 0) {
            total.setNom((nom * total.denom()) + (total.nom() * denom));
            total.setDenom(denom * total.denom());
        } else {
            total.setNom(nom);
            total.setDenom(denom);
        }

    }

    public void gcd(){
        int num1 = total.nom();
        int num2 = total.denom();

        while(num1 != num2)
        {
            if(num1 > num2)
                num1 -= num2;
            else
                num2 -= num1;
        }

        total.setNom(total.nom()/num1);
        total.setDenom(total.denom() / num1);
    }


}
