package leetcode.medium;

// https://leetcode.com/problems/one-edit-distance/
public class Q161OneEditDistance {
  public boolean isOneEditDistance(String s, String t) {
    if (s == null || t == null) return false;
    int m = s.length(), n = t.length();
    if (Math.abs(m - n) > 1) return false;

    int i = 0, j = 0, count = 0;
    while (i < m && j < n) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
        j++;
      } else {
        count++;
        if (count > 1) return false;
        if (m > n) i++;
        else if (m < n) j++;
        else {
          i++;
          j++;
        }
      }
    }
    if (i < m || j < n) count++;
    if (count == 1) return true;
    return false;
  }
}
