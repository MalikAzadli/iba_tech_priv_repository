package november.classNov07.warmup;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void solution1() {
        Solution solution = new Solution();
        assertEquals(4, solution.solution("RLRRLLRLRRLL"));
    }

    @Test
    public void solution2() {
        Solution solution = new Solution();
        assertEquals(1, solution.solution("LLRLRLRLRLRLRR"));
    }


    @Test
    public void solution3() {
        Solution solution = new Solution();
        assertEquals(4, solution.solution("RLLLRRRLLR"));
    }




}