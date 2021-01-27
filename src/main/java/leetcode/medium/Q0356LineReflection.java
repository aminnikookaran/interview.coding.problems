package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/line-reflection/
public class Q0356LineReflection {
  public boolean isReflected(int[][] points) {
    if (points == null || points.length <= 1) return true;

    int left = points[0][0];
    int right = left;

    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] p : points) {
      left = Math.min(p[0], left);
      right = Math.max(p[0], right);
      if (!map.containsKey(p[1])) map.put(p[1], new HashSet<>());
      map.get(p[1]).add(p[0]);
    }
    for (int[] p : points) if (!map.get(p[1]).contains(left + right - p[0])) return false;
    return true;
  }
}
