package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-absolute-file-path/
public class Q0388LongestAbsoluteFilePath {
  public int lengthLongestPath1(String input) {
    Deque<Integer> deque = new ArrayDeque<>();
    deque.push(0);
    int result = 0;
    for (String s : input.split("\n")) {
      int level = s.lastIndexOf('\t') + 1;
      int len = s.length() - level;
      while (deque.size() > level + 1) deque.pop();
      if (s.contains(".")) result = Math.max(result, deque.peek() + len);
      else deque.push(deque.peek() + len + 1);
    }
    return result;
  }

  public int lengthLongestPath2(String input) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 0);
    int result = 0;
    for (String s : input.split("\n")) {
      int level = s.lastIndexOf('\t') + 1;
      int len = s.length() - level;
      if (s.contains(".")) result = Math.max(result, map.get(level) + len);
      else map.put(level + 1, map.get(level) + len + 1);
    }
    return result;
  }
}
