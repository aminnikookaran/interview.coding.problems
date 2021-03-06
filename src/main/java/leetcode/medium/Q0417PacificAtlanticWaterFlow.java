package leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/pacific-atlantic-water-flow/
public class Q0417PacificAtlanticWaterFlow {
  int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public List<int[]> pacificAtlantic1(int[][] matrix) {
    List<int[]> res = new LinkedList<>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
    int n = matrix.length, m = matrix[0].length;
    // One visited map for each ocean
    boolean[][] pacific = new boolean[n][m];
    boolean[][] atlantic = new boolean[n][m];
    Queue<int[]> pQueue = new LinkedList<>();
    Queue<int[]> aQueue = new LinkedList<>();
    for (int i = 0; i < n; i++) { // Vertical border
      pQueue.offer(new int[] {i, 0});
      aQueue.offer(new int[] {i, m - 1});
      pacific[i][0] = true;
      atlantic[i][m - 1] = true;
    }
    for (int i = 0; i < m; i++) { // Horizontal border
      pQueue.offer(new int[] {0, i});
      aQueue.offer(new int[] {n - 1, i});
      pacific[0][i] = true;
      atlantic[n - 1][i] = true;
    }
    bfs(matrix, pQueue, pacific);
    bfs(matrix, aQueue, atlantic);
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++) if (pacific[i][j] && atlantic[i][j]) res.add(new int[] {i, j});
    return res;
  }

  public void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
    int n = matrix.length, m = matrix[0].length;
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      for (int[] d : dir) {
        int x = cur[0] + d[0];
        int y = cur[1] + d[1];
        if (x < 0
            || x >= n
            || y < 0
            || y >= m
            || visited[x][y]
            || matrix[x][y] < matrix[cur[0]][cur[1]]) {
          continue;
        }
        visited[x][y] = true;
        queue.offer(new int[] {x, y});
      }
    }
  }

  public List<int[]> pacificAtlantic2(int[][] matrix) {
    List<int[]> res = new LinkedList<>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
    int n = matrix.length, m = matrix[0].length;
    boolean[][] pacific = new boolean[n][m];
    boolean[][] atlantic = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
      dfs(matrix, atlantic, Integer.MIN_VALUE, i, m - 1);
    }
    for (int i = 0; i < m; i++) {
      dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
      dfs(matrix, atlantic, Integer.MIN_VALUE, n - 1, i);
    }
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++) if (pacific[i][j] && atlantic[i][j]) res.add(new int[] {i, j});
    return res;
  }

  public void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
    int n = matrix.length, m = matrix[0].length;
    if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < height) return;
    visited[x][y] = true;
    for (int[] d : dir) dfs(matrix, visited, matrix[x][y], x + d[0], y + d[1]);
  }
}
