package leetcode.easy;

// https://leetcode.com/problems/valid-perfect-square/
public class Q0367ValidPerfectSquare {
  public boolean isPerfectSquare(int num) {
    int left = 1, right = num;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int div = num / mid;
      int rem = num % mid;
      if (div == mid && rem == 0) return true;
      else if (div == mid && rem != 0) return false;
      else if (div > mid) left = mid + 1;
      else right = mid - 1;
    }
    return false;
  }
}
