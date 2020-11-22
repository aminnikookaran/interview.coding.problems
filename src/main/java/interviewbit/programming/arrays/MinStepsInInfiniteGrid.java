package interviewbit.programming.arrays;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
public class MinStepsInInfiniteGrid {
  public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
    if (A.size() != B.size()) return 0;
    int steps = 0;
    for (int i = 1; i < A.size(); i++) {
      steps += Math.max(Math.abs(A.get(i) - A.get(i - 1)), Math.abs(B.get(i) - B.get(i - 1)));
    }
    return steps;
  }

  public static void main(String[] args) {}
}
