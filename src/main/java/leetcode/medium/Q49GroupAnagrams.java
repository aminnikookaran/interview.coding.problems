package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/group-anagrams/
public class Q49GroupAnagrams {
  public List<List<String>> groupAnagrams1(String[] strs) {
    Map<String, List<String>> result = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      char[] array = strs[i].toCharArray();
      Arrays.sort(array);
      String newString = new String(array);
      if (!result.containsKey(newString)) result.put(newString, new ArrayList<>());
      result.get(newString).add(strs[i]);
    }
    return new ArrayList<>(result.values());
  }

  public List<List<String>> groupAnagrams2(String[] strs) {
    if (strs.length == 0) return new ArrayList<>();
    Map<String, List<String>> ans = new HashMap<>();
    int[] count = new int[26];
    for (String s : strs) {
      Arrays.fill(count, 0);
      for (char c : s.toCharArray()) count[c - 'a']++;
      StringBuilder sb = new StringBuilder("");
      for (int i = 0; i < 26; i++) {
        sb.append('#');
        sb.append(count[i]);
      }
      String key = sb.toString();
      if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
      ans.get(key).add(s);
    }
    return new ArrayList<>(ans.values());
  }
}
