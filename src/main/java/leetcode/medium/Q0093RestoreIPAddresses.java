package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/restore-ip-addresses/
public class Q0093RestoreIPAddresses {
  public List<String> restoreIpAddresses1(String s) {
    List<String> res = new ArrayList<String>();
    int len = s.length();
    for (int i = 1; i < 4 && i < len - 2; i++) {
      for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
        for (int k = j + 1; k < j + 4 && k < len; k++) {
          String s1 = s.substring(0, i),
              s2 = s.substring(i, j),
              s3 = s.substring(j, k),
              s4 = s.substring(k, len);
          if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
            res.add(s1 + "." + s2 + "." + s3 + "." + s4);
          }
        }
      }
    }
    return res;
  }

  public boolean isValid(String s) {
    if (s.length() > 3
        || s.length() == 0
        || (s.charAt(0) == '0' && s.length() > 1)
        || Integer.parseInt(s) > 255) return false;
    return true;
  }

  public List<String> restoreIpAddresses2(String s) {
    List<String> res = new ArrayList<>();
    restoreHelper(s, res, new StringBuilder(), 0, 0);
    return res;
  }

  private void restoreHelper(String s, List<String> res, StringBuilder sb, int pos, int sec) {
    if (s.length() - pos > 3 * (4 - sec)) return;
    if (sec == 4 && pos == s.length()) {
      res.add(sb.toString());
      return;
    }
    for (int i = 1; i <= 3; i++) {
      if (pos + i > s.length()) return;
      int num = Integer.valueOf(s.substring(pos, pos + i));
      if (i == 1 || i == 2 && num >= 10 && num <= 99 || i == 3 && num >= 100 && num <= 255) {
        sb.append(num);
        if (sec < 3) sb.append(".");
        restoreHelper(s, res, sb, pos + i, sec + 1);
        if (sec < 3) sb.deleteCharAt(sb.length() - 1);
        sb.delete(sb.length() - i, sb.length());
      }
    }
  }
}
