package _practice.mess;

import java.util.Optional;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.isValidEmail("azadli#malik@gmail.com"));
    }

    public boolean isValidEmail(String origin) {
        Predicate<String> containsSign = n -> n.contains("@");
        Predicate<String> prefixLength = n -> n.substring(n.indexOf("@")).length() >= 4;

        Predicate<String> isValidPrefix = n -> n.substring(0, n.indexOf("@")).chars()
                .mapToObj(e -> (char) e)
                .anyMatch(ch -> {
                    if (Character.isDigit(ch)) {
                        Character.isLetter(ch);
                    }
                    return true;
                });

        Predicate<String> isValidDomain = n -> n.substring(n.indexOf("@")).chars()
                .mapToObj(e -> (char) e)
                .anyMatch(ch -> {
                    if (Character.isDigit(ch)) {
                        Character.isLetter(ch);
                    }
                    return true;
                });

        Predicate<String> isFullStop = n -> n.substring(n.indexOf("@")).contains(".");

        Predicate<String> domainLength = n -> n.substring(n.lastIndexOf(".")).length() >= 2;

        boolean test = containsSign.and(prefixLength).and(isValidPrefix).and(isValidDomain).and(isFullStop).and(domainLength).test(origin);
        return test;


//        for (int i = 0; i < domain.length(); i++) {
//            char ch = domain.charAt(i);
//            if (Character.isLetter(ch)) continue;
//            else if (Character.isDigit(ch)) continue;
//            else if (ch == '-' || ch == '.') continue;
//            else {
//                console.printLn("Invalid email address.");
//                return false;
//            }
//        }
    }

}
