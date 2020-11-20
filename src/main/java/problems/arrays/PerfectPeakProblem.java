package problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectPeakProblem {
  public static long solve1(List<Integer> a) {
    if (a.size() < 3) return 0;
    int candidate = a.get(0);
    int currentMax = candidate;
    boolean found = false;
    for (int i = 1; i < a.size(); i++) {
      if (!found && a.get(i) > currentMax && i < a.size() - 1) {
        candidate = a.get(i);
        found = true;
      } else if (found && a.get(i) <= candidate) {
        found = false;
      }
      if (a.get(i) > currentMax) currentMax = a.get(i);
    }
    if (found) return 1;
    return 0;
  }

  public static long solve2(List<Integer> A) {
    List<Integer> maxs = new ArrayList<Integer>(A.size());
    List<Integer> mins = new ArrayList<Integer>(A.size());
    int max = A.get(0);
    int min = A.get(A.size() - 1);
    for (int i = 0; i < A.size(); i++) {
      max = Math.max(A.get(i), max);
      maxs.add(max);
      min = Math.min(A.get(A.size() - i - 1), min);
      mins.add(0, min);
    }
    for (int i = 1; i < A.size() - 1; i++) {
      if (maxs.get(i - 1) < A.get(i) && A.get(i) < mins.get(i + 1)) return 1;
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(solve1(Arrays.asList(new Integer[] {5, 1, 4, 3, 6, 8, 10, 7, 9})));
  }
}
