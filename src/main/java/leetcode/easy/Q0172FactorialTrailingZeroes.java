package leetcode.easy;

// https://leetcode.com/problems/factorial-trailing-zeroes/
public class Q0172FactorialTrailingZeroes {
  public int trailingZeroes1(int n) {
    int count = 0;
    while (n > 0) {
      count += n / 5;
      n /= 5;
    }
    return count;
  }

  public int trailingZeroes2(int n) {
    if (n < 0) return -1;
    int count = 0;
    for (long i = 5; n / i >= 1; i *= 5) count += n / i;
    return count;
  }
}
