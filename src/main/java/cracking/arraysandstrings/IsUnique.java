package cracking.arraysandstrings;

import java.util.HashSet;
import java.util.Set;

public class IsUnique {
  public static boolean isUniqueChars1(String a) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < a.length(); i++)
      if (set.contains(a.charAt(i))) return false;
      else set.add(a.charAt(i));
    return true;
  }

  public static boolean isUniqueChars2(String str) {
    if (str.length() > 128) return false;

    boolean[] char_set = new boolean[128];
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i);
      if (char_set[val]) { // Already found this char in string
        return false;
      }
      char_set[val] = true;
    }
    return true;
  }

  public static boolean isUniqueChars3(String str) {
    int checker = 0;
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i) - 'a';
      if ((checker & (1 << val)) > 0) {
        return false;
      }
      checker |= (1 << val);
    }
    return true;
  }
}
