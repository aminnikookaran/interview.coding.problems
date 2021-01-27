package leetcode.medium;

// https://leetcode.com/problems/guess-number-higher-or-lower-ii/
public class Q0375GuessNumberHigherOrLowerII {
  public int getMoneyAmount1(int n) {
    int[][] dp = new int[n + 1][n + 1];
    return getMoneyAmount1(dp, 1, n);
  }

  int getMoneyAmount1(int[][] dp, int i, int j) {
    if (i >= j) return 0;
    if (dp[i][j] != 0) return dp[i][j];
    int result = Integer.MAX_VALUE;
    for (int x = i; x <= j; x++)
      result =
          Math.min(
              result, x + Math.max(getMoneyAmount1(dp, i, x - 1), getMoneyAmount1(dp, x + 1, j)));
    dp[i][j] = result;
    return result;
  }

  public int getMoneyAmount2(int n) {
    int[][] dp = new int[n + 1][n + 1];
    for (int j = 2; j <= n; j++) {
      for (int i = j - 1; i > 0; i--) {
        int globalMin = Integer.MAX_VALUE;
        for (int x = i + 1; x < j; x++) {
          int localMax = x + Math.max(dp[i][x - 1], dp[x + 1][j]);
          globalMin = Math.min(globalMin, localMax);
        }
        dp[i][j] = i + 1 == j ? i : globalMin;
      }
    }
    return dp[1][n];
  }

  public int getMoneyAmount3(int n) {
    int[][] dp = new int[n + 1][n + 1];
    for (int l = 2; l <= n; l++) {
      for (int i = 1; i <= n - (l - 1); i++) {
        int j = i + l - 1;
        dp[i][j] = Integer.MAX_VALUE;
        for (int x = i; x <= j; x++)
          if (x == n) dp[i][j] = Math.min(dp[i][j], x + dp[i][x - 1]);
          else dp[i][j] = Math.min(dp[i][j], x + Math.max(dp[i][x - 1], dp[x + 1][j]));
      }
    }
    return dp[1][n];
  }
}
