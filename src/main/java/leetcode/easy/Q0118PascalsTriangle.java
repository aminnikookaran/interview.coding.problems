package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/
public class Q0118PascalsTriangle {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> lists = new ArrayList<>();
    if (numRows < 1) return lists;
    lists.add(new ArrayList<>());
    lists.get(0).add(1);
    for (int i = 1; i < numRows; i++) {
      List<Integer> list = new ArrayList<>();
      list.add(1);
      for (int j = 1; j < i; j++) list.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
      list.add(1);
      lists.add(list);
    }
    return lists;
  }
}
