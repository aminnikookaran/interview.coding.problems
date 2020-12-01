package hackerrank.algorithms.greedy;

import java.util.Arrays;

// https://www.hackerrank.com/challenges/greedy-florist/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=greedy-algorithms
public class GreedyFlorist {
  public static int getMinimumCost(int k, int[] c) {
    Arrays.sort(c);
    int n = c.length;
    int sum = 0;
    for (int i = 0; i < n; i++) sum += (i / k + 1) * c[n - 1 - i];
    return sum;
  }
}
