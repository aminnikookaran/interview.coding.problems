package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/design-hit-counter/
public class Q0362DesignHitCounter {
  public class HitCounter1 {
    Queue<Integer> hits;
    /** Initialize your data structure here. */
    public HitCounter1() {
      hits = new LinkedList<Integer>();
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
      hits.add(timestamp);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
      while (hits.size() > 0 && hits.peek() <= timestamp - 300) hits.poll();
      return hits.size();
    }
  }

  public class HitCounter2 {
    int[] ts;
    int[] hits;
    /** Initialize your data structure here. */
    public HitCounter2() {
      ts = new int[300];
      hits = new int[300];
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
      int i = timestamp % 300;
      if (ts[i] != timestamp) {
        ts[i] = timestamp;
        hits[i] = 1;
      } else hits[i]++;
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
      int result = 0;
      for (int i = 0; i < hits.length; i++) if (timestamp - ts[i] < 300) result += hits[i];
      return result;
    }
  }
}
