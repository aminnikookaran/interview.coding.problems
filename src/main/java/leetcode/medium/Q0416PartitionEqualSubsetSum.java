package leetcode.medium;

// https://leetcode.com/problems/partition-equal-subset-sum/
public class Q0416PartitionEqualSubsetSum {
  public boolean canPartition1(int[] nums) {
    int sum = 0;
    for (int num : nums) sum += num;
    if ((sum & 1) == 1) return false;
    sum /= 2;

    int n = nums.length;
    boolean[][] dp = new boolean[n + 1][sum + 1];
    dp[0][0] = true;

    for (int i = 1; i < n + 1; i++) {
      dp[i][0] = true;
      for (int j = 1; j < sum + 1; j++) {
        dp[i][j] = dp[i - 1][j];
        if (j >= nums[i - 1]) dp[i][j] = (dp[i][j] || dp[i - 1][j - nums[i - 1]]);
      }
    }

    return dp[n][sum];
  }

  public boolean canPartition2(int[] nums) {
    int sum = 0;
    for (int num : nums) sum += num;
    if ((sum & 1) == 1) return false;
    sum /= 2;

    boolean[] dp = new boolean[sum + 1];
    dp[0] = true;

    for (int num : nums) for (int i = sum; i >= num; i--) dp[i] = dp[i] || dp[i - num];

    return dp[sum];
  }

  public boolean canPartition3(int[] nums) {
    int sum = 0;
    for (int num : nums) sum += num;
    if (sum % 2 != 0) return false;

    int target = sum / 2;
    Boolean[][] memo = new Boolean[nums.length][target + 1];
    return helper(nums, 0, target, memo);
  }

  private boolean helper(int[] nums, int pos, int target, Boolean[][] memo) {
    if (target == 0) return true;
    if (pos == nums.length || target < 0) return false;
    if (memo[pos][target] != null) return memo[pos][target];

    memo[pos][target] =
        helper(nums, pos + 1, target, memo) || helper(nums, pos + 1, target - nums[pos], memo);
    return memo[pos][target];
  }
}
