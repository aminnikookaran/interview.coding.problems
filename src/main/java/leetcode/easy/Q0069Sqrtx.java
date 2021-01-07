package leetcode.easy;

// https://leetcode.com/problems/sqrtx/
public class Q0069Sqrtx {
  public int mySqrt(int x) {
    long low = 0;
    long high = x;
    while (low <= high) {
      long mid = (low + high) / 2;
      long y = mid * mid;
      if (y == x) return (int) mid;
      if (y < x) low = mid + 1;
      else high = mid - 1;
    }
    return (int) high;
  }
}
