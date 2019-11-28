package november.classNov19.warmup;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckerTest {

    private Checker checker;

    @Before
    public void before(){
        checker = new Checker();
    }

    @Test
    public void isPrime() {
        assertTrue(checker.isPrime(17));
    }

    @Test
    public void isPalindrome() {
        assertTrue(checker.isPalindrome(147898741));
    }
}