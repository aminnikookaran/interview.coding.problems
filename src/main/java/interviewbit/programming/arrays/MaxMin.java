package interviewbit.programming.arrays;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/max-min-05542f2f-69aa-4253-9cc7-84eb7bf739c4/
public class MaxMin {
  public static int solve(ArrayList<Integer> A) {
    int min = Integer.MAX_VALUE;
    int max = 0;
    for (int i = 0; i < A.size(); i++) {
      if (A.get(i) > max) max = A.get(i);
      if (A.get(i) < min) min = A.get(i);
    }
    return min + max;
  }

  public static void main(String[] args) {}
}
