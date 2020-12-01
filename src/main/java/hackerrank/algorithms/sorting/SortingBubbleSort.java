package hackerrank.algorithms.sorting;

import static java.lang.System.out;

// https://www.hackerrank.com/challenges/ctci-bubble-sort/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=sorting
public class SortingBubbleSort {
  static void countSwaps(int[] a) {
    int n = a.length;
    int swaps = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - 1; j++) {
        if (a[j] > a[j + 1]) {
          a[j] += a[j + 1];
          a[j + 1] = a[j] - a[j + 1];
          a[j] -= a[j + 1];
          swaps++;
        }
      }
    }
    out.println("Array is sorted in " + swaps + " swaps.");
    out.println("First Element: " + a[0]);
    out.println("Last Element: " + a[n - 1]);    
  }
}
