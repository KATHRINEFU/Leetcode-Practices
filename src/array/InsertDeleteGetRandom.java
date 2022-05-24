package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @ClassName InsertDeleteGetRandom
 * @Description Implement the RandomizedSet class:
 * @Author katefu
 * @Date 5/24/22 4:27 PM
 * @Version 1.0
 **/
public class InsertDeleteGetRandom {
}

class RandomizedSet {

    List<Integer> list;
    HashMap<Integer, Integer> valToIndex;
    Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        valToIndex = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(valToIndex.containsKey(val)){
            return false;
        }
        list.add(val);
        valToIndex.put(val, list.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if(!valToIndex.containsKey(val)){
            return false;
        }
        int index = valToIndex.get(val);
        int last = list.get(list.size()-1);
        list.set(index, last);
        list.remove(list.size()-1);
        valToIndex.put(last, index);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        int target = random.nextInt(list.size());
        return list.get(target);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */