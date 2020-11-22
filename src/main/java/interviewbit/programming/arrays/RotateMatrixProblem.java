package interviewbit.programming.arrays;

import java.util.Collections;
import java.util.List;

// https://www.interviewbit.com/problems/rotate-matrix/
public class RotateMatrixProblem {
  public void rotate1(List<List<Integer>> a) {
    int n = a.size();
    for (int i = 0; i < n / 2; i++) {
      for (int j = i; j < n - 1 - i; j++) {
        int lastNumber = a.get(i).get(j);
        a.get(i).set(j, a.get(n - 1 - j).get(i));
        a.get(n - 1 - j).set(i, a.get(n - 1 - i).get(n - 1 - j));
        a.get(n - 1 - i).set(n - 1 - j, a.get(j).get(n - 1 - i));
        a.get(j).set(n - 1 - i, lastNumber);
      }
    }
  }

  public void rotate2(List<List<Integer>> a) {
    int n = a.size();
    for (int i = 0; i < n / 2; i++) {
      for (int j = 0; j < n; j++) {
        int lastNumber = a.get(i).get(j);
        a.get(i).set(j, a.get(n - 1 - i).get(j));
        a.get(n - 1 - i).set(j, lastNumber);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int lastNumber = a.get(i).get(j);
        a.get(i).set(j, a.get(j).get(i));
        a.get(j).set(i, lastNumber);
      }
    }
  }

  public void rotate3(List<List<Integer>> a) {
    int n = a.size();
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int lastNumber = a.get(i).get(j);
        a.get(i).set(j, a.get(j).get(i));
        a.get(j).set(i, lastNumber);
      }
    }

    for (int i = 0; i < n; i++) Collections.reverse(a.get(i));
  }
}
