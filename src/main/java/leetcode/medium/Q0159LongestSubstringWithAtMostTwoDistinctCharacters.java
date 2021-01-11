package leetcode.medium;

import java.util.HashMap;

// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
public class Q0159LongestSubstringWithAtMostTwoDistinctCharacters {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    int max = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    int i = 0;

    for (int j = 0; j < s.length(); j++) {
      char c = s.charAt(j);
      map.put(c, map.getOrDefault(c, 0) + 1);

      if (map.size() <= 2) max = Math.max(max, j - i + 1);
      else
        while (map.size() > 2) {
          c = s.charAt(i);
          int count = map.get(c);
          if (count > 1) map.put(c, count - 1);
          else map.remove(c);
          i++;
        }
    }

    max = Math.max(max, s.length() - i);

    return max;
  }

  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int max = 0;
    int i = 0;
    HashMap<Character, Integer> map = new HashMap<>();

    for (int j = 0; j < s.length(); j++) {
      char c = s.charAt(j);
      map.put(c, map.getOrDefault(c, 0) + 1);

      if (map.size() <= k) max = Math.max(max, j - i + 1);
      else
        while (map.size() > k) {
          c = s.charAt(i);
          int count = map.get(c);
          if (count > 1) map.put(c, count - 1);
          else map.remove(c);
          i++;
        }
    }

    return max;
  }
}
