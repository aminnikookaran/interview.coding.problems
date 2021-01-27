package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters
public class Q0340LongestSubstringWithAtMostKDistinctCharacters {
  public int lengthOfLongestSubstringTwoDistinct1(String s) {
    int max = 0;
    Map<Character, Integer> map = new HashMap<>();
    int start = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
      if (map.size() > 2) {
        max = Math.max(max, i - start);
        while (map.size() > 2) {
          char t = s.charAt(start);
          int count = map.get(t);
          if (count > 1) map.put(t, count - 1);
          else map.remove(t);
          start++;
        }
      }
    }
    max = Math.max(max, s.length() - start);
    return max;
  }

  public int lengthOfLongestSubstringKDistinct2(String s, int k) {
    int result = 0;
    int i = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int j = 0; j < s.length(); j++) {
      char c = s.charAt(j);
      map.put(c, map.getOrDefault(c, 0) + 1);
      if (map.size() <= k) result = Math.max(result, j - i + 1);
      else
        while (map.size() > k) {
          char l = s.charAt(i);
          int count = map.get(l);
          if (count == 1) map.remove(l);
          else map.put(l, map.get(l) - 1);
          i++;
        }
    }
    return result;
  }
}
