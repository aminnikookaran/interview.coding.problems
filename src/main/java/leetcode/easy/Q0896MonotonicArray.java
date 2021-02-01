package leetcode.easy;

// https://leetcode.com/problems/monotonic-array/
public class Q0896MonotonicArray {
  public boolean isMonotonic1(int[] A) {
    return increasing(A) || decreasing(A);
  }

  public boolean increasing(int[] A) {
    for (int i = 0; i < A.length - 1; ++i) if (A[i] > A[i + 1]) return false;
    return true;
  }

  public boolean decreasing(int[] A) {
    for (int i = 0; i < A.length - 1; ++i) if (A[i] < A[i + 1]) return false;
    return true;
  }

  public boolean isMonotonic2(int[] A) {
    int store = 0;
    for (int i = 0; i < A.length - 1; ++i) {
      int c = Integer.compare(A[i], A[i + 1]);
      if (c != 0) {
        if (c != store && store != 0) return false;
        store = c;
      }
    }
    return true;
  }

  public boolean isMonotonic3(int[] A) {
    boolean increasing = true;
    boolean decreasing = true;
    for (int i = 0; i < A.length - 1; ++i) {
      if (A[i] > A[i + 1]) increasing = false;
      if (A[i] < A[i + 1]) decreasing = false;
    }
    return increasing || decreasing;
  }
}
