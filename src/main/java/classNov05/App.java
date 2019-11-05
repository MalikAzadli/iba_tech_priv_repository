package classNov05;

public class App {

    public int calc(String origin){

        int count = 0;
        int max = 0;
        for(int i = 0; i < origin.length(); i++){
            count = origin.charAt(i)=='(' ? (count+1) : (count-1);
            max = Math.max(count,max);
        }
        return max;
    }
}
