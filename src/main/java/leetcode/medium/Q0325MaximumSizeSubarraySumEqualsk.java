package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
public class Q0325MaximumSizeSubarraySumEqualsk {
  public int maxSubArrayLen1(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int sum = 0, max = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
      if (!map.containsKey(sum)) map.put(sum, i);
    }
    return max;
  }

  public int maxSubArrayLen2(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0, max = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sum == k) max = i + 1;
      else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
      if (!map.containsKey(sum)) map.put(sum, i);
    }
    return max;
  }
}
