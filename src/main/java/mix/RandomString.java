package mix;

public class RandomString {
    public static void main(String[] args) {
        RandomChars randomChars = new RandomChars();
        String s1 = randomChars.genRandom(20);
        RandomString randomString = new RandomString();
        Result result = randomString.process(s1);
        randomString.print(result);
    }

    private void print(Result r) {
        System.out.printf("Original String: %s\nCapital Vowels: %s\nCapital Consonants: %s\nLower Vowels: %s\nLower Consonants: %s"
                , r.getOrigin(), r.getCapitalVowels(), r.getCapitalConsonants(), r.getLowerVowels(), r.getLowerConsonants());
    }

    public Result process(String s){
        StringBuilder uc = new StringBuilder();
        StringBuilder lc = new StringBuilder();
        StringBuilder uv = new StringBuilder();
        StringBuilder lv = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(isUpperConsonant(c)) uc.append(c);
            if(isLowerConsonant(c)) lc.append(c);
            if(isUpperVowel(c)) uv.append(c);
            if(isLowerVowel(c)) lv.append(c);
        }

        return new Result(s, uc.toString(), uv.toString(), lc.toString(), lv.toString());
    }

    public boolean isUpperVowel(char c){
        return isUpper(c) && isVowel(c);
    }

    public boolean isUpperConsonant(char c){
        return isUpper(c) && isConsonant(c);
    }

    public boolean isLowerVowel(char c){
        return isLower(c) && isVowel(c);
    }

    public boolean isLowerConsonant(char c){
        return isLower(c) && isConsonant(c);
    }

    public boolean isUpper(char c){
        return c > 'A' && c < 'Z';
    }

    public boolean isLower(char c){
        return c > 'a' && c < 'z';
    }

    public boolean isVowel(char c){
        char upper = Character.toUpperCase(c);
        return upper == 'A' || upper == 'E' || upper == 'I' || upper == 'O' || upper == 'U';
    }

    public boolean isConsonant(char c){
        return !isVowel(c);
    }
}
