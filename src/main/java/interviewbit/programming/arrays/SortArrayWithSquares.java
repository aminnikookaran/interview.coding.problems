package interviewbit.programming.arrays;

import java.util.ArrayList;
import java.util.List;

// https://www.interviewbit.com/problems/sort-array-with-squares/
public class SortArrayWithSquares {
  public static List<Integer> solve(List<Integer> A) {
    List<Integer> B = new ArrayList<>();
    for (int i = 0; i < A.size(); i++) B.add(0);
    int j = 0;
    int k = A.size() - 1;
    for (int i = B.size() - 1; i >= 0; i--) {
      if (A.get(j) * A.get(j) >= A.get(k) * A.get(k)) {
        B.set(i, A.get(j) * A.get(j));
        j++;
      } else {
        B.set(i, A.get(k) * A.get(k));
        k--;
      }
    }
    return B;
  }

  public static void main(String[] args) {}
}
