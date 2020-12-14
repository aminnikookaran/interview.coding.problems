package leetcode.medium;

// https://leetcode.com/problems/sum-of-two-integers/
public class Q371SumOfTwoIntegers {
  public int getSum1(int a, int b) {
    while (b != 0) {
      int c = a & b;
      a = a ^ b;
      b = c << 1;
    }
    return a;
  }

  public int getSum2(int a, int b) {
    if (b == 0) return a;
    return getSum2(a ^ b, (a & b) << 1);
  }
}
