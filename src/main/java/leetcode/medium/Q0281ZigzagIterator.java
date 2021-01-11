package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

// https://leetcode.com/problems/zigzag-iterator/
public class Q0281ZigzagIterator {
  public class ZigzagIterator {
    Deque<Iterator<Integer>> deque;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
      deque = new ArrayDeque<>();
      if (!v1.isEmpty()) deque.add(v1.iterator());
      if (!v2.isEmpty()) deque.add(v2.iterator());
    }

    public int next() {
      Iterator<Integer> iter = deque.poll();
      int ret = iter.next();
      if (iter.hasNext()) deque.add(iter);
      return ret;
    }

    public boolean hasNext() {
      return !deque.isEmpty();
    }
  }
}
