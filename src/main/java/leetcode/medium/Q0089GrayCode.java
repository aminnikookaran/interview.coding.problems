package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/gray-code/
public class Q0089GrayCode {
  public List<Integer> grayCode(int n) {
    List<Integer> arr = new ArrayList<>();
    arr.add(0);
    for (int i = 0; i < n; i++) {
      int inc = 1 << i;
      for (int j = arr.size() - 1; j >= 0; j--) arr.add(arr.get(j) + inc);
    }
    return arr;
  }
}
