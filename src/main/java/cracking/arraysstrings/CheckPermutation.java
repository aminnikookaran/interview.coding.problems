package cracking.arraysstrings;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {
  public static boolean permutation1(String a, String b) {
    if (a == b) return true;
    if (a == null | b == null) return false;
    if (a.length() != b.length()) return false;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < a.length(); i++) {
      Integer count = map.get(a.charAt(i));
      if (count == null) count = 0;
      map.put(a.charAt(i), count + 1);
    }
    for (int i = 0; i < b.length(); i++) {
      Integer count = map.get(b.charAt(i));
      if (count == null) return false;
      if (count == 1) map.remove(a.charAt(i));
      else map.put(a.charAt(i), count - 1);
    }
    if (map.size() > 0) return false;
    return true;
  }

  public static String sort(String s) {
    char[] content = s.toCharArray();
    java.util.Arrays.sort(content);
    return new String(content);
  }

  public static boolean permutation2(String s, String t) {
    if (s.length() != t.length()) return false;
    return sort(s).equals(sort(t));
  }

  public static boolean permutation3(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] letters = new int[128];
    char[] s_array = s.toCharArray();
    for (char c : s_array) letters[c]++;
    for (int i = 0; i < t.length(); i++) {
      int c = (int) t.charAt(i);
      letters[c]--;
      if (letters[c] < 0) return false;
    }
    return true;
  }
}
