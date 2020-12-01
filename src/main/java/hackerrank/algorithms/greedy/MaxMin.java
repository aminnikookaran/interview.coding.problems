package hackerrank.algorithms.greedy;

import java.util.Arrays;

// https://www.hackerrank.com/challenges/angry-children/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=greedy-algorithms
public class MaxMin {
  public static int maxMin(int k, int[] arr) {
    Arrays.sort(arr);
    int n = arr.length;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i <= n - k; i++) min = Math.min(min, arr[i + k - 1] - arr[i]);
    return min;
  }
}
