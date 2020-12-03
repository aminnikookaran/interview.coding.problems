package hackerrank.algorithms.recursionbacktracking;

// https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=recursion-backtracking
public class RecursionDavisStaircase {
  public static long stepPerms1(int n) {
    if (n <= 0) return 0;
    if (n == 1) return 1;
    if (n == 2) return 2;
    if (n == 3) return 4;
    long stairPrePrePre = 1;
    long stairPrePre = 2;
    long stairPre = 4;
    long stairCurr = 4;
    for (int i = 4; i <= n; i++) {
      stairCurr = stairPrePrePre + stairPrePre + stairPre;
      stairPrePrePre = stairPrePre;
      stairPrePre = stairPre;
      stairPre = stairCurr;
    }
    return stairCurr;
  }

  public static long stepPerms2(int n) {
    if (n <= 0) return 0;
    if (n == 1) return 1;
    if (n == 2) return 2;
    if (n == 3) return 4;
    long[] a = new long[n + 1];
    a[0] = 0;
    a[1] = 1;
    a[2] = 2;
    a[3] = 4;
    for (int i = 4; i <= n; i++) a[i] = a[i - 1] + a[i - 2] + a[i - 3];
    return a[n];
  }

  public static long stepPerms3(int n) {
    long[] step = new long[] {1, 1, 0, 1, 0, 1, 1, 0, 0};
    long[] result = new long[] {1, 0, 0, 0, 1, 0, 0, 0, 1};
    while (n > 0) {
      if (n % 2 == 1) result = multiply(result, step);
      n /= 2;
      step = multiply(step, step);
    }
    return result[0];
  }

  public static long[] multiply(long[] a, long[] b) {
    long[] c = new long[9];
    c[0] = a[0] * b[0] + a[1] * b[3] + a[2] * b[6];
    c[1] = a[0] * b[1] + a[1] * b[4] + a[2] * b[7];
    c[2] = a[0] * b[2] + a[1] * b[5] + a[2] * b[8];
    c[3] = a[3] * b[0] + a[4] * b[3] + a[5] * b[6];
    c[4] = a[3] * b[1] + a[4] * b[4] + a[5] * b[7];
    c[5] = a[3] * b[2] + a[4] * b[5] + a[5] * b[8];
    c[6] = a[6] * b[0] + a[7] * b[3] + a[8] * b[6];
    c[7] = a[6] * b[1] + a[7] * b[4] + a[8] * b[7];
    c[8] = a[6] * b[2] + a[7] * b[5] + a[8] * b[8];
    return c;
  }

  public static void main(String[] args) {
    int n = 100;
    System.out.println(System.currentTimeMillis());
    System.out.println(stepPerms1(n));
    System.out.println(System.currentTimeMillis());
    System.out.println(stepPerms2(n));
    System.out.println(System.currentTimeMillis());
    System.out.println(stepPerms3(n));
    System.out.println(System.currentTimeMillis());
  }
}
