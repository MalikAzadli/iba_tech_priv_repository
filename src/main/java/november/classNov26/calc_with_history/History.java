package november.classNov26.calc_with_history;

import java.util.ArrayList;
import java.util.List;

public class History<T> {
    private List<T> hist = new ArrayList<>();

    public void add(T t){
        hist.add(t);
    }

    public List<T> getHist(){
        return hist;
    }
}
