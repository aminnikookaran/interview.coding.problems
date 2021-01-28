package leetcode.medium;

// https://leetcode.com/problems/arithmetic-slices/
public class Q0413ArithmeticSlices {
  public int numberOfArithmeticSlices1(int[] A) {
    int count = 0;
    for (int s = 0; s < A.length - 2; s++) {
      int d = A[s + 1] - A[s];
      for (int e = s + 2; e < A.length; e++) {
        int i = 0;
        for (i = s + 1; i <= e; i++) if (A[i] - A[i - 1] != d) break;
        if (i > e) count++;
      }
    }
    return count;
  }

  public int numberOfArithmeticSlices2(int[] A) {
    int count = 0;
    for (int s = 0; s < A.length - 2; s++) {
      int d = A[s + 1] - A[s];
      for (int e = s + 2; e < A.length; e++) {
        if (A[e] - A[e - 1] == d) count++;
        else break;
      }
    }
    return count;
  }

  int sum = 0;

  public int numberOfArithmeticSlices3(int[] A) {
    slices3(A, A.length - 1);
    return sum;
  }

  public int slices3(int[] A, int i) {
    if (i < 2) return 0;
    int ap = 0;
    if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
      ap = 1 + slices3(A, i - 1);
      sum += ap;
    } else slices3(A, i - 1);
    return ap;
  }

  public int numberOfArithmeticSlices4(int[] A) {
    int[] dp = new int[A.length];
    int sum = 0;
    for (int i = 2; i < dp.length; i++) {
      if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
        dp[i] = 1 + dp[i - 1];
        sum += dp[i];
      }
    }
    return sum;
  }

  public int numberOfArithmeticSlices5(int[] A) {
    int dp = 0;
    int sum = 0;
    for (int i = 2; i < A.length; i++) {
      if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
        dp = 1 + dp;
        sum += dp;
      } else dp = 0;
    }
    return sum;
  }

  public int numberOfArithmeticSlices6(int[] A) {
    int count = 0;
    int sum = 0;
    for (int i = 2; i < A.length; i++) {
      if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
        count++;
      } else {
        sum += (count + 1) * (count) / 2;
        count = 0;
      }
    }
    return sum += count * (count + 1) / 2;
  }
}
