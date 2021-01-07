package leetcode.easy;

// https://leetcode.com/problems/fibonacci-number/
public class Q509FibonacciNumber {
  public int fib1(int N) {
    if (N <= 1) return N;
    return memoize1(N);
  }

  public int memoize1(int N) {
    int[] cache = new int[N + 1];
    cache[1] = 1;
    for (int i = 2; i <= N; i++) cache[i] = cache[i - 1] + cache[i - 2];
    return cache[N];
  }

  private Integer[] cache = new Integer[31];

  public int fib2(int N) {
    if (N <= 1) return N;
    cache[0] = 0;
    cache[1] = 1;
    return memoize2(N);
  }

  public int memoize2(int N) {
    if (cache[N] != null) return cache[N];
    cache[N] = memoize2(N - 1) + memoize2(N - 2);
    return memoize2(N);
  }

  public int fib3(int N) {
    if (N <= 1) return N;
    if (N == 2) return 1;
    int current = 0;
    int prev1 = 1;
    int prev2 = 1;
    for (int i = 3; i <= N; i++) {
      current = prev1 + prev2;
      prev2 = prev1;
      prev1 = current;
    }
    return current;
  }

  int fib4(int N) {
    if (N <= 1) return N;
    int[][] A = new int[][] {{1, 1}, {1, 0}};
    matrixPower4(A, N - 1);
    return A[0][0];
  }

  void matrixPower4(int[][] A, int N) {
    if (N <= 1) return;
    matrixPower4(A, N / 2);
    multiply4(A, A);
    int[][] B = new int[][] {{1, 1}, {1, 0}};
    if (N % 2 != 0) multiply4(A, B);
  }

  void multiply4(int[][] A, int[][] B) {
    int x = A[0][0] * B[0][0] + A[0][1] * B[1][0];
    int y = A[0][0] * B[0][1] + A[0][1] * B[1][1];
    int z = A[1][0] * B[0][0] + A[1][1] * B[1][0];
    int w = A[1][0] * B[0][1] + A[1][1] * B[1][1];
    A[0][0] = x;
    A[0][1] = y;
    A[1][0] = z;
    A[1][1] = w;
  }

  public int fib5(int N) {
    double goldenRatio = (1 + Math.sqrt(5)) / 2;
    return (int) Math.round(Math.pow(goldenRatio, N) / Math.sqrt(5));
  }
}
