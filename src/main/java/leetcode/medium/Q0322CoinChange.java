package leetcode.medium;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change/
public class Q0322CoinChange {
  public int coinChange1(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    for (int i = 1; i <= amount; i++) {
      dp[i] = amount + 1;
      for (int j = 0; j < coins.length; j++)
        if (coins[j] <= i) dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }

  public int coinChange2(int[] coins, int amount) {
    if (amount < 1) return 0;
    return coinChange2(coins, amount, new int[amount]);
  }

  private int coinChange2(int[] coins, int rem, int[] count) {
    if (rem < 0) return -1;
    if (rem == 0) return 0;
    if (count[rem - 1] != 0) return count[rem - 1];
    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
      int res = coinChange2(coins, rem - coin, count);
      if (res >= 0 && res < min) min = 1 + res;
    }
    count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
    return count[rem - 1];
  }

  public int coinChange3(int[] coins, int amount) {
    if (amount < 1) return 0;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int coin : coins)
      for (int i = coin; i <= amount; i++)
        if (dp[i - coin] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }
}
