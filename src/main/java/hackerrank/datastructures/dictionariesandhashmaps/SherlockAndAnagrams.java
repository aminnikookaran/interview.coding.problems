package hackerrank.datastructures.dictionariesandhashmaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=dictionaries-hashmaps
public class SherlockAndAnagrams {
  public static int sherlockAndAnagrams(String s) {
    int n = s.length();
    int sum = 0;
    for (int i = 1; i < n; i++) {
      Map<String, Integer> map = new HashMap<>();
      for (int j = 0; j <= n - i; j++) {
        char[] chars = s.substring(j, j + i).toCharArray();
        Arrays.sort(chars);
        String sub = new String(chars);
        Integer count = map.get(sub);
        if (count == null) map.put(sub, 1);
        else {
          map.put(sub, count + 1);
          sum += count;
        }
      }
    }
    return sum;
  }
}
