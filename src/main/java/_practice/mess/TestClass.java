package _practice.mess;

public class TestClass {
    private static int count = 0;

    public TestClass() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}
