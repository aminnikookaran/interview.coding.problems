package hackerrank.algorithms.greedy;

import java.util.Arrays;

// https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=greedy-algorithms
public class MinimumAbsoluteDifferenceInAnArray {
  public static int minimumAbsoluteDifference(int[] arr) {
    if (arr == null || arr.length < 2) return 0;
    int n = arr.length;
    int min = Integer.MAX_VALUE;
    Arrays.sort(arr);
    for (int i = 1; i < n; i++) {
      min = Math.min(min, Math.abs(arr[i] - arr[i - 1]));
      if (min == 0) return 0;
    }
    return min;
  }
}
