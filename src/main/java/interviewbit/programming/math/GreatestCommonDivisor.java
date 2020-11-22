package interviewbit.programming.math;

// https://www.interviewbit.com/problems/greatest-common-divisor/
public class GreatestCommonDivisor {
  public static int gcd(int A, int B) {
    if (B == 0) return A;
    return gcd(B, A % B);
  }

  public static void main(String[] args) {
    System.out.println(gcd(25, 5));
  }
}
