package leetcode.medium;

// https://leetcode.com/problems/bomb-enemy/
public class Q0361BombEnemy {
  public int maxKilledEnemies1(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    int max = 0;
    int[][] maxs = new int[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      int sum = 0;
      int start = 0;
      for (int j = 0; j <= grid[0].length; j++) {
        if (j < grid[0].length && grid[i][j] == 'E') {
          sum++;
        } else if (j == grid[0].length || grid[i][j] == 'W') {
          for (int k = start; k < j; k++) {
            if (grid[i][k] == 'E') continue;
            maxs[i][k] += sum;
            max = Math.max(max, maxs[i][k]);
          }
          sum = 0;
          start = j + 1;
        }
      }
    }
    for (int j = 0; j < grid[0].length; j++) {
      int sum = 0;
      int start = 0;
      for (int i = 0; i <= grid.length; i++) {
        if (i < grid.length && grid[i][j] == 'E') {
          sum++;
        } else if (i == grid.length || grid[i][j] == 'W') {
          for (int k = start; k < i; k++) {
            if (grid[k][j] == 'E') continue;
            maxs[k][j] += sum;
            max = Math.max(max, maxs[k][j]);
          }
          sum = 0;
          start = i + 1;
        }
      }
    }
    return max;
  }

  public int maxKilledEnemies2(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    int m = grid.length;
    int n = grid[0].length;
    int result = 0, rows = 0;
    int[] cols = new int[n];

    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (j == 0 || grid[i][j - 1] == 'W') {
          rows = 0;
          for (int k = j; k < n && grid[i][k] != 'W'; ++k) if (grid[i][k] == 'E') rows += 1;
        }
        if (i == 0 || grid[i - 1][j] == 'W') {
          cols[j] = 0;
          for (int k = i; k < m && grid[k][j] != 'W'; ++k) if (grid[k][j] == 'E') cols[j] += 1;
        }
        if (grid[i][j] == '0' && rows + cols[j] > result) result = rows + cols[j];
      }
    }
    return result;
  }
}
