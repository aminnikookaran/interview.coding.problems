package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/insert-interval/
public class Q0057InsertInterval {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();
    int i = 0;
    while (i < intervals.length && intervals[i][1] < newInterval[0]) result.add(intervals[i++]);
    while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
      newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
      newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
      i++;
    }
    result.add(newInterval);
    while (i < intervals.length) result.add(intervals[i++]);
    return result.toArray(new int[result.size()][]);
  }

  public int[][] insert2(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();
    for (int[] i : intervals) {
      if (newInterval == null || i[1] < newInterval[0]) {
        result.add(i);
      } else if (i[0] > newInterval[1]) {
        result.add(newInterval);
        result.add(i);
        newInterval = null;
      } else {
        newInterval[0] = Math.min(newInterval[0], i[0]);
        newInterval[1] = Math.max(newInterval[1], i[1]);
      }
    }
    if (newInterval != null) result.add(newInterval);
    return result.toArray(new int[result.size()][]);
  }
}
