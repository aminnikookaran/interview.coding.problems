package hackerrank.algorithms.sorting;

import java.util.Arrays;

// https://www.hackerrank.com/challenges/ctci-merge-sort/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=sorting
public class MergeSortCountingInversions {
  public static long countInversions(int[] arr) {
    return mergeSort(arr, 0, arr.length - 1);
  }

  public static long mergeSort(int[] arr, int l, int h) {
    if (l == h) return 0l;
    int m = l + (h - l) / 2;
    long swaps = mergeSort(arr, l, m) + mergeSort(arr, m + 1, h);
    int length1 = m - l + 1;
    int[] first = new int[length1];
    for (int i = l; i <= m; i++) first[i - l] = arr[i];
    int length2 = h - m;
    int[] second = new int[length2];
    for (int i = m + 1; i <= h; i++) second[i - m - 1] = arr[i];
    int i = 0, j = 0, k = l;
    while (i < length1 && j < length2) {
      if (first[i] <= second[j]) arr[k++] = first[i++];
      else {
        arr[k++] = second[j++];
        swaps += length1 - i;
      }
    }
    while (i < length1) arr[k++] = first[i++];
    while (j < length2) arr[k++] = second[j++];
    return swaps;
  }

  public static long getInvCount(int[] arr) {
    long inv_count = 0;
    for (int i = 0; i < arr.length - 1; i++)
      for (int j = i + 1; j < arr.length; j++) if (arr[i] > arr[j]) inv_count++;
    return inv_count;
  }

  public static long mergeAndCount(int[] arr, int l, int m, int r) {
    int[] left = Arrays.copyOfRange(arr, l, m + 1);
    int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
    int i = 0, j = 0, k = l;
    long swaps = 0;
    while (i < left.length && j < right.length) {
      if (left[i] <= right[j]) arr[k++] = left[i++];
      else {
        arr[k++] = right[j++];
        swaps += (m + 1) - (l + i);
      }
    }
    while (i < left.length) arr[k++] = left[i++];
    while (j < right.length) arr[k++] = right[j++];
    return swaps;
  }

  public static long mergeSortAndCount(int[] arr, int l, int r) {
    long count = 0;
    if (l < r) {
      int m = (l + r) / 2;
      count += mergeSortAndCount(arr, l, m);
      count += mergeSortAndCount(arr, m + 1, r);
      count += mergeAndCount(arr, l, m, r);
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(countInversions(new int[] {2, 1, 3, 1, 2}));
    System.out.println(mergeSortAndCount(new int[] {2, 1, 3, 1, 2}, 0, 4));
    System.out.println(getInvCount(new int[] {2, 1, 3, 1, 2}));
  }
}
