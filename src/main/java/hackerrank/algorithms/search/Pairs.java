package hackerrank.algorithms.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://www.hackerrank.com/challenges/pairs/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=search
public class Pairs {
  public static int pairs1(int k, int[] arr) {
    long kl = k;
    int sum = 0;
    Set<Long> set = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      long num = arr[i];
      if (set.contains(num + kl)) sum++;
      if (set.contains(num - kl)) sum++;
      set.add(num);
    }
    return sum;
  }

  public static int pairs2(int k, int[] arr) {
    Arrays.sort(arr);
    int i = 0, j = 1, n = arr.length, count = 0;
    while (j < n) {
      int diff = arr[j] - arr[i];
      if (diff == k) {
        count++;
        j++;
      } else if (diff > k) i++;
      else if (diff < k) j++;
    }
    return count;
  }
}
