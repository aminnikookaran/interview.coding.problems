package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/number-of-islands/
public class Q200NumberOfIslands {
  public int numIslands1(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    int islands = 0;
    Deque<Pair> deque = new ArrayDeque<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          islands++;
          deque.add(new Pair(i, j));
          while (!deque.isEmpty()) {
            Pair pair = deque.poll();
            if (pair.i > 0
                && pair.i < grid.length - 1
                && pair.j > 0
                && pair.j < grid[0].length - 1
                && grid[pair.i][pair.j] == '1') {
              grid[pair.i][pair.j] = '2';
              deque.add(new Pair(pair.i - 1, pair.j));
              deque.add(new Pair(pair.i + 1, pair.j));
              deque.add(new Pair(pair.i, pair.j - 1));
              deque.add(new Pair(pair.i, pair.j + 1));
            }
          }
        }
      }
    }
    return islands;
  }

  class Pair {
    int i;
    int j;

    public Pair(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }

  public int numIslands2(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    int m = grid.length;
    int n = grid[0].length;
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          count++;
          merge(grid, i, j);
        }
      }
    }
    return count;
  }

  public void merge(char[][] grid, int i, int j) {
    int m = grid.length;
    int n = grid[0].length;
    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') return;
    grid[i][j] = 'X';
    merge(grid, i - 1, j);
    merge(grid, i + 1, j);
    merge(grid, i, j - 1);
    merge(grid, i, j + 1);
  }

  public int numIslands3(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    int m = grid.length;
    int n = grid[0].length;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[] root = new int[m * n];
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          root[i * n + j] = i * n + j;
          count++;
        }
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
              int cRoot = getRoot(root, i * n + j);
              int nRoot = getRoot(root, x * n + y);
              if (nRoot != cRoot) {
                root[cRoot] = nRoot; // update previous node's root to be current
                count--;
              }
            }
          }
        }
      }
    }
    return count;
  }

  public int getRoot(int[] arr, int i) {
    while (arr[i] != i) i = arr[arr[i]];
    return i;
  }

  public static void main(String[] args) {
    Q200NumberOfIslands s = new Q200NumberOfIslands();
    System.out.println(
        s.numIslands1(
            new char[][] {
              {'1', '1', '0', '0', '0'},
              {'1', '1', '0', '0', '0'},
              {'0', '0', '1', '0', '0'},
              {'0', '0', '0', '1', '1'}
            }));
  }
}
