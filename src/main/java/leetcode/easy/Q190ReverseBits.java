package leetcode.easy;

// https://leetcode.com/problems/reverse-bits/
public class Q190ReverseBits {
  public int reverseBits1(int n) {
    int rev = 0;
    for (int i = 0; i < 32; i++) {
      int bit = ((n >>> i) & 1);
      rev = rev << 1;
      rev = rev | bit;
    }
    return rev;
  }

  public int reverseBits2(int n) {
    int rev = 0, power = 31;
    while (n != 0) {
      rev += ((n & 1) << power);
      n = n >>> 1;
      power--;
    }
    return rev;
  }

  public int reverseBits3(int n) {
    for (int i = 0; i < 16; i++) n = swapBits(n, i, 32 - i - 1);
    return n;
  }

  public int swapBits(int n, int i, int j) {
    int a = (n >> i) & 1;
    int b = (n >> j) & 1;
    if ((a ^ b) != 0) return n ^= (1 << i) | (1 << j);
    return n;
  }
}
