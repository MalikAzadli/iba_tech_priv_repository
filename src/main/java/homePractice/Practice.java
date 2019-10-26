package homePractice;

public class Practice {

    public static <T> T getAway(T element){
        return element;
    }

    public static void main(String[] args) {
        System.out.println(getAway("Jane"));
    }
}
