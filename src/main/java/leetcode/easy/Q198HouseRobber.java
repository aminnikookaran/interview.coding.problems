package leetcode.easy;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber/
public class Q198HouseRobber {
  public int rob1(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int[] sums = new int[nums.length];
    for (int i = 0; i < sums.length; i++) sums[i] = -1;
    return rob(nums, sums, 0);
  }

  public int rob(int[] nums, int[] sums, int low) {
    if (sums[low] == -1) {
      if (low == nums.length - 1) sums[low] = nums[low];
      else if (low == nums.length - 2) sums[low] = Math.max(nums[low], nums[low + 1]);
      else sums[low] = Math.max(nums[low] + rob(nums, sums, low + 2), rob(nums, sums, low + 1));
    }
    return sums[low];
  }

  public int rob2(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    return dp[nums.length - 1];
  }

  public int rob3(int[] num) {
    if (num == null || num.length == 0) return 0;
    int even = 0;
    int odd = 0;
    for (int i = 0; i < num.length; i++) {
      if (i % 2 == 0) {
        even += num[i];
        even = even > odd ? even : odd;
      } else {
        odd += num[i];
        odd = even > odd ? even : odd;
      }
    }
    return even > odd ? even : odd;
  }

  public int rob4(int[] nums) {
    if (nums.length == 0) return 0;
    int[] mem = new int[nums.length + 1];
    Arrays.fill(mem, -1);
    mem[0] = 0;
    return helper(nums.length, mem, nums);
  }

  private int helper(int size, int[] mem, int[] nums) {
    if (size < 1) return 0;
    if (mem[size] != -1) return mem[size];
    int firstSelected = helper(size - 2, mem, nums) + nums[nums.length - size];
    int firstUnselected = helper(size - 1, mem, nums);
    return mem[size] = Math.max(firstSelected, firstUnselected);
  }
}
