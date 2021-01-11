package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/majority-element-ii/
public class Q0229MajorityElementII {
  public List<Integer> majorityElement1(int[] nums) {
    List<Integer> result = new ArrayList<>();
    if (nums == null || nums.length == 0) return result;
    int count1 = 0, count2 = 0, number1 = 0, number2 = 0;
    for (int n : nums) {
      if (number1 == n) count1++;
      else if (number2 == n) count2++;
      else if (count1 == 0) {
        number1 = n;
        count1 = 1;
      } else if (count2 == 0) {
        number2 = n;
        count2 = 1;
      } else {
        count1--;
        count2--;
      }
    }
    count1 = 0;
    count2 = 0;
    // count the number for the 2 elements
    for (int n : nums) {
      if (n == number1) count1++;
      else if (n == number2) count2++;
    }
    // if those appear more than n/3
    if (count1 > nums.length / 3) result.add(number1);
    if (count2 > nums.length / 3) result.add(number2);
    return result;
  }

  public List<Integer> majorityElement2(int[] nums) {
    int k = 3;
    int targetFreq = nums.length / k;
    Map<Integer, Integer> kCounters = new HashMap<>();
    Map<Integer, Integer> freq = new HashMap<>();
    // 1st pass to build kCounters and freq
    for (int num : nums) {
      // update freq
      freq.put(num, freq.getOrDefault(num, 0) + 1);
      // update kCounters
      if (kCounters.containsKey(num) || kCounters.size() < k) {
        kCounters.put(num, kCounters.getOrDefault(num, 0) + 1);
      } else {
        // decrease all other keys, erase them if count falls to zero
        // has to use a separate set to avoid ConcurrentModificationException
        Set<Integer> keySet = new HashSet<>(kCounters.keySet());
        for (int candidate : keySet) {
          kCounters.put(candidate, kCounters.get(candidate) - 1);
          if (kCounters.get(candidate) == 0) kCounters.remove(candidate);
        }
      }
    }
    // 2nd pass to get valid candidates
    List<Integer> majorities = new ArrayList<>();
    for (int candidate : kCounters.keySet()) {
      if (freq.get(candidate) > targetFreq) majorities.add(candidate);
    }
    return majorities;
  }
}
