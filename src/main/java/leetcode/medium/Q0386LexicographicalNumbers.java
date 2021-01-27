package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/lexicographical-numbers/
public class Q0386LexicographicalNumbers {
  public List<Integer> lexicalOrder1(int n) {
    List<Integer> result = new ArrayList<>();
    for (int i = 1; i < 10; ++i) lexicalOrder1(i, n, result);
    return result;
  }

  public void lexicalOrder1(int cur, int n, List<Integer> res) {
    if (cur > n) return;
    res.add(cur);
    for (int i = 0; i < 10; ++i) {
      if (10 * cur + i > n) return;
      lexicalOrder1(10 * cur + i, n, res);
    }
  }

  public List<Integer> lexicalOrder2(int n) {
    List<Integer> result = new ArrayList<>(n);
    lexicalOrder2(1, 9, n, result);
    return result;
  }

  private void lexicalOrder2(int start, int end, int n, List<Integer> res) {
    for (int i = start; i <= end && i <= n; i++) {
      res.add(i);
      lexicalOrder2(i * 10, i * 10 + 9, n, res);
    }
  }

  public List<Integer> lexicalOrder3(int n) {
    List<Integer> result = new ArrayList<>(n);
    result.add(1);
    for (int i = 1, prev = 1; i < n; ++i) {
      if (prev * 10 <= n) prev *= 10;
      else {
        while (prev % 10 == 9 || prev == n) prev /= 10;
        prev++;
      }
      result.add(prev);
    }
    return result;
  }
}
