package leetcode.easy;

// https://leetcode.com/problems/number-complement/
public class Q0476NumberComplement {
  public int findComplement1(int num) {
    int n = 0;
    while (n < num) n = (n << 1) | 1;
    return n - num;
  }

  public int findComplement2(int num) {
    return ~num & ((Integer.highestOneBit(num) << 1) - 1);
  }
}
