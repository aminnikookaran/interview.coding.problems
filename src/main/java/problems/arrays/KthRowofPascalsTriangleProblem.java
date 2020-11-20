package problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthRowofPascalsTriangleProblem {
  public static List<Integer> solve1(int a) {
    List<Integer> pre = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    if (a < 0) return cur;
    cur.add(1);
    for (int i = 0; i < a; i++) {
      pre = cur;
      cur = new ArrayList<>();
      cur.add(1);
      for (int j = 0; j < i; j++) cur.add(pre.get(j) + pre.get(j + 1));
      cur.add(1);
    }
    return cur;
  }

  public static List<Integer> solve2(int rowIndex) {
    Integer[] result = new Integer[rowIndex + 1];
    Arrays.fill(result, 0);
    result[0] = 1;
    for (int i = 1; i < rowIndex + 1; i++) for (int j = i; j >= 1; j--) result[j] += result[j - 1];
    return Arrays.asList(result);
  }

  public static List<Integer> solve3(int a) {
    List<Integer> res = new ArrayList<Integer>();
    res.add(1);
    for (int i = 1; i <= a; i++) {
      int num = (a + 1 - i) * res.get(i - 1) / i;
      res.add(num);
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(solve1(4));
  }
}
