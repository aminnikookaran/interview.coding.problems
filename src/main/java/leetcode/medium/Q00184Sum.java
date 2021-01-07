package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/4sum/
public class Q00184Sum {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return kSum(nums, target, 0, 4);
  }

  public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
    List<List<Integer>> res = new ArrayList<>();
    if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
      return res;
    if (k == 2) return twoSum1(nums, target, start);
    for (int i = start; i < nums.length; ++i)
      if (i == start || nums[i - 1] != nums[i])
        for (var set : kSum(nums, target - nums[i], i + 1, k - 1)) {
          res.add(new ArrayList<>(Arrays.asList(nums[i])));
          res.get(res.size() - 1).addAll(set);
        }
    return res;
  }

  public List<List<Integer>> twoSum1(int[] nums, int target, int start) {
    List<List<Integer>> res = new ArrayList<>();
    int lo = start, hi = nums.length - 1;
    while (lo < hi) {
      int sum = nums[lo] + nums[hi];
      if (sum < target || (lo > start && nums[lo] == nums[lo - 1])) ++lo;
      else if (sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) --hi;
      else res.add(Arrays.asList(nums[lo++], nums[hi--]));
    }
    return res;
  }

  public List<List<Integer>> twoSum2(int[] nums, int target, int start) {
    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> s = new HashSet<>();
    for (int i = start; i < nums.length; ++i) {
      if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i])
        if (s.contains(target - nums[i])) res.add(Arrays.asList(target - nums[i], nums[i]));
      s.add(nums[i]);
    }
    return res;
  }
}
