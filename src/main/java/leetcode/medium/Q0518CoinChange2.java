package leetcode.medium;

// https://leetcode.com/problems/coin-change-2/
public class Q0518CoinChange2 {
  public int change1(int amount, int[] coins) {
    int[][] dp = new int[coins.length + 1][amount + 1];
    dp[0][0] = 1;

    for (int i = 1; i <= coins.length; i++) {
      dp[i][0] = 1;
      for (int j = 1; j <= amount; j++)
        dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
    }
    return dp[coins.length][amount];
  }

  public int change2(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    // if outer loop is amount then various coin combinations are counted several times.
    for (int coin : coins) for (int i = coin; i <= amount; i++) dp[i] += dp[i - coin];
    return dp[amount];
  }
}
