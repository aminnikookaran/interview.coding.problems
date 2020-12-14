package leetcode.easy;

// https://leetcode.com/problems/palindrome-number/
public class Q9PalindromeNumber {
  public boolean isPalindrome1(int x) {
    int y = 0;
    int z = x;
    while (z > 0) {
      y = y * 10 + z % 10;
      z /= 10;
    }
    return y == x;
  }

  public boolean IsPalindrome2(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) return false;
    int revertedNumber = 0;
    while (x > revertedNumber) {
      revertedNumber = revertedNumber * 10 + x % 10;
      x /= 10;
    }
    return x == revertedNumber || x == revertedNumber / 10;
  }
}
