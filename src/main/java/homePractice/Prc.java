package homePractice;

import java.util.Optional;
import java.util.stream.Stream;

public interface Prc<T> {
    default T method(T t){
        return t;
    };
}
