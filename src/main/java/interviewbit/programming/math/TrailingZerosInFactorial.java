package interviewbit.programming.math;

public class TrailingZerosInFactorial {
  public static int trailingZeroes(int A) {
    int count = 0;
    while (A > 0) {
      count += A / 5;
      A /= 5;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(trailingZeroes(25));
    System.out.println(Integer.MAX_VALUE);
    System.out.println(Integer.MIN_VALUE);
  }
}
