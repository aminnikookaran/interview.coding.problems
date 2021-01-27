package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import leetcode.NestedInteger;

// https://leetcode.com/problems/nested-list-weight-sum-ii/
public class Q0364NestedListWeightSumII {
  public int depthSumInverse1(List<NestedInteger> nestedList) {
    if (nestedList == null || nestedList.size() == 0) return 0;
    Map<Integer, List<Integer>> map = new HashMap<>();
    // two stacks: one is for processing nested integer, the other is for tracking layers.
    Stack<NestedInteger> stack = new Stack<>();
    Stack<Integer> layers = new Stack<>();
    // put all NestedIntegers to Stack and record its layer to be 1
    for (NestedInteger ni : nestedList) {
      stack.push(ni);
      layers.push(1);
    }
    int maxLayer = Integer.MIN_VALUE;
    while (!stack.isEmpty()) {
      NestedInteger top = stack.pop();
      int topLayer = layers.pop();
      maxLayer = Math.max(maxLayer, topLayer);
      if (top.isInteger()) {
        if (!map.containsKey(topLayer)) map.put(topLayer, new ArrayList<>());
        map.get(topLayer).add(top.getInteger());
      } else {
        for (NestedInteger ni : top.getList()) {
          stack.push(ni);
          layers.push(topLayer + 1);
        }
      }
    }
    // Calculate sum
    int result = 0;
    for (int i = maxLayer; i >= 1; i--)
      if (map.get(i) != null) for (int v : map.get(i)) result += v * (maxLayer - i + 1);

    return result;
  }

  public int depthSumInverse2(List<NestedInteger> nestedList) {
    int height = getHeight(nestedList);
    return ds(nestedList, height);
  }

  private int getHeight(List<NestedInteger> nestedList) {
    int height = 1;
    for (NestedInteger ni : nestedList) {
      if (!ni.isInteger()) {
        int tmp = getHeight(ni.getList());
        height = Math.max(height, tmp + 1);
      }
    }
    return height;
  }

  private int ds(List<NestedInteger> nestedList, int level) {
    int sum = 0;
    for (NestedInteger ni : nestedList)
      if (ni.isInteger()) sum += level * ni.getInteger();
      else sum += ds(ni.getList(), level - 1);
    return sum;
  }

  public int depthSumInverse3(List<NestedInteger> nestedList) {
    Deque<List<NestedInteger>> q = new ArrayDeque<>();
    q.add(nestedList);
    Stack<Integer> stack = new Stack<>();
    while (!q.isEmpty()) {
      int size = q.size();
      int sum = 0;
      for (int i = 0; i < size; i++) {
        List<NestedInteger> node = q.poll();
        for (NestedInteger ni : node)
          if (ni.isInteger()) sum += ni.getInteger();
          else q.add(ni.getList());
      }
      stack.push(sum);
    }
    int level = 1;
    int res = 0;
    while (!stack.isEmpty()) {
      res += level * stack.pop();
      level++;
    }
    return res;
  }

  public int depthSumInverse4(List<NestedInteger> nestedList) {
    int unweighted = 0, weighted = 0;
    while (!nestedList.isEmpty()) {
      List<NestedInteger> newList = new ArrayList<>();
      for (NestedInteger ni : nestedList)
        if (ni.isInteger()) unweighted += ni.getInteger();
        else newList.addAll(ni.getList());
      weighted += unweighted;
      nestedList = newList;
    }
    return weighted;
  }
}
