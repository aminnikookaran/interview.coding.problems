package leetcode.medium;

import java.util.Arrays;

// https://leetcode.com/problems/longest-increasing-subsequence/
public class Q0300LongestIncreasingSubsequence {
  public int lengthOfLIS1(int[] nums) {
    int memo[][] = new int[nums.length + 1][nums.length];
    for (int[] l : memo) Arrays.fill(l, -1);
    return lengthofLIS1(nums, -1, 0, memo);
  }

  public int lengthofLIS1(int[] nums, int previndex, int curpos, int[][] memo) {
    if (curpos == nums.length) return 0;
    if (memo[previndex + 1][curpos] >= 0) return memo[previndex + 1][curpos];
    int taken = 0;
    if (previndex < 0 || nums[curpos] > nums[previndex])
      taken = 1 + lengthofLIS1(nums, curpos, curpos + 1, memo);
    int nottaken = lengthofLIS1(nums, previndex, curpos + 1, memo);
    memo[previndex + 1][curpos] = Math.max(taken, nottaken);
    return memo[previndex + 1][curpos];
  }

  public int lengthOfLIS2(int[] nums) {
    if (nums.length == 0) return 0;
    int[] dp = new int[nums.length];
    dp[0] = 1;
    int maxans = 1;
    for (int i = 1; i < dp.length; i++) {
      int maxval = 0;
      for (int j = 0; j < i; j++) if (nums[i] > nums[j]) maxval = Math.max(maxval, dp[j]);
      dp[i] = maxval + 1;
      maxans = Math.max(maxans, dp[i]);
    }
    return maxans;
  }

  public int lengthOfLIS3(int[] nums) {
    int[] dp = new int[nums.length];
    int len = 0;
    for (int num : nums) {
      int i = Arrays.binarySearch(dp, 0, len, num);
      if (i < 0) i = -(i + 1);
      dp[i] = num;
      if (i == len) len++;
    }
    return len;
  }
}
