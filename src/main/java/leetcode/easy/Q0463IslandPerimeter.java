package leetcode.easy;

// https://leetcode.com/problems/island-perimeter/
public class Q0463IslandPerimeter {
  public static int islandPerimeter1(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    int result = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          result += 4;
          if (i > 0 && grid[i - 1][j] == 1) result -= 2;
          if (j > 0 && grid[i][j - 1] == 1) result -= 2;
        }
      }
    }
    return result;
  }

  public int islandPerimeter2(int[][] grid) {
    if (grid == null) return 0;
    for (int i = 0; i < grid.length; i++)
      for (int j = 0; j < grid[0].length; j++) if (grid[i][j] == 1) return getPerimeter(grid, i, j);
    return 0;
  }

  public int getPerimeter(int[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 1;
    if (grid[i][j] == 0) return 1;
    if (grid[i][j] == -1) return 0;
    int count = 0;
    grid[i][j] = -1;
    count += getPerimeter(grid, i - 1, j);
    count += getPerimeter(grid, i, j - 1);
    count += getPerimeter(grid, i, j + 1);
    count += getPerimeter(grid, i + 1, j);
    return count;
  }
}
