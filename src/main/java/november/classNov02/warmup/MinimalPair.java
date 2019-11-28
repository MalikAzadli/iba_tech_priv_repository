package november.classNov02.warmup;

import java.util.ArrayList;
import java.util.List;

public class MinimalPair {

    private List<Integer> arr;
    private List<Integer[]> pairs;

    public MinimalPair(List<Integer> arr){
        this.arr = arr;
        convertToPairs();
    }

    public Integer[] getPair(int index){
        return pairs.get(index);
    }

    private void convertToPairs(){
        List<Integer[]> pairs = new ArrayList<>();
        for(int i = 0; i < arr.size(); i+=2){
            if(i==arr.size()-1) break;
            pairs.add(new Integer[]{arr.get(i), arr.get(i+1)});
        }
        this.pairs = pairs;
    }

    public int indexOfMinimalPair(){
        int index = 0;
        Integer min = Integer.MAX_VALUE;



        for(int i = 0; i < pairs.size(); i++){
            if (Math.min(min, pairs.get(i)[0] + pairs.get(i)[1]) != min) {
                min = pairs.get(i)[0] + pairs.get(i)[1];
                index = i;
            }
        }

        return index;
    }
}
