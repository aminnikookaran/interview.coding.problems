package leetcode.easy;

// https://leetcode.com/problems/reverse-string/
public class Q344ReverseString {
  public void reverseString1(char[] s) {
    int n = s.length;
    for (int i = 0; i < n / 2; i++) {
      char temp = s[n - 1 - i];
      s[n - 1 - i] = s[i];
      s[i] = temp;
    }
  }

  public void helper(char[] s, int left, int right) {
    if (left >= right) return;
    char tmp = s[left];
    s[left++] = s[right];
    s[right--] = tmp;
    helper(s, left, right);
  }

  public void reverseString2(char[] s) {
    helper(s, 0, s.length - 1);
  }

  public void reverseString3(char[] s) {
    int left = 0, right = s.length - 1;
    while (left < right) {
      char tmp = s[left];
      s[left++] = s[right];
      s[right--] = tmp;
    }
  }
}
