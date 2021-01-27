package leetcode.medium;

// https://leetcode.com/problems/android-unlock-patterns/
public class Q0351AndroidUnlockPatterns {
  public int numberOfPatterns(int m, int n) {
    int jump[][] = new int[10][10];
    jump[1][3] = jump[3][1] = 2;
    jump[1][7] = jump[7][1] = 4;
    jump[3][9] = jump[9][3] = 6;
    jump[7][9] = jump[9][7] = 8;
    jump[1][9] =
        jump[9][1] =
            jump[2][8] = jump[8][2] = jump[3][7] = jump[7][3] = jump[4][6] = jump[6][4] = 5;
    boolean visited[] = new boolean[10];
    int sum = 0;
    for (int i = m; i <= n; i++) {
      sum += numberOfPatterns(visited, jump, 1, i - 1) * 4;
      sum += numberOfPatterns(visited, jump, 2, i - 1) * 4;
      sum += numberOfPatterns(visited, jump, 5, i - 1);
    }
    return sum;
  }

  public int numberOfPatterns(boolean[] visited, int[][] jump, int curr, int remain) {
    if (remain < 0) return 0;
    if (remain == 0) return 1;
    visited[curr] = true;
    int sum = 0;
    for (int i = 1; i <= 9; i++)
      if (!visited[i] && (jump[curr][i] == 0 || visited[jump[curr][i]]))
        sum += numberOfPatterns(visited, jump, i, remain - 1);
    visited[curr] = false;
    return sum;
  }
}
