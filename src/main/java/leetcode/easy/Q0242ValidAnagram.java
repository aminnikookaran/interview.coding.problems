package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/valid-anagram/
public class Q0242ValidAnagram {
  public boolean isAnagram1(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    for (int i = 0; i < t.length(); i++) {
      Integer count = map.get(t.charAt(i));
      if (count == null) return false;
      if (count == 1) map.remove(t.charAt(i));
      else map.put(t.charAt(i), count - 1);
    }
    if (map.size() > 0) return false;
    return true;
  }

  public boolean isAnagram2(String s, String t) {
    if (s.length() != t.length()) return false;
    char[] str1 = s.toCharArray();
    char[] str2 = t.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1, str2);
  }
}
