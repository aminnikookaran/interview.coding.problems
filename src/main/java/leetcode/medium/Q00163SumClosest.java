package leetcode.medium;

import java.util.Arrays;

// https://leetcode.com/problems/3sum-closest/
public class Q00163SumClosest {
  public int threeSumClosest1(int[] nums, int target) {
    int diff = Integer.MAX_VALUE, sz = nums.length;
    Arrays.sort(nums);
    for (int i = 0; i < sz && diff != 0; ++i) {
      int lo = i + 1, hi = sz - 1;
      while (lo < hi) {
        int sum = nums[i] + nums[lo] + nums[hi];
        if (Math.abs(target - sum) < Math.abs(diff)) diff = target - sum;
        if (sum < target) ++lo;
        else --hi;
      }
    }
    return target - diff;
  }

  public int threeSumClosest2(int[] nums, int target) {
    int diff = Integer.MAX_VALUE, sz = nums.length;
    Arrays.sort(nums);
    for (int i = 0; i < sz && diff != 0; ++i) {
      for (int j = i + 1; j < sz - 1; ++j) {
        int complement = target - nums[i] - nums[j];
        var idx = Arrays.binarySearch(nums, j + 1, sz - 1, complement);
        int hi = idx >= 0 ? idx : ~idx, lo = hi - 1;
        if (hi < sz && Math.abs(complement - nums[hi]) < Math.abs(diff))
          diff = complement - nums[hi];
        if (lo > j && Math.abs(complement - nums[lo]) < Math.abs(diff))
          diff = complement - nums[lo];
      }
    }
    return target - diff;
  }
}
