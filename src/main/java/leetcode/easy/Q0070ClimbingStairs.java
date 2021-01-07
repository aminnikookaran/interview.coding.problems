package leetcode.easy;

// https://leetcode.com/problems/climbing-stairs/
public class Q0070ClimbingStairs {
  public int climbStairs1(int n) {
    if (n < 1) return 0;
    if (n == 1) return 1;
    if (n == 2) return 2;
    int stepsPre2 = 1;
    int stepsPre1 = 2;
    int stepsCurr = 0;
    for (int i = 3; i <= n; i++) {
      stepsCurr = stepsPre2 + stepsPre1;
      stepsPre2 = stepsPre1;
      stepsPre1 = stepsCurr;
    }
    return stepsCurr;
  }

  public int climbStairs2(int n) {
    int[][] q = {{1, 1}, {1, 0}};
    int[][] res = pow(q, n);
    return res[0][0];
  }

  public int[][] pow(int[][] a, int n) {
    int[][] ret = {{1, 0}, {0, 1}};
    while (n > 0) {
      if ((n & 1) == 1) ret = multiply(ret, a);
      n >>= 1;
      a = multiply(a, a);
    }
    return ret;
  }

  public int[][] multiply(int[][] a, int[][] b) {
    int[][] c = new int[2][2];
    for (int i = 0; i < 2; i++)
      for (int j = 0; j < 2; j++) c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
    return c;
  }

  public int climbStairs3(int n) {
    double sqrt5 = Math.sqrt(5);
    double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
    return (int) (fibn / sqrt5);
  }
}
