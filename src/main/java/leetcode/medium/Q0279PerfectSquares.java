package leetcode.medium;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

// https://leetcode.com/problems/perfect-squares/
public class Q0279PerfectSquares {
  public int numSquares1(int n) {
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      dp[i] = i;
      for (int j = 1; j * j <= i; j++) dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
    }
    return dp[n];
  }

  public int numSquares2(int n) {
    Deque<Integer> q = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    q.offer(0);
    visited.add(0);
    int depth = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      depth++;
      while (size-- > 0) {
        int u = q.poll();
        for (int i = 1; i * i <= n; i++) {
          int v = u + i * i;
          if (v == n) return depth;
          if (v > n) break;
          if (!visited.contains(v)) {
            q.offer(v);
            visited.add(v);
          }
        }
      }
    }
    return depth;
  }
}
