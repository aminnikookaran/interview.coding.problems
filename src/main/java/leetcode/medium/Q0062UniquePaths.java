package leetcode.medium;

// https://leetcode.com/problems/unique-paths/
public class Q0062UniquePaths {
  public int uniquePaths1(int m, int n) {
    int[][] table = new int[m][n];
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        if (i == 0 && j == 0) table[i][j] = 1;
        else if (i == 0) table[i][j] = table[i][j - 1];
        else if (j == 0) table[i][j] = table[i - 1][j];
        else table[i][j] = table[i - 1][j] + table[i][j - 1];
    return table[m - 1][n - 1];
  }

  public int uniquePaths2(int m, int n) {
    int[][] mem = new int[m][n];
    for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) mem[i][j] = -1;
    return uniquePaths2(mem, m - 1, n - 1);
  }

  private int uniquePaths2(int[][] mem, int m, int n) {
    if (mem[m][n] == -1)
      if (m == 0 || n == 0) mem[m][n] = 1;
      else mem[m][n] = uniquePaths2(mem, m, n - 1) + uniquePaths2(mem, m - 1, n);
    return mem[m][n];
  }

  public int uniquePaths3(int m, int n) {
    int[] dp = new int[n];
    dp[0] = 1;
    for (int i = 1; i < m; i++) for (int j = 0; j < n; j++) if (j > 0) dp[j] += dp[j - 1];
    return dp[n - 1];
  }
}
