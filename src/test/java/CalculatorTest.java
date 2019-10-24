import mix.Calculator;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;
    private Random random = new Random();
    private int a, b;

    @Before
    public void before999(){
        calculator = new Calculator();
        a = random.nextInt();
        b = random.nextInt();
    }

    @Test
    public void add() {
        int expectedAnswer = a + b;
        int answer = calculator.add(a, b);
        assertEquals(expectedAnswer, answer);
    }

    @Test
    public void sub() {
        int expectedAnswer = a - b;
        int answer = calculator.sub(a, b);
        assertEquals(expectedAnswer, answer);
    }

    @Test
    public void mul() {
        int expectedAnswer = a * b;
        int answer = calculator.mul(a, b);
        assertEquals(expectedAnswer, answer);
    }

    @Test
    public void div() {
        int expectedAnswer = a / b;
        int answer = calculator.div(a, b);
        assertEquals(expectedAnswer, answer);
    }
}