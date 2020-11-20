package problems.math;

public class GridUniquePathsNumber {
  public static int uniquePaths1(int A, int B) {
    if (A < 1 || B < 1) return 0;
    if (A == 1 || B == 1) return 1;
    return uniquePaths1(A - 1, B) + uniquePaths1(A, B - 1);
  }

  public static int uniquePaths2(int A, int B) {
    if (A == 1 || B == 1) return 1;
    for (int n = 0; n <= A + B; n++) {
      int nCk = 1;
      for (int k = 0; k <= n; k++) {
        if (n == A + B - 2 && k == B - 1) return nCk;
        nCk = nCk * (n - k) / (k + 1);
      }
    }
    return 0;
  }

  public static int uniquePaths3(int A, int B) {
    return ncr(A + B - 2, Math.min(A - 1, B - 1));
  }

  private static int ncr(int n, int r) {
    long res = 1;
    int R = Math.min(r, n - r);
    for (int i = 1; i <= R; i++) {
      res *= n;
      n--;
    }
    long res1 = 1;
    for (int i = 1; i <= r; i++) {
      res1 *= i;
    }
    return (int) (res / res1);
  }

  public static void main(String[] args) {
    System.out.println(uniquePaths1(2, 2));
  }
}
