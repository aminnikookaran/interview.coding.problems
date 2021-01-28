package leetcode.medium;

// https://leetcode.com/problems/nth-digit/
public class Q0400NthDigit {
  public int findNthDigit(int n) {
    int len = 1, i = 1;
    while (n > 9l * len * i) {
      n -= 9l * len * i;
      len++;
      i *= 10;
    }

    i += (n - 1) / len;
    String s = Integer.toString(i);
    return Character.getNumericValue(s.charAt((n - 1) % len));
  }
}
