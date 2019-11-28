package november.classNov19.warmup;

public class Checker {

    public boolean isPrime(int origin) {
        for(int i =2; i <= Math.sqrt(origin); i++){
            if(origin % i == 0) return false;
        }
        return true;
    }

    public boolean isPalindrome(int origin) {

        while (origin < 0) {

        }
        return false;
    }
}
