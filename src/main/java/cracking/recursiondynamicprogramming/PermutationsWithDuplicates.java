package cracking.recursiondynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsWithDuplicates {
  List<String> printPerms(String s) {
    List<String> result = new ArrayList<String>();
    Map<Character, Integer> map = buildFreqTable(s);
    printPerms(map, "", s.length(), result);
    return result;
  }

  Map<Character, Integer> buildFreqTable(String s) {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (char c : s.toCharArray()) {
      if (!map.containsKey(c)) map.put(c, 0);
      map.put(c, map.get(c) + 1);
    }
    return map;
  }

  void printPerms(Map<Character, Integer> map, String prefix, int remaining, List<String> result) {
    /* Base case. Permutation has been completed. */
    if (remaining == 0) {
      result.add(prefix);
      return;
    }

    /* Try remaining letters for next char, and generate remaining permutations. */
    for (Character c : map.keySet()) {
      int count = map.get(c);
      if (count > 0) {
        map.put(c, count - 1);
        printPerms(map, prefix + c, remaining - 1, result);
        map.put(c, count);
      }
    }
  }
}
