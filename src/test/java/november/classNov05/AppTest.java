package november.classNov05;

import november.classNov05.warmup.App;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {

    private App app;

    @Before
    public void before(){
        this.app = new App();
    }

    @Test
    public void calc1() {
        assertEquals(1, app.calc("()()()()()"));
    }

    @Test
    public void calc2() {
        assertEquals(2, app.calc("(()()()()())"));
    }

    @Test
    public void calc3() {
        assertEquals(3, app.calc("()(()(())()(()))"));
    }
}