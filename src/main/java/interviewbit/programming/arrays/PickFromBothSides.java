package interviewbit.programming.arrays;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/pick-from-both-sides/
public class PickFromBothSides {
  public static int solve(ArrayList<Integer> A, int B) {
    int sum = 0;
    for (int i = 0; i < B; i++) sum += A.get(i);
    int currentMax = sum;
    int j = B - 1;
    for (int i = A.size() - 1; i >= A.size() - B; i--) {
      sum -= A.get(j);
      j--;
      sum += A.get(i);
      if (sum > currentMax) currentMax = sum;
    }
    return currentMax;
  }

  public static void main(String[] args) {}
}
