package leetcode.easy;

// https://leetcode.com/problems/length-of-last-word/
public class Q0058LengthOfLastWord {
  public int lengthOfLastWord1(String s) {
    if (s == null || s.length() == 0) return 0;
    int start = s.length() - 1;
    for (int i = start; i >= 0; i--)
      if (s.charAt(i) != ' ') {
        start = i;
        break;
      }
    for (int i = start; i >= 0; i--) if (s.charAt(i) == ' ') return start - i;
    return s.charAt(0) == ' ' ? 0 : start + 1;
  }

  public int lengthOfLastWord(String s) {
    if (s == null || s.length() == 0) return 0;
    int result = 0;
    int len = s.length();
    boolean flag = false;
    for (int i = len - 1; i >= 0; i--) {
      char c = s.charAt(i);
      if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
        flag = true;
        result++;
      } else if (flag) return result;
    }
    return result;
  }
}
