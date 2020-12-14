package cracking.moderate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairsWithSum {
  class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  List<Pair> printPairSums1(int[] array, int sum) {
    List<Pair> result = new ArrayList<Pair>();
    Map<Integer, Integer> unpairedCount = new HashMap<Integer, Integer>();
    for (int x : array) {
      int complement = sum - x;
      if (unpairedCount.getOrDefault(complement, 0) > 0) {
        result.add(new Pair(x, complement));
        adjustCounterBy(unpairedCount, complement, -1); // decrement complement
      } else adjustCounterBy(unpairedCount, x, 1); // increment count
    }
    return result;
  }

  void adjustCounterBy(Map<Integer, Integer> counter, int key, int delta) {
    counter.put(key, counter.getOrDefault(key, 0) + delta);
  }

  void printPairSums2(int[] array, int sum) {
    Arrays.sort(array);
    int first = 0;
    int last = array.length - 1;
    while (first < last) {
      int s = array[first] + array[last];
      if (s == sum) {
        System.out.println(array[first] + " " + array[last]);
        first++;
        last--;
      } else {
        if (s < sum) first++;
        else last--;
      }
    }
  }
}
