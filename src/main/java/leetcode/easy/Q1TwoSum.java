package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
public class Q1TwoSum {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      Integer index = map.get(target - nums[i]);
      if (index != null) return new int[] {index, i};
      map.put(nums[i], i);
    }
    return new int[] {-1, -1};
  }
}
