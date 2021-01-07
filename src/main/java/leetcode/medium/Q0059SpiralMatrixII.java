package leetcode.medium;

// https://leetcode.com/problems/spiral-matrix-ii/
public class Q0059SpiralMatrixII {
  public int[][] generateMatrix1(int n) {
    int[][] result = new int[n][n];
    int cnt = 1;
    for (int layer = 0; layer < (n + 1) / 2; layer++) {
      for (int ptr = layer; ptr < n - layer; ptr++) result[layer][ptr] = cnt++;
      for (int ptr = layer + 1; ptr < n - layer; ptr++) result[ptr][n - layer - 1] = cnt++;
      for (int ptr = layer + 1; ptr < n - layer; ptr++) result[n - layer - 1][n - ptr - 1] = cnt++;
      for (int ptr = layer + 1; ptr < n - layer - 1; ptr++) result[n - ptr - 1][layer] = cnt++;
    }
    return result;
  }

  public int[][] generateMatrix2(int n) {
    int[][] result = new int[n][n];
    int cnt = 1;
    int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int d = 0;
    int row = 0;
    int col = 0;
    while (cnt <= n * n) {
      result[row][col] = cnt++;
      int r = Math.floorMod(row + dir[d][0], n);
      int c = Math.floorMod(col + dir[d][1], n);
      if (result[r][c] != 0) d = (d + 1) % 4;
      row += dir[d][0];
      col += dir[d][1];
    }
    return result;
  }
}
