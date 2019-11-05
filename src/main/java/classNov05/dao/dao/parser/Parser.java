package classNov05.dao.dao.parser;

public interface Parser<T> {
    T parse(String string);
    String toString(T t);
}
