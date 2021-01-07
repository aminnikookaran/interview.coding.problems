package leetcode.easy;

// https://leetcode.com/problems/power-of-three/
public class Q0326PowerOfThree {
  public boolean isPowerOfThree1(int n) {
    if (n < 1) return false;
    while (n % 3 == 0) n /= 3;
    return (n == 1);
  }

  public boolean isPowerOfThree2(int n) {
    return Integer.toString(n, 3).matches("^10*$");
  }

  public boolean isPowerOfThree3(int n) {
    double epsilon = 0.001;
    return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
  }

  public boolean isPowerOfThree4(int n) {
    return n > 0 && 1162261467 % n == 0;
  }
}
