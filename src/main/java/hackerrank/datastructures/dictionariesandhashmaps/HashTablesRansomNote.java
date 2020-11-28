package hackerrank.datastructures.dictionariesandhashmaps;

import java.util.HashMap;
import java.util.Map;

// https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=dictionaries-hashmaps
public class HashTablesRansomNote {
  public static void checkMagazine(String[] magazine, String[] note) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : note) {
      Integer count = map.get(word);
      map.put(word, count == null ? 1 : count + 1);
    }
    for (String word : magazine) {
      if (map.size() == 0) break;
      Integer count = map.get(word);
      if (count != null)
        if (count == 1) map.remove(word);
        else map.put(word, count - 1);
    }
    if (map.size() == 0) System.out.println("Yes");
    else System.out.println("No");
  }
}
