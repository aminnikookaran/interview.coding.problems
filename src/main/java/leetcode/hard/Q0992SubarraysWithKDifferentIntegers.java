package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarrays-with-k-different-integers/
public class Q0992SubarraysWithKDifferentIntegers {
  public int subarraysWithKDistinct(int[] A, int K) {
    int left1 = 0, left2 = 0, right = 0, count = 0;
    Map<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
    while (right < A.length) {
      map1.put(A[right], map1.getOrDefault(A[right], 0) + 1);
      map2.put(A[right], map2.getOrDefault(A[right], 0) + 1);

      while (map1.size() > K) {
        Integer c = map1.get(A[left1]);
        if (c == 1) map1.remove(A[left1]);
        else map1.put(A[left1], c - 1);
        left1++;
      }

      while (map2.size() >= K) {
        Integer c = map2.get(A[left2]);
        if (c == 1) map2.remove(A[left2]);
        else map2.put(A[left2], c - 1);
        left2++;
      }

      if (map1.size() == K && map2.size() == K - 1) count += left2 - left1;

      right++;
    }
    return count;
  }
}
