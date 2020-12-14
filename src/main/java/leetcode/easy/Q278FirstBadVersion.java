package leetcode.easy;

// https://leetcode.com/problems/first-bad-version/
public class Q278FirstBadVersion {

  private boolean isBadVersion(int mid) {
    return false;
  }

  public int firstBadVersion(int n) {
    int left = 1, right = n;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (isBadVersion(mid)) right = mid;
      else left = mid + 1;
    }
    return right;
  }
}
