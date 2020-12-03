package interviewbit.programming.math;

// https://www.interviewbit.com/problems/find-nth-fibonacci/
public class FindNthFibonacci {
  public static long solve1(int n) {
    if (n < 3) return 1;
    long fibPre = 1;
    long fibPrePre = 1;
    long fibCurr = 1;
    for (int i = 3; i <= n; i++) {
      fibCurr = fibPre + fibPrePre;
      fibPrePre = fibPre;
      fibPre = fibCurr;
    }
    return fibCurr;
  }

  public static long solve2(int n) {
    if (n < 3) return 1;
    long[] a = new long[n + 1];
    a[0] = 1;
    a[1] = 1;
    a[2] = 1;
    for (int i = 3; i <= n; i++) a[i] = a[i - 1] + a[i - 2];
    return a[n];
  }

  public static long solve3(int n) {
    long[] fibi = new long[] {1, 1, 1, 0};
    long[] result = new long[] {1, 0, 0, 1};
    while (n > 0) {
      if (n % 2 == 1) result = multiply(result, fibi);
      n /= 2;
      fibi = multiply(fibi, fibi);
    }
    return result[1];
  }

  public static long[] multiply(long[] a, long[] b) {
    long[] c = new long[4];
    c[0] = a[0] * b[0] + a[1] * b[2];
    c[1] = a[0] * b[1] + a[1] * b[3];
    c[2] = a[2] * b[0] + a[3] * b[2];
    c[3] = a[2] * b[1] + a[3] * b[3];
    return c;
  }

  public static void main(String[] args) {
    int n = 100;
    System.out.println(System.currentTimeMillis());
    System.out.println(solve1(n));
    System.out.println(System.currentTimeMillis());
    System.out.println(solve2(n));
    System.out.println(System.currentTimeMillis());
    System.out.println(solve3(n));
    System.out.println(System.currentTimeMillis());
  }
}
