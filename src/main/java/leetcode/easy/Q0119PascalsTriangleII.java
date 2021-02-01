package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle-ii/
public class Q0119PascalsTriangleII {
  public List<Integer> getRow1(int rowIndex) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i <= rowIndex; i++) {
      List<Integer> temp = new ArrayList<>();
      temp.add(1);
      for (int j = 0; j < i - 1; j++) temp.add(result.get(j) + result.get(j + 1));
      if (rowIndex > 0) temp.add(1);
      result = temp;
    }
    return result;
  }

  public List<Integer> getRow(int rowIndex) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i <= rowIndex; i++) {
      for (int j = i - 1; j >= 1; j--) result.set(j, result.get(j) + result.get(j - 1));
      result.add(1);
    }
    return result;
  }
}
