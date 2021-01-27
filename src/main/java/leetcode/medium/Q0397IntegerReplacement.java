package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/integer-replacement/
public class Q0397IntegerReplacement {
  public int integerReplacement1(int n) {
    int c = 0;
    while (n != 1) {
      if ((n & 1) == 0) n >>>= 1;
      else if (n == 3 || ((n >>> 1) & 1) == 0) --n;
      else ++n;
      ++c;
    }
    return c;
  }

  public int integerReplacement2(int n) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(1, 0);
    map.put(2, 1);
    return integerReplacement2(n, map);
  }

  private int integerReplacement2(int n, Map<Integer, Integer> map) {
    if (map.containsKey(n)) return map.get(n);
    int steps = -1;
    if (n % 2 == 0) steps = integerReplacement2(n / 2, map) + 1;
    else
      steps =
          Math.min(
              integerReplacement2((n - 1), map) + 1, integerReplacement2(1 + (n - 1) / 2, map) + 2);
    map.put(n, steps);
    return steps;
  }
}
