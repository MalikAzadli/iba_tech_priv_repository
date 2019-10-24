package mix;

public class Result {
    private final String origin;
    private final String capitalVowels;
    private final String capitalConsonants;
    private final String lowerVowels;
    private final String lowerConsonants;

    public Result(String origin, String capitalConsonants, String capitalVowels, String lowerConsonants, String lowerVowels){
        this.origin = origin;
        this.capitalConsonants = capitalConsonants;
        this.capitalVowels = capitalVowels;
        this.lowerConsonants = lowerConsonants;
        this.lowerVowels = lowerVowels;
    }

    public String getOrigin() {
        return origin;
    }

    public String getCapitalVowels() {
        return capitalVowels;
    }

    public String getCapitalConsonants() {
        return capitalConsonants;
    }

    public String getLowerVowels() {
        return lowerVowels;
    }

    public String getLowerConsonants() {
        return lowerConsonants;
    }



}
