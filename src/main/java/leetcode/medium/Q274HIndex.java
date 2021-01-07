package leetcode.medium;

import java.util.Arrays;

// https://leetcode.com/problems/h-index/
public class Q274HIndex {
  public int hIndex1(int[] citations) {
    int n = citations.length;
    int[] buckets = new int[n + 1];
    for (int c : citations) buckets[Math.min(c, n)]++;
    int count = 0;
    for (int i = n; i >= 0; i--) {
      count += buckets[i];
      if (count >= i) return i;
    }
    return 0;
  }

  public int hIndex2(int[] citations) {
    Arrays.sort(citations);
    for (int i = 1; i <= citations.length; i++)
      if (citations[citations.length - i] < i) return i - 1;
    return citations.length;
  }
}
