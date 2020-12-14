package leetcode.easy;

// https://leetcode.com/problems/number-of-1-bits/
public class Q191NumberOf1Bits {
  public int hammingWeight1(int n) {
    int count = 0;
    while (n != 0) {
      count += (n & 1);
      n = n >>> 1;
    }
    return count;
  }

  public int hammingWeight2(int n) {
    int bits = 0;
    int mask = 1;
    for (int i = 0; i < 32; i++) {
      if ((n & mask) != 0) bits++;
      mask <<= 1;
    }
    return bits;
  }

  public int hammingWeight3(int n) {
    int sum = 0;
    while (n != 0) {
      sum++;
      n &= (n - 1);
    }
    return sum;
  }
}
