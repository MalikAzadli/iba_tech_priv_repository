package classOct29.exception;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExceptionTaskTest {

    @Test
    public void addIntegers1() {
        ExceptionTask exceptionTask = new ExceptionTask();
        String randomString = "ewfwe";
        assertEquals(0, exceptionTask.addIntegers(randomString));

    }

    @Test
    public void addIntegers2() {
        ExceptionTask exceptionTask = new ExceptionTask();
        String randomString = "1 3 -3 sdfs 12 ";
        assertEquals(13, exceptionTask.addIntegers(randomString));
    }

    @Test
    public void addIntegers3() {
        ExceptionTask exceptionTask = new ExceptionTask();
        String randomString = "dagsdfgs ";
        assertEquals(0, exceptionTask.addIntegers(randomString));

    }

    @Test
    public void addIntegers4() {
        ExceptionTask exceptionTask = new ExceptionTask();
        String randomString = null;
        assertEquals(0, exceptionTask.addIntegers(randomString));
    }

    @Test
    public void addIntegers5() {
        ExceptionTask exceptionTask = new ExceptionTask();
        String randomString = " ";
        assertEquals(0, exceptionTask.addIntegers(randomString));
    }
}