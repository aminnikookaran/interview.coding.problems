package leetcode.easy;

// https://leetcode.com/problems/guess-number-higher-or-lower/
public class Q374GuessNumberHigherOrLower {
  private int guess(int mid) {
    return 0;
  }

  public int guessNumber1(int n) {
    int left = 1, right = n;
    while (left < right) {
      int mid = left + (right - left) / 2;
      int res = guess(mid);
      if (res == 0) return mid;
      else if (res == -1) right = mid - 1;
      else left = mid + 1;
    }
    return left;
  }

  public int guessNumber2(int n) {
    int low = 1;
    int high = n;
    while (low <= high) {
      int mid1 = low + (high - low) / 3;
      int mid2 = high - (high - low) / 3;
      int res1 = guess(mid1);
      int res2 = guess(mid2);
      if (res1 == 0) return mid1;
      if (res2 == 0) return mid2;
      else if (res1 < 0) high = mid1 - 1;
      else if (res2 > 0) low = mid2 + 1;
      else {
        low = mid1 + 1;
        high = mid2 - 1;
      }
    }
    return -1;
  }
}
