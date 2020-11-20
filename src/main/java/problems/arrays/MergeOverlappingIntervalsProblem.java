package problems.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class MergeOverlappingIntervalsProblem {
  public static class Interval {
    int start;
    int end;

    Interval() {
      start = 0;
      end = 0;
    }

    Interval(int s, int e) {
      start = s;
      end = e;
    }

    @Override
    public String toString() {
      return "[" + start + ", " + end + "]";
    }
  }

  public static List<Interval> merge1(List<Interval> intervals) {
    SortedMap<Integer, Interval> map = new TreeMap<>();
    for (Interval interval : intervals) {
      Interval newInterval = map.get(interval.start);
      if (newInterval == null) newInterval = new Interval(interval.start, interval.end);
      else newInterval = new Interval(interval.start, Math.max(newInterval.end, interval.end));
      map.put(interval.start, newInterval);
    }
    List<Interval> newIntervals = new ArrayList<>();
    for (Entry<Integer, Interval> interval : map.entrySet()) {
      if (newIntervals.size() == 0) newIntervals.add(interval.getValue());
      else if (newIntervals.get(newIntervals.size() - 1).end >= interval.getValue().start)
        newIntervals.get(newIntervals.size() - 1).end =
            Math.max(newIntervals.get(newIntervals.size() - 1).end, interval.getValue().end);
      else newIntervals.add(interval.getValue());
    }
    return newIntervals;
  }

  public static List<Interval> merge2(List<Interval> intervals) {
    if (intervals == null) return null;

    Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
    List<Interval> merged = new ArrayList<>();

    for (Interval current : intervals)
      if (merged.isEmpty() || merged.get(merged.size() - 1).end < current.start)
        merged.add(current);
      else
        merged.get(merged.size() - 1).end =
            Math.max(current.end, merged.get(merged.size() - 1).end);

    return merged;
  }

  public static void main(String[] args) {
    List<Interval> intervals = new ArrayList<>();
    intervals.add(new Interval(1, 3));
    intervals.add(new Interval(2, 6));
    intervals.add(new Interval(8, 10));
    intervals.add(new Interval(15, 18));
    List<Interval> merges = merge1(intervals);
    System.out.println(merges);
  }
}
