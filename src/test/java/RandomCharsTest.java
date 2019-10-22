import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;


public class RandomCharsTest {

    private RandomChars randomChars = new RandomChars();

    @Before
    public void before999() {
        this.randomChars = new RandomChars();
    }

    @After
    public void after888() {
        this.randomChars = new RandomChars();
    }

    @org.junit.Test
    public void genRandom1() {
        String s1 = randomChars.genRandom(10);
        assertEquals(10, s1.length());
    }

    @org.junit.Test
    public void genRandom2() {
        String s1 = randomChars.genRandom(10);
        for(int i= 0; i < s1.length(); i++){
            assertTrue(isCharValid(s1.charAt(i)));
        }
    }

    @org.junit.Test
    public void genRandom3() {
        String s1 = randomChars.genRandom(10);
        for(int i= 0; i < s1.length(); i++){
            assertFalse(isCharInvalid(s1.charAt(i)));
        }
    }

    public boolean isCharValid(char c){
        return (c <= 'Z' && c >= 'A') || (c <= 'z' && c >= 'a');
    }

    public boolean isCharInvalid(char c){
        return  (c < 'A') || (c > 'Z' && c< 'a') || (c > 'z');
    }
}