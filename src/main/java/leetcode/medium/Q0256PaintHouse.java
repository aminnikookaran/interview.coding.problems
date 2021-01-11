package leetcode.medium;

// https://leetcode.com/problems/paint-house/
public class Q0256PaintHouse {
  public int minCost1(int[][] costs) {
    if (costs == null || costs.length == 0) return 0;
    for (int i = 1; i < costs.length; i++) {
      costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
      costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
      costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
    }
    int m = costs.length - 1;
    return Math.min(Math.min(costs[m][0], costs[m][1]), costs[m][2]);
  }

  public int minCost2(int[][] costs) {
    if (costs == null || costs.length == 0) return 0;
    int[][] matrix = new int[3][costs.length];
    for (int j = 0; j < costs.length; j++) {
      if (j == 0) {
        matrix[0][j] = costs[j][0];
        matrix[1][j] = costs[j][1];
        matrix[2][j] = costs[j][2];
      } else {
        matrix[0][j] = Math.min(matrix[1][j - 1], matrix[2][j - 1]) + costs[j][0];
        matrix[1][j] = Math.min(matrix[0][j - 1], matrix[2][j - 1]) + costs[j][1];
        matrix[2][j] = Math.min(matrix[0][j - 1], matrix[1][j - 1]) + costs[j][2];
      }
    }
    return Math.min(
        Math.min(matrix[0][costs.length - 1], matrix[1][costs.length - 1]),
        matrix[2][costs.length - 1]);
  }
}
