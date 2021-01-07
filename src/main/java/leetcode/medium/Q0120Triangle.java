package leetcode.medium;

import java.util.List;

// https://leetcode.com/problems/triangle/
public class Q0120Triangle {
  // Recursive
  public int minimumTotal1(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) return 0;
    return dfs1(0, 0, triangle);
  }

  int dfs1(int row, int pos, List<List<Integer>> triangle) {
    if (row + 1 >= triangle.size()) return triangle.get(row).get(pos);
    return triangle.get(row).get(pos)
        + Math.min(dfs1(row + 1, pos, triangle), dfs1(row + 1, pos + 1, triangle));
  }

  // Top down
  public int minimumTotal2(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) return 0;
    Integer[][] cache = new Integer[triangle.size()][triangle.size()];
    return dfs2(0, 0, triangle, cache);
  }

  int dfs2(int row, int pos, List<List<Integer>> triangle, Integer[][] cache) {
    if (row + 1 >= triangle.size()) return triangle.get(row).get(pos);
    if (cache[row][pos] != null) return cache[row][pos];
    cache[row][pos] =
        triangle.get(row).get(pos)
            + Math.min(
                dfs2(row + 1, pos, triangle, cache), dfs2(row + 1, pos + 1, triangle, cache));
    return cache[row][pos];
  }

  // Bottom up
  public int minimumTotal3(List<List<Integer>> triangle) {
    int[][] dp = new int[triangle.size()][triangle.size()];
    // Remember base case is just returning leaf nodes
    for (int i = 0; i < triangle.size(); i++)
      dp[triangle.size() - 1][i] = triangle.get(triangle.size() - 1).get(i);

    for (int row = triangle.size() - 2; row >= 0; row--) {
      for (int pos = 0; pos < triangle.get(row).size(); pos++) {
        dp[row][pos] =
            triangle.get(row).get(pos) + Math.min(dp[row + 1][pos + 1], dp[row + 1][pos]);
      }
    }

    return dp[0][0];
  }

  // Bottom up O(n) space complexity.
  public int minimumTotal4(List<List<Integer>> triangle) {

    int[] dp = new int[triangle.size()];
    int[] dp1 = new int[triangle.size()];
    // Remember base case is just returning leaf nodes
    for (int i = 0; i < triangle.size(); i++) {
      dp[i] = triangle.get(triangle.size() - 1).get(i);
    }

    for (int row = triangle.size() - 2; row >= 0; row--) {
      for (int pos = 0; pos < triangle.get(row).size(); pos++) {
        dp1[pos] = triangle.get(row).get(pos) + Math.min(dp[pos + 1], dp[pos]);
      }
      dp = dp1;
    }

    return dp[0];
  }

  public int minimumTotal5(List<List<Integer>> triangle) {
    int[] dp = new int[triangle.size() + 1];
    for (int i = triangle.size() - 1; i >= 0; i--)
      for (int j = 0; j <= i; j++) dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
    return dp[0];
  }

  public int minimumTotal6(List<List<Integer>> triangle) {
    int m = triangle.size();
    if (m == 0) return 0;
    int n = triangle.get(m - 1).size();
    if (n == 0) return 0;
    int[] dp = new int[m];
    
    dp[0] = triangle.get(0).get(0);
    for (int i = 1; i < m; i++) {
      int l = triangle.get(i).size();
      for (int k = l - 1; k >= 0; k--) {
        int curr =
            Math.min(
                    (k < l - 1 ? dp[k] : Integer.MAX_VALUE),
                    (k >= 1 ? dp[k - 1] : Integer.MAX_VALUE))
                + triangle.get(i).get(k);
        dp[k] = curr;
      }
    }
    int min = Integer.MAX_VALUE;
    for (int k = 0; k < n; k++) {
      min = Math.min(min, dp[k]);
    }
    return min;
  }
}
