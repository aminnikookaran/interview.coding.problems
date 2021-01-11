package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/walls-and-gates/
public class Q0286WallsAndGates {
  public void wallsAndGates1(int[][] rooms) {
    if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
    for (int i = 0; i < rooms.length; i++)
      for (int j = 0; j < rooms[0].length; j++) if (rooms[i][j] == 0) fill(rooms, i, j, 0);
  }

  public void fill(int[][] rooms, int i, int j, int distance) {
    if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < distance)
      return;
    rooms[i][j] = distance;
    fill(rooms, i - 1, j, distance + 1);
    fill(rooms, i, j + 1, distance + 1);
    fill(rooms, i + 1, j, distance + 1);
    fill(rooms, i, j - 1, distance + 1);
  }

  public void wallsAndGates2(int[][] rooms) {
    if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
    int m = rooms.length;
    int n = rooms[0].length;
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++) if (rooms[i][j] == 0) deque.add(i * n + j);

    while (!deque.isEmpty()) {
      int head = deque.poll();
      int x = head / n;
      int y = head % n;
      if (x > 0 && rooms[x - 1][y] == Integer.MAX_VALUE) {
        rooms[x - 1][y] = rooms[x][y] + 1;
        deque.add((x - 1) * n + y);
      }
      if (x < m - 1 && rooms[x + 1][y] == Integer.MAX_VALUE) {
        rooms[x + 1][y] = rooms[x][y] + 1;
        deque.add((x + 1) * n + y);
      }
      if (y > 0 && rooms[x][y - 1] == Integer.MAX_VALUE) {
        rooms[x][y - 1] = rooms[x][y] + 1;
        deque.add(x * n + y - 1);
      }
      if (y < n - 1 && rooms[x][y + 1] == Integer.MAX_VALUE) {
        rooms[x][y + 1] = rooms[x][y] + 1;
        deque.add(x * n + y + 1);
      }
    }
  }
}
