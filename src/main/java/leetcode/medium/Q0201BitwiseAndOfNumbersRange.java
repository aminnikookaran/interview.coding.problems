package leetcode.medium;

// https://leetcode.com/problems/bitwise-and-of-numbers-range/
public class Q0201BitwiseAndOfNumbersRange {
  public int rangeBitwiseAnd1(int m, int n) {
    while (n > m) n = n & n - 1;
    return m & n;
  }

  public int rangeBitwiseAnd2(int m, int n) {
    int i = 0; // i means we have how many bits are 0 on the right
    while (m != n) {
      m >>= 1;
      n >>= 1;
      i++;
    }
    return m << i;
  }
}
