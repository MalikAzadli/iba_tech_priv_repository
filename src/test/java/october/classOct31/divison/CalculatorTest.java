package october.classOct31.divison;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void before(){
        calculator = new Calculator();
    }

    @Test
    public void process1() {
        String res = calculator.process("3/2+1/4");
        assertEquals("7/4", res);
    }

    @Test
    public void process2() {
        String res = calculator.process("3+1/4");
        assertEquals("13/4", res);
    }
}