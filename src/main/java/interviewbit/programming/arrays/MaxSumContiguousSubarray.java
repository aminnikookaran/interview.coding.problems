package interviewbit.programming.arrays;

import java.util.List;

// https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
public class MaxSumContiguousSubarray {
  public static int maxSubArray1(final List<Integer> A) {
    int sum = A.get(0);
    int max = sum;
    for (int i = 1; i < A.size(); i++) {
      sum += A.get(i);
      if (A.get(i) > sum) sum = A.get(i);
      if (sum > max) max = sum;
    }
    return max;
  }

  public static int maxSubArray2(final List<Integer> A) {
    int maxEndingHere = A.get(0);
    int maxSoFar = A.get(0);
    for (int i = 1; i < A.size(); i++) {
      maxEndingHere = Math.max(A.get(i), A.get(i) + maxEndingHere);
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
  }

  public static void main(String[] args) {}
}
