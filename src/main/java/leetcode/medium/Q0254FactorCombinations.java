package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/factor-combinations/
public class Q0254FactorCombinations {
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> result = new ArrayList<>();
    getFactors(2, 1, n, result, new ArrayList<>());
    return result;
  }

  public void getFactors(
      int start, int product, int n, List<List<Integer>> result, List<Integer> curr) {
    if (start > n || product > n) return;
    if (product == n) result.add(new ArrayList<>(curr));
    else
      for (int i = start; i < n; i++) {
        if (i * product > n) break;
        if (n % i == 0) {
          curr.add(i);
          getFactors(i, i * product, n, result, curr);
          curr.remove(curr.size() - 1);
        }
      }
  }
}
