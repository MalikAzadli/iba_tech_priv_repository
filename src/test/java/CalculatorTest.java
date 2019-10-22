import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();
    private Random random = new Random();

    @Test
    public void add() {
        int a = random.nextInt();
        int b = random.nextInt();
        int expectedAnswer = a + b;
        int answer = calculator.add(a, b);
        assertEquals(expectedAnswer, answer);
    }

    @Test
    public void sub() {
        int a = random.nextInt();
        int b = random.nextInt();
        int expectedAnswer = a - b;
        int answer = calculator.sub(a, b);
        assertEquals(expectedAnswer, answer);
    }

    @Test
    public void mul() {
        int a = random.nextInt();
        int b = random.nextInt();
        int expectedAnswer = a * b;
        int answer = calculator.mul(a, b);
        assertEquals(expectedAnswer, answer);
    }

    @Test
    public void div() {
        int a = random.nextInt();
        int b = random.nextInt();
        int expectedAnswer = a / b;
        int answer = calculator.div(a, b);
        assertEquals(expectedAnswer, answer);
    }
}