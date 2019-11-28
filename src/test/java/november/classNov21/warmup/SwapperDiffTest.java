package november.classNov21.warmup;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwapperDiffTest {

    private SwapperDiff swapperDiff;

    @Before
    public void before(){
        swapperDiff = new SwapperDiff();
    }

    @Test
    public void shiftNegatives(){
        int[] arr = {7,-6,1,2,-3,3,4,5,-1,6,7,-2,8,9,-3,8};
        int[] swapped = {7,-3,1,2,-6,3,4,5,-3,6,7,-1,8,9,-2,8};

        assertEquals(swapped, swapperDiff.swapNegatives(arr));
    }

}