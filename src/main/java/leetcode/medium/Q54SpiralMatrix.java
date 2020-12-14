package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/
public class Q54SpiralMatrix {
  public List<Integer> spiralOrder1(int[][] matrix) {
    int on = matrix.length - 1;
    int n = on;
    int om = matrix[0].length - 1;
    int m = om;
    List<Integer> result = new ArrayList<>();
    while (true) {
      if (!(om - m <= om)) break;
      for (int j = om - m; j <= om; j++) result.add(matrix[on - n][j]);
      if (!(on - n + 1 <= on)) break;
      for (int i = on - n + 1; i <= on; i++) result.add(matrix[i][om]);
      if (!(om - 1 >= om - m)) break;
      for (int j = om - 1; j >= om - m; j--) result.add(matrix[on][j]);
      if (!(on - 1 > on - n)) break;
      for (int i = on - 1; i > on - n; i--) result.add(matrix[i][om - m]);
      on--;
      om--;
      n -= 2;
      m -= 2;
    }
    return result;
  }

  public List<Integer> spiralOrder2(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();
    if (matrix.length == 0) return ans;
    int R = matrix.length, C = matrix[0].length;
    boolean[][] seen = new boolean[R][C];
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};
    int r = 0, c = 0, di = 0;
    for (int i = 0; i < R * C; i++) {
      ans.add(matrix[r][c]);
      seen[r][c] = true;
      int cr = r + dr[di];
      int cc = c + dc[di];
      if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]) {
        r = cr;
        c = cc;
      } else {
        di = (di + 1) % 4;
        r += dr[di];
        c += dc[di];
      }
    }
    return ans;
  }

  public List<Integer> spiralOrder3(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();
    if (matrix.length == 0) return ans;
    int r1 = 0, r2 = matrix.length - 1;
    int c1 = 0, c2 = matrix[0].length - 1;
    while (r1 <= r2 && c1 <= c2) {
      for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
      for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
      if (r1 < r2 && c1 < c2) {
        for (int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);
        for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]);
      }
      r1++;
      r2--;
      c1++;
      c2--;
    }
    return ans;
  }
}
