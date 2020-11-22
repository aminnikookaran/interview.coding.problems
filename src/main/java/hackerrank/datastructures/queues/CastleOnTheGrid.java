package hackerrank.datastructures.queues;

import java.util.ArrayDeque;
import java.util.Deque;

// https://www.hackerrank.com/challenges/castle-on-the-grid/problem
public class CastleOnTheGrid {
  public static int minimumMoves1(String[] grid, int startX, int startY, int goalX, int goalY) {
    if (startX == goalX && startY == goalY) return 0;

    int n = grid.length;
    Deque<Integer> xQue = new ArrayDeque<>();
    Deque<Integer> yQue = new ArrayDeque<>();
    xQue.add(startX);
    yQue.add(startY);

    int distances[][] = new int[n][n];
    distances[startX][startY] = 1;

    int finalDistance = 0;
    while (xQue.size() > 0 && finalDistance == 0) {
      int currX = xQue.poll();
      int currY = yQue.poll();
      int currD = distances[currX][currY];

      for (int i = currY + 1; i < n; i++) {
        if (grid[currX].charAt(i) == 'X') break;
        if (distances[currX][i] == 0) {
          distances[currX][i] = currD + 1;
          if (goalX == currX && goalY == i) {
            finalDistance = distances[currX][i];
            break;
          }
          xQue.add(currX);
          yQue.add(i);
        }
      }
      if (finalDistance > 0) break;

      for (int i = currY - 1; i >= 0; i--) {
        if (grid[currX].charAt(i) == 'X') break;
        if (distances[currX][i] == 0) {
          distances[currX][i] = currD + 1;
          if (goalX == currX && goalY == i) {
            finalDistance = distances[currX][i];
            break;
          }
          xQue.add(currX);
          yQue.add(i);
        }
      }
      if (finalDistance > 0) break;

      for (int i = currX + 1; i < n; i++) {
        if (grid[i].charAt(currY) == 'X') break;
        if (distances[i][currY] == 0) {
          distances[i][currY] = currD + 1;
          if (goalX == i && goalY == currY) {
            finalDistance = distances[i][currY];
            break;
          }
          xQue.add(i);
          yQue.add(currY);
        }
      }
      if (finalDistance > 0) break;

      for (int i = currX - 1; i >= 0; i--) {
        if (grid[i].charAt(currY) == 'X') break;
        if (distances[i][currY] == 0) {
          distances[i][currY] = currD + 1;
          if (goalX == i && goalY == currY) {
            finalDistance = distances[i][currY];
            break;
          }
          xQue.add(i);
          yQue.add(currY);
        }
      }
    }

    return finalDistance - 1;
  }

  public static int minimumMoves2(String[] grid, int startX, int startY, int goalX, int goalY) {
    if (startX == goalX && startY == goalY) return 0;

    int n = grid.length;
    Deque<Integer> xQue = new ArrayDeque<>();
    Deque<Integer> yQue = new ArrayDeque<>();
    xQue.add(startX);
    yQue.add(startY);
    xQue.add(goalX);
    yQue.add(goalY);

    int distances[][] = new int[n][n];
    distances[startX][startY] = 1;
    distances[goalX][goalY] = -1;

    int finalDistance = 0;
    while (xQue.size() > 0 && finalDistance == 0) {
      int currX = xQue.poll();
      int currY = yQue.poll();
      int currD = distances[currX][currY];
      int add = currD < 0 ? -1 : 1;

      for (int i = currY + 1; i < n; i++) {
        if (grid[currX].charAt(i) == 'X') break;
        if (distances[currX][i] == 0) {
          distances[currX][i] = currD + add;
          xQue.add(currX);
          yQue.add(i);
        } else if (currD * distances[currX][i] < 0) {
          finalDistance = Math.abs(currD) + Math.abs(distances[currX][i]);
          break;
        }
      }
      if (finalDistance > 0) break;

      for (int i = currY - 1; i >= 0; i--) {
        if (grid[currX].charAt(i) == 'X') break;
        if (distances[currX][i] == 0) {
          distances[currX][i] = currD + add;
          xQue.add(currX);
          yQue.add(i);
        } else if (currD * distances[currX][i] < 0) {
          finalDistance = Math.abs(currD) + Math.abs(distances[currX][i]);
          break;
        }
      }
      if (finalDistance > 0) break;

      for (int i = currX + 1; i < n; i++) {
        if (grid[i].charAt(currY) == 'X') break;
        if (distances[i][currY] == 0) {
          distances[i][currY] = currD + add;
          xQue.add(i);
          yQue.add(currY);
        } else if (currD * distances[i][currY] < 0) {
          finalDistance = Math.abs(currD) + Math.abs(distances[i][currY]);
          break;
        }
      }
      if (finalDistance > 0) break;

      for (int i = currX - 1; i >= 0; i--) {
        if (grid[i].charAt(currY) == 'X') break;
        if (distances[i][currY] == 0) {
          distances[i][currY] = currD + add;
          xQue.add(i);
          yQue.add(currY);
        } else if (currD * distances[i][currY] < 0) {
          finalDistance = Math.abs(currD) + Math.abs(distances[i][currY]);
          break;
        }
      }
    }

    return finalDistance - 1;
  }

  public static void main(String[] args) {
    System.out.println(minimumMoves2(new String[] {".X.", ".X.", "..."}, 0, 0, 0, 2));

    //    Deque<Integer> stack = new ArrayDeque<Integer>();
    //    stack.push(1);
    //    stack.pop();
    //    stack.peek();
    //
    //    Deque<Integer> queue = new ArrayDeque<Integer>();
    //    queue.add(1);
    //    queue.poll();
    //    queue.peek();
  }
}
