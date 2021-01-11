package leetcode.medium;

import java.util.Arrays;

// https://leetcode.com/problems/3sum-smaller/
public class Q02593SumSmaller {
  public int threeSumSmaller(int[] nums, int target) {
    if (nums == null || nums.length < 3) return 0;
    int result = 0;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k)
        if (nums[i] + nums[j] + nums[k] < target) {
          result += (k - j);
          j++;
        } else k--;
    }
    return result;
  }
}
