package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/isomorphic-strings/
public class Q0205IsomorphicStrings {
  public boolean isIsomorphic1(String s, String t) {
    if (s == null && t == null) return true;
    if (s == null || t == null || s.length() != t.length()) return false;
    Map<Character, Character> mapst = new HashMap<>();
    Map<Character, Character> mapts = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      Character repst = mapst.get(s.charAt(i));
      if (repst == null) mapst.put(s.charAt(i), t.charAt(i));
      else if (t.charAt(i) != repst) return false;

      Character repts = mapts.get(t.charAt(i));
      if (repts == null) mapts.put(t.charAt(i), s.charAt(i));
      else if (s.charAt(i) != repts) return false;
    }
    return true;
  }

  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) return false;
    Map<Character, Character> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c1 = s.charAt(i);
      char c2 = t.charAt(i);
      if (map.containsKey(c1)) {
        if (map.get(c1) != c2) return false;
      } else map.put(c1, c2);
    }
    Set<Character> set = new HashSet<>(map.values());
    if (set.size() == map.values().size()) return true;
    return false;
  }
}
