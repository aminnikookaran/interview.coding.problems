package leetcode.easy;

// https://leetcode.com/problems/valid-palindrome/
public class Q125ValidPalindrome {
  public boolean isPalindrome(String s) {
    if (s == null) return true;
    s = s.toLowerCase();
    int i = 0;
    int j = s.length() - 1;
    while (i < j) {
      while (i < j && !isAlphanumeric(s.charAt(i))) i++;
      while (i < j && !isAlphanumeric(s.charAt(j))) j--;
      if (i < j && s.charAt(i) != s.charAt(j)) return false;
      i++;
      j--;
    }
    return true;
  }

  public boolean isAlphanumeric(char c) {
    return ((c >= 'a' && c <= 'z') || (c >= '0' && c <= 9));
  }
}
