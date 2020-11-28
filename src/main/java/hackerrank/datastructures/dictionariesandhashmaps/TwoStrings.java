package hackerrank.datastructures.dictionariesandhashmaps;

import java.util.HashSet;
import java.util.Set;

// https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=dictionaries-hashmaps
public class TwoStrings {
  public static String twoStrings(String s1, String s2) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s1.length() || i < s2.length(); i++) {
      if (i < s1.length()) set.add(s1.charAt(i));
      if (i < s2.length() && set.contains(s2.charAt(i))) return "YES";
    }
    return "NO";
  }
}
