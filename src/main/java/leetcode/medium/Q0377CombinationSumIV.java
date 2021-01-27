package leetcode.medium;

import java.util.Arrays;

// https://leetcode.com/problems/combination-sum-iv/
public class Q0377CombinationSumIV {
  public int combinationSum41(int[] nums, int target) {
    if (target == 0) return 1;
    int res = 0;
    for (int i = 0; i < nums.length; i++)
      if (target >= nums[i]) res += combinationSum41(nums, target - nums[i]);
    return res;
  }

  public int combinationSum42(int[] nums, int target) {
    int[] dp = new int[target + 1];
    Arrays.fill(dp, -1);
    dp[0] = 1;
    return combinationSum42(nums, target, dp);
  }

  private int combinationSum42(int[] nums, int target, int[] dp) {
    if (dp[target] != -1) return dp[target];
    int res = 0;
    for (int i = 0; i < nums.length; i++)
      if (target >= nums[i]) res += combinationSum42(nums, target - nums[i], dp);
    dp[target] = res;
    return res;
  }

  public int combinationSum43(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 1; i < dp.length; i++)
      for (int j = 0; j < nums.length; j++) if (i - nums[j] >= 0) dp[i] += dp[i - nums[j]];
    return dp[target];
  }
}
