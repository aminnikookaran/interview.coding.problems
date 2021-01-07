package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// https://leetcode.com/problems/insert-delete-getrandom-o1/
public class Q0380InsertDeleteGetRandomO1 {
  class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
      map = new HashMap<>();
      list = new ArrayList<>();
      random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified
     * element.
     */
    public boolean insert(int val) {
      Integer index = map.get(val);
      if (index == null) {
        map.put(val, list.size());
        list.add(val);
        return true;
      }
      return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
      Integer index = map.get(val);
      if (index != null) {
        list.set(index, list.get(list.size() - 1));
        map.put(list.get(index), index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
      }
      return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
      return list.get(random.nextInt(list.size()));
    }
  }
}
