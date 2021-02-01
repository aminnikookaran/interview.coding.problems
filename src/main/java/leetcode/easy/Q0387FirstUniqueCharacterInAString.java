package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/first-unique-character-in-a-string/
public class Q0387FirstUniqueCharacterInAString {
  public int firstUniqChar1(String s) {
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

  public int firstUniqChar2(String s) {
    int freq[] = new int[26];
    for (int i = 0; i < s.length(); i++) freq[s.charAt(i) - 'a']++;
    for (int i = 0; i < s.length(); i++) if (freq[s.charAt(i) - 'a'] == 1) return i;
    return -1;
  }
}
