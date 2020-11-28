package hackerrank.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

// https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=strings
public class StringsMakingAnagrams {
  public static int makeAnagram(String a, String b) {
    Map<Character, Integer> map = new HashMap<>();
    int n1 = a.length();
    for (int i = 0; i < n1; i++) {
      Integer count = map.get(a.charAt(i));
      map.put(a.charAt(i), count == null ? 1 : count + 1);
    }
    int n2 = 0;
    for (int i = 0; i < b.length(); i++) {
      Integer count = map.get(b.charAt(i));
      if (count != null) {
        if (count == 1) map.remove(b.charAt(i));
        else map.put(b.charAt(i), count - 1);
        n1--;
      } else n2++;
    }
    return n1 + n2;
  }
}
