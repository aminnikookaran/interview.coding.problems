package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/word-pattern/
public class Q0290WordPattern {
  public boolean wordPattern1(String pattern, String s) {
    int j = 0;
    int start = 0;
    Map<Character, String> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ' || i == s.length() - 1) {
        if (i == s.length() - 1) i++;
        String currWord = map.get(pattern.charAt(j));
        String newWord = s.substring(start, i);
        if (currWord == null) map.put(pattern.charAt(j), newWord);
        else if (!currWord.equals(newWord)) return false;
        j++;
        start = i + 1;
        if (j >= pattern.length() ^ start >= s.length()) return false;
      }
    }
    Set<String> set = new HashSet<>(map.values());
    return set.size() == map.size();
  }

  public boolean wordPattern2(String pattern, String s) {
    Map<Character, String> map_char = new HashMap<>();
    Map<String, Character> map_word = new HashMap<>();
    String[] words = s.split(" ");
    if (words.length != pattern.length()) return false;
    for (int i = 0; i < words.length; i++) {
      char c = pattern.charAt(i);
      String w = words[i];
      if (!map_char.containsKey(c)) {
        if (map_word.containsKey(w)) {
          return false;
        } else {
          map_char.put(c, w);
          map_word.put(w, c);
        }
      } else {
        String mapped_word = map_char.get(c);
        if (!mapped_word.equals(w)) return false;
      }
    }
    return true;
  }

  public boolean wordPattern3(String pattern, String s) {
    Map<String, Integer> map_index = new HashMap<>();
    String[] words = s.split(" ");
    if (words.length != pattern.length()) return false;
    for (Integer i = 0; i < words.length; i++) {
      String c = String.valueOf(pattern.charAt(i));
      String w = words[i];
      if (!map_index.containsKey(c)) map_index.put(c, i);
      if (!map_index.containsKey(w)) map_index.put(w, i);
      if (map_index.get(c) != map_index.get(w)) return false;
    }
    return true;
  }
}
