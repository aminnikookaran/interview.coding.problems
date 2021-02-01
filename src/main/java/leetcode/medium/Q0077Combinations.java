package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combinations/
public class Q0077Combinations {
  public List<List<Integer>> combine1(int n, int k) {
    List<List<Integer>> combs = new ArrayList<>();
    combine1(combs, new ArrayList<>(), 1, n, k);
    return combs;
  }

  public void combine1(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
    if (k == 0) combs.add(new ArrayList<>(comb));
    else
      for (int i = start; i <= n - k + 1; i++) {
        comb.add(i);
        combine1(combs, comb, i + 1, n, k - 1);
        comb.remove(comb.size() - 1);
      }
  }

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    if (k > n || k == 0) return result;
    result = combine(n - 1, k - 1);
    if (result.isEmpty()) result.add(new ArrayList<>());
    for (List<Integer> list : result) list.add(n);
    result.addAll(combine(n - 1, k));
    return result;
  }
}
