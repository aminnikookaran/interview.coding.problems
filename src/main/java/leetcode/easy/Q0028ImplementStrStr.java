package leetcode.easy;

// https://leetcode.com/problems/implement-strstr/
public class Q0028ImplementStrStr {
  public int strStr1(String haystack, String needle) {
    if (needle == null || needle.length() == 0) return 0;
    if (haystack == null || haystack.length() == 0) return -1;
    int i = 0;
    while (i < haystack.length()) {
      int j = 0;
      while (j < needle.length()
          && i + j < haystack.length()
          && needle.charAt(j) == haystack.charAt(i + j)) {
        if (j == needle.length() - 1) return i;
        j++;
      }
      i++;
    }
    return -1;
  }

  public int strStr(String haystack, String needle) {
    if (haystack == null || needle == null) return 0;
    int h = haystack.length();
    int n = needle.length();
    if (n > h) return -1;
    if (n == 0) return 0;
    int[] next = getNext(needle);
    int i = 0;
    while (i <= h - n) {
      int success = 1;
      for (int j = 0; j < n; j++)
        if (needle.charAt(0) != haystack.charAt(i)) {
          success = 0;
          i++;
          break;
        } else if (needle.charAt(j) != haystack.charAt(i + j)) {
          success = 0;
          i = i + j - next[j - 1];
          break;
        }
      if (success == 1) return i;
    }
    return -1;
  }

  // calculate KMP array
  public int[] getNext(String needle) {
    int[] next = new int[needle.length()];
    next[0] = 0;
    for (int i = 1; i < needle.length(); i++) {
      int index = next[i - 1];
      while (index > 0 && needle.charAt(index) != needle.charAt(i)) index = next[index - 1];
      if (needle.charAt(index) == needle.charAt(i)) next[i] = next[i - 1] + 1;
      else next[i] = 0;
    }
    return next;
  }
}
