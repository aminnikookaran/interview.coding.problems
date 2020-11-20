package problems.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleProblem {
  public static List<List<Integer>> solve(int A) {
    List<List<Integer>> B = new ArrayList<>();
    if (A < 1) return B;
    List<Integer> current = new ArrayList<>();
    current.add(1);
    B.add(current);
    for (int i = 1; i < A; i++) {
      current = new ArrayList<>();
      current.add(1);
      for (int j = 0; j < i - 1; j++) {
        current.add(B.get(i - 1).get(j) + B.get(i - 1).get(j + 1));
      }
      current.add(1);
      B.add(current);
    }
    return B;
  }

  public static void main(String[] args) {
    System.out.println(solve(10));
  }
}
