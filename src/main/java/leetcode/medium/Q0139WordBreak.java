package leetcode.medium;

import java.util.Arrays;
import java.util.Set;

// https://leetcode.com/problems/word-break/
public class Q0139WordBreak {
  public boolean wordBreak2(String s, Set<String> dict) {
    return wordBreakHelper(s, dict, 0);
  }

  public boolean wordBreakHelper(String s, Set<String> dict, int start) {
    if (start == s.length()) return true;
    for (String a : dict) {
      int len = a.length();
      int end = start + len;
      // end index should be <= string length
      if (end > s.length()) continue;
      if (s.substring(start, start + len).equals(a))
        if (wordBreakHelper(s, dict, start + len)) return true;
    }
    return false;
  }

  public boolean wordBreak3(String s, Set<String> dict) {
    boolean[] t = new boolean[s.length() + 1];
    t[0] = true; // set first to be true, why?
    // Because we need initial state
    for (int i = 0; i < s.length(); i++) {
      // should continue from match position
      if (!t[i]) continue;
      for (String a : dict) {
        int len = a.length();
        int end = i + len;
        if (end > s.length()) continue;
        if (t[end]) continue;
        if (s.substring(i, end).equals(a)) t[end] = true;
      }
    }
    return t[s.length()];
  }

  public boolean wordBreak4(String s, Set<String> wordDict) {
    int[] pos = new int[s.length() + 1];
    Arrays.fill(pos, -1);
    pos[0] = 0;
    for (int i = 0; i < s.length(); i++)
      if (pos[i] != -1)
        for (int j = i + 1; j <= s.length(); j++) {
          String sub = s.substring(i, j);
          if (wordDict.contains(sub)) pos[j] = i;
        }
    return pos[s.length()] != -1;
  }
}
