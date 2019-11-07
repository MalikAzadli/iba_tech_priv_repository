package classNov07.warmup;

public class Solution {
    public int solution(String s) {
        int count = 0;
        int interval = 0;
        for(int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){
                case 'R' : count++; break;
                case 'L' : count--; break;
            }
            if(count == 0) interval++;
        }
        return interval;
    }

}
