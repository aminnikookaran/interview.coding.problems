package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import leetcode.Pair;

// https://leetcode.com/problems/time-based-key-value-store/
public class Q0981TimeBasedKeyValueStore {
  class TimeMap1 {
    Map<String, List<Pair<Integer, String>>> M;

    public TimeMap1() {
      M = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
      if (!M.containsKey(key)) M.put(key, new ArrayList<>());
      M.get(key).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
      if (!M.containsKey(key)) return "";
      List<Pair<Integer, String>> A = M.get(key);
      int i =
          Collections.binarySearch(
              A,
              new Pair<Integer, String>(timestamp, "{"),
              (a, b) -> Integer.compare(a.getKey(), b.getKey()));
      if (i >= 0) return A.get(i).getValue();
      else if (i == -1) return "";
      else return A.get(-i - 2).getValue();
    }
  }

  class TimeMap2 {
    Map<String, TreeMap<Integer, String>> M;

    public TimeMap2() {
      M = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
      if (!M.containsKey(key)) M.put(key, new TreeMap<>());
      M.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
      if (!M.containsKey(key)) return "";
      TreeMap<Integer, String> tree = M.get(key);
      Entry<Integer, String> t = tree.floorEntry(timestamp);
      return t != null ? t.getValue() : "";
    }
  }

  class TimeMap3 {
    class Data {
      String val;
      int time;

      Data(String val, int time) {
        this.val = val;
        this.time = time;
      }
    }

    /** Initialize your data structure here. */
    Map<String, List<Data>> map;

    public TimeMap3() {
      map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
      if (!map.containsKey(key)) map.put(key, new ArrayList<>());
      map.get(key).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
      if (!map.containsKey(key)) return "";
      return binarySearch(map.get(key), timestamp);
    }

    protected String binarySearch(List<Data> list, int time) {
      int low = 0, high = list.size() - 1;
      while (low < high) {
        int mid = (low + high + 1) >> 1;
        if (list.get(mid).time <= time) low = mid;
        else high = mid - 1;
      }
      return list.get(low).time <= time ? list.get(low).val : "";
    }
  }
}
