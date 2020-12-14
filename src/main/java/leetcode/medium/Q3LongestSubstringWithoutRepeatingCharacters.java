package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class Q3LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring1(String s) {
    Set<Character> set = new HashSet<>();
    int i = 0, j = 0, max = 0;
    while (j < s.length())
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j++));
        max = Math.max(max, set.size());
      } else set.remove(s.charAt(i++));
    return max;
  }

  public int lengthOfLongestSubstring(String s) {
    int n = s.length(), ans = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int j = 0, i = 0; j < n; j++) {
      if (map.containsKey(s.charAt(j))) i = Math.max(map.get(s.charAt(j)), i);
      ans = Math.max(ans, j - i + 1);
      map.put(s.charAt(j), j + 1);
    }
    return ans;
  }
}
