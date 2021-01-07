package leetcode.easy;

// https://leetcode.com/problems/arranging-coins/
public class Q0441ArrangingCoins {
  public int arrangeCoins1(int n) {
    long left = 0, right = n;
    long k, curr;
    while (left <= right) {
      k = left + (right - left) / 2;
      curr = k * (k + 1) / 2;
      if (curr == n) return (int) k;
      if (n < curr) right = k - 1;
      else left = k + 1;
    }
    return (int) right;
  }

  public int arrangeCoins2(int n) {
    return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
  }
}
