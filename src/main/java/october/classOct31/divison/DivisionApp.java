package october.classOct31.divison;

public class DivisionApp {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String result = calculator.process("2/4+2/4+2/4"); // 11/12
        System.out.println(result);
    }
}
