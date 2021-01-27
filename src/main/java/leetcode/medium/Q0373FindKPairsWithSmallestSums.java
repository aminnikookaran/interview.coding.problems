package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
public class Q0373FindKPairsWithSmallestSums {
  public List<int[]> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
    List<int[]> result = new ArrayList<>();
    if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0)
      return result;

    PriorityQueue<int[]> queue =
        new PriorityQueue<>(k, (a, b) -> Integer.compare(a[0] + a[1], b[0] + b[1]));
    for (int i = 0; i < nums1.length && i < k; i++) queue.add(new int[] {nums1[i], nums2[0], 0});
    while (k-- > 0 && !queue.isEmpty()) {
      int[] cur = queue.poll();
      result.add(new int[] {cur[0], cur[1]});
      if (cur[2] == nums2.length - 1) continue;
      queue.add(new int[] {cur[0], nums2[cur[2] + 1], cur[2] + 1});
    }
    return result;
  }

  public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
    List<int[]> result = new ArrayList<>();
    if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0)
      return result;

    PriorityQueue<Pair> queue = new PriorityQueue<>(k, (a, b) -> Long.compare(a.sum, b.sum));
    for (int i = 0; i < nums1.length && i < k; i++) queue.add(new Pair(0, nums1[i], nums2[0]));
    for (int i = 1; i <= k && !queue.isEmpty(); i++) {
      Pair p = queue.poll();
      result.add(p.pair);
      if (p.idx < nums2.length - 1) {
        int next = p.idx + 1;
        queue.add(new Pair(next, p.pair[0], nums2[next]));
      }
    }
    return result;
  }

  class Pair {
    int[] pair;
    int idx;
    long sum;

    Pair(int idx, int n1, int n2) {
      this.idx = idx;
      pair = new int[] {n1, n2};
      sum = (long) n1 + (long) n2;
    }
  }

  public List<int[]> kSmallestPairs3(int[] nums1, int[] nums2, int k) {
    List<int[]> result = new ArrayList<>();
    if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0)
      return result;

    // index2 is used for recording position in nums2 corresponding to given position in nums1
    int[] index2 = new int[nums1.length];
    while (k-- > 0) {
      int min = Integer.MAX_VALUE;
      // every time we should start from the first place in nums2 to find proper position
      int index = -1;
      for (int index1 = 0; index1 < nums1.length; index1++) {
        if (index2[index1] >= nums2.length) continue;

        if (nums1[index1] + nums2[index2[index1]] < min) {
          min = nums1[index1] + nums2[index2[index1]];
          // keep record the index in nums1
          index = index1;
        }
      }
      if (index == -1) break;

      int[] temp = {nums1[index], nums2[index2[index]]};
      result.add(temp);
      index2[index]++;
    }
    return result;
  }
}
