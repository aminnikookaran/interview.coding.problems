package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/shortest-word-distance-ii/
public class Q0244ShortestWordDistanceII {
  public class WordDistance1 {
    Map<String, List<Integer>> map;

    public WordDistance1(String[] words) {
      map = new HashMap<>();
      for (int i = 0; i < words.length; i++)
        if (map.containsKey(words[i])) map.get(words[i]).add(i);
        else {
          List<Integer> list = new ArrayList<>();
          list.add(i);
          map.put(words[i], list);
        }
    }

    public int shortest(String word1, String word2) {
      List<Integer> l1 = map.get(word1);
      List<Integer> l2 = map.get(word2);
      int result = Integer.MAX_VALUE;
      for (int i1 : l1) for (int i2 : l2) result = Math.min(result, Math.abs(i1 - i2));
      return result;
    }
  }

  public class WordDistance2 {
    Map<String, List<Integer>> map;

    public WordDistance2(String[] words) {
      map = new HashMap<>();
      for (int i = 0; i < words.length; i++)
        if (map.containsKey(words[i])) map.get(words[i]).add(i);
        else {
          List<Integer> list = new ArrayList<>();
          list.add(i);
          map.put(words[i], list);
        }
    }

    public int shortest(String word1, String word2) {
      List<Integer> l1 = map.get(word1);
      List<Integer> l2 = map.get(word2);
      int result = Integer.MAX_VALUE;
      int i = 0;
      int j = 0;
      while (i < l1.size() && j < l2.size()) {
        result = Math.min(result, Math.abs(l1.get(i) - l2.get(j)));
        if (l1.get(i) < l2.get(j)) i++;
        else j++;
      }
      return result;
    }
  }
}
