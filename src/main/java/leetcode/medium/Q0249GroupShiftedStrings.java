package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/group-shifted-strings/
public class Q0249GroupShiftedStrings {
  public List<List<String>> groupStrings1(String[] strings) {
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strings) {
      char[] arr = s.toCharArray();
      for (int i = 0; i < arr.length; i++) arr[i] = (char) ((arr[i] - arr[0] + 26) % 26 + 'a');
      String ns = new String(arr);
      if (!map.containsKey(ns)) map.put(ns, new ArrayList<>());
      map.get(ns).add(s);
    }
    return new ArrayList<>(map.values());
  }

  public List<List<String>> groupStrings2(String[] strings) {
    Map<String, List<String>> map = new HashMap<>();

    for (String s : strings) {
      String hash = getHash1(s);
      if (map.containsKey(hash)) {
        map.get(hash).add(s);
      } else {
        List<String> l = new ArrayList<>();
        l.add(s);
        map.put(hash, l);
      }
    }

    return new ArrayList<List<String>>(map.values());
  }

  public String getHash1(String s) {
    if (s.length() == 0) return "0";
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < s.length(); i++) {
      int diff = ((s.charAt(i) - s.charAt(i - 1)) + 26) % 26;
      sb.append(diff);
    }
    return sb.toString();
  }

  public String getHash2(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      sb.append((s.charAt(i) - s.charAt(0) + 26) % 26);
      sb.append('.'); // to make sure there is no overlap.
    }

    return sb.toString();
  }
}
