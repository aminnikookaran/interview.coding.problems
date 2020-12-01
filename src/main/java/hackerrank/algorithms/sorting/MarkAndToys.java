package hackerrank.algorithms.sorting;

import java.util.Arrays;

// https://www.hackerrank.com/challenges/mark-and-toys/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=sorting
public class MarkAndToys {
  static int maximumToys(int[] prices, int k) {
    Arrays.sort(prices);
    int count = 0;
    for (int i = 0; i < prices.length; i++) {
      if (k - prices[i] >= 0) {
        k -= prices[i];
        count++;
      } else break;
    }
    return count;
  }
}
