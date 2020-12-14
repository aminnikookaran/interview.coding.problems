package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/4sum-ii/
public class Q4544SumII {
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < B.length; j++) {
        int sum = A[i] + B[j];
        map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
    }

    int count = 0;
    for (int i = 0; i < C.length; i++) {
      for (int j = 0; j < D.length; j++) {
        int sum = C[i] + D[j];
        count += map.getOrDefault(-sum, 0);
      }
    }
    return count;
  }
}
