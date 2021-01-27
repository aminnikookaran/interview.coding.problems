package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import leetcode.NestedInteger;

// https://leetcode.com/problems/nested-list-weight-sum/
public class Q0339NestedListWeightSum {
  public int depthSum1(List<NestedInteger> nestedList) {
    return depthSum1(nestedList, 1);
  }

  public int depthSum1(List<NestedInteger> nestedList, int depth) {
    if (nestedList == null || nestedList.size() == 0) return 0;
    int sum = 0;
    for (NestedInteger ni : nestedList)
      if (ni.isInteger()) sum += ni.getInteger() * depth;
      else sum += depthSum1(ni.getList(), depth + 1);
    return sum;
  }

  public int depthSum2(List<NestedInteger> nestedList) {
    int sum = 0;
    Deque<NestedInteger> queue = new ArrayDeque<>();
    Deque<Integer> depth = new ArrayDeque<>();
    for (NestedInteger ni : nestedList) {
      queue.offer(ni);
      depth.offer(1);
    }
    while (!queue.isEmpty()) {
      NestedInteger top = queue.poll();
      int dep = depth.poll();
      if (top.isInteger()) sum += dep * top.getInteger();
      else
        for (NestedInteger ni : top.getList()) {
          queue.offer(ni);
          depth.offer(dep + 1);
        }
    }
    return sum;
  }
}
