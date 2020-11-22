package interviewbit.programming.math;

// https://www.interviewbit.com/problems/find-nth-fibonacci/
public class FindNthFibonacci {
  public static int solveSlow(int A) {
    if (A < 3) return 1;
    long fibPre = 1;
    long fibPrePre = 1;
    long fibCurr = 1;
    for (long i = 3; i <= A; i++) {
      fibCurr = (fibPre + fibPrePre) % 1000000007;
      fibPrePre = fibPre;
      fibPre = fibCurr;
    }
    return (int) fibCurr;
  }

  public static int solveFast(int A) {
    String binary = "";
    while (A > 0) {
      binary = (A % 2) + binary;
      A /= 2;
    }
    if (binary.length() == 0) binary = "0";

    long[] fibi = new long[] {1, 1, 1, 0};
    long[] result = new long[] {1, 0, 0, 1};
    for (int i = binary.length() - 1; i >= 0; i--) {
      if (i < binary.length() - 1) fibi = multiply(fibi, fibi);

      if (binary.charAt(i) == '1') result = multiply(result, fibi);
    }
    return (int) result[1];
  }

  public static long[] multiply(long[] A, long[] B) {
    long[] C = new long[4];
    C[0] = (A[0] * B[0] + A[1] * B[2]) % 1000000007;
    C[1] = (A[0] * B[1] + A[1] * B[3]) % 1000000007;
    C[2] = (A[2] * B[0] + A[3] * B[2]) % 1000000007;
    C[3] = (A[2] * B[1] + A[3] * B[3]) % 1000000007;
    return C;
  }

  public static void main(String[] args) {
    int A = 100;
    System.out.println(System.currentTimeMillis());
    System.out.println(solveSlow(A));
    System.out.println(System.currentTimeMillis());
    System.out.println(solveFast(A));
    System.out.println(System.currentTimeMillis());
  }
}
