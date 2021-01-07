package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/first-unique-character-in-a-string/
public class Q0387FirstUniqueCharacterInAString {
  public int firstUniqChar(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      Integer count = map.get(s.charAt(i));
      if (count == null) count = 0;
      map.put(s.charAt(i), count + 1);
    }
    for (int i = 0; i < s.length(); i++) {
      Integer count = map.get(s.charAt(i));
      if (count == 1) return i;
    }
    return -1;
  }
}
