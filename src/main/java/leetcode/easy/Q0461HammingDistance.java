package leetcode.easy;

// https://leetcode.com/problems/hamming-distance/
public class Q0461HammingDistance {
  public int hammingDistance1(int x, int y) {
    int xor = x ^ y, count = 0;
    while (xor != 0) {
      count += xor & 1;
      xor >>= 1;
    }
    return count;
  }

  public int hammingDistance(int x, int y) {
    int xor = x ^ y, count = 0;
    while (xor != 0) {
      xor &= (xor - 1);
      count++;
    }
    return count;
  }
}
