package hackerrank.algorithms.search;

import java.util.TreeSet;

// https://www.hackerrank.com/challenges/maximum-subarray-sum/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=search
public class MaximumSubarraySum {
  public static long maximumSum(long[] a, long m) {
    TreeSet<Long> tree = new TreeSet<>();
    long max = a[0] % m;
    tree.add(a[0] % m);
    for (int i = 1; i < a.length; i++) {
      a[i] = (a[i] + a[i - 1]) % m;
      Long remainder = tree.higher(a[i]);
      if (remainder == null) max = Math.max(max, a[i]);
      else max = Math.max(max, (a[i] - remainder + m) % m);
      tree.add(a[i]);
    }
    return max;
  }
}
