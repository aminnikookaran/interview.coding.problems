package leetcode.medium;

// https://leetcode.com/problems/unique-paths-ii/
public class Q0063UniquePathsII {
  public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    if (obstacleGrid[0][0] == 1) return 0;
    obstacleGrid[0][0] = 1;
    for (int i = 1; i < m; i++)
      obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
    for (int j = 1; j < n; j++)
      obstacleGrid[0][j] = (obstacleGrid[0][j] == 0 && obstacleGrid[0][j - 1] == 1) ? 1 : 0;
    for (int i = 1; i < m; i++)
      for (int j = 1; j < n; j++)
        if (obstacleGrid[i][j] == 0)
          obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
        else obstacleGrid[i][j] = 0;
    return obstacleGrid[m - 1][n - 1];
  }

  public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
    int width = obstacleGrid[0].length;
    int[] dp = new int[width];
    dp[0] = 1;
    for (int[] row : obstacleGrid) {
      for (int j = 0; j < width; j++) {
        if (row[j] == 1) dp[j] = 0;
        else if (j > 0) dp[j] += dp[j - 1];
      }
    }
    return dp[width - 1];
  }
}
