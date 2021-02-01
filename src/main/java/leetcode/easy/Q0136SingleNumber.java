package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/single-number/
public class Q0136SingleNumber {
  public int singleNumber1(int[] nums) {
    int x = 0;
    for (Integer integer : nums) x ^= integer;
    return x;
  }

  public int singleNumber2(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
    for (int i : nums) if (map.get(i) == 1) return i;
    return 0;
  }

  public int singleNumber3(int[] nums) {
    int sumOfSet = 0, sumOfNums = 0;
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (!set.contains(num)) {
        set.add(num);
        sumOfSet += num;
      }
      sumOfNums += num;
    }
    return 2 * sumOfSet - sumOfNums;
  }
}
