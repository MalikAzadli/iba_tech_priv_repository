package november.classNov05.warmup;

public class App {

    public int calc(String origin) {

        int count = 0;
        int max = 0;
        for (int i = 0; i < origin.length(); i++) {
            char ch = origin.charAt(i);
            switch (ch){
                case '(': count++; break;
                case ')': count--; break;
                default: throw new IllegalArgumentException("Wrong char");
            }
            if(count < 0) throw new IllegalArgumentException("Extra  ')");
            max = Math.max(count, max);
        }
        if(count > 0) throw new IllegalArgumentException("Extra '(");

        return max;
    }
}
