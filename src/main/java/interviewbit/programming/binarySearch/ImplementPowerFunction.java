package interviewbit.programming.binarySearch;

// https://www.interviewbit.com/problems/implement-power-function/
public class ImplementPowerFunction {
  public static int pow1(int x, int n, int d) {
    if (x == 0) return 0;
    if (n == 0) return 1 % d;

    long y = x;
    long result = 1;

    while (n > 0) {
      if (n % 2 == 1) result = (result * y) % d;
      n /= 2;
      y = (y * y) % d;
    }

    return (int) (result + d) % d;
  }

  public int pow2(int x, int n, int d) {
    if (x == 0) return 0;
    if (n == 0) return 1 % d;

    long temp = pow2(x, n / 2, d) % d;
    long ans = (temp * temp) % d;
    if (n % 2 == 1) ans = (ans * x) % d;

    return (int) (ans + d) % d;
  }

  public static void main(String[] args) {
    System.out.println(pow1(-20, 1, 3));
  }
}
