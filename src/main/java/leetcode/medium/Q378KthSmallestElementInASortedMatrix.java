package leetcode.medium;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
public class Q378KthSmallestElementInASortedMatrix {
  public int kthSmallest1(int[][] matrix, int k) {
    int n = matrix.length;
    PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
    for (int j = 0; j <= n - 1; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
    for (int i = 0; i < k - 1; i++) {
      Tuple t = pq.poll();
      if (t.y == n - 1) continue;
      pq.offer(new Tuple(t.y + 1, t.x, matrix[t.y + 1][t.x]));
    }
    return pq.poll().val;
  }

  class Tuple implements Comparable<Tuple> {
    int y, x, val;

    public Tuple(int x, int y, int val) {
      this.y = x;
      this.x = y;
      this.val = val;
    }

    @Override
    public int compareTo(Tuple that) {
      return Integer.compare(this.val, that.val);
    }
  }

  public int kthSmallest2(int[][] matrix, int k) {
    int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      int count = 0, j = matrix[0].length - 1;
      for (int i = 0; i < matrix.length; i++) {
        while (j >= 0 && matrix[i][j] > mid) j--;
        count += (j + 1);
      }
      if (count < k) lo = mid + 1;
      else hi = mid;
    }
    return lo;
  }
}
