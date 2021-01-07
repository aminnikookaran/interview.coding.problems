package leetcode.medium;

// https://leetcode.com/problems/perfect-squares/
public class Q0279PerfectSquares {
  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      dp[i] = i;
      for (int j = 1; j <= Math.sqrt(i); j++) dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
    }
    return dp[n];
  }
}
