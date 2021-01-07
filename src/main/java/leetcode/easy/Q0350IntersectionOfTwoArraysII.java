package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/intersection-of-two-arrays-ii/
public class Q0350IntersectionOfTwoArraysII {
  public int[] intersect1(int[] nums1, int[] nums2) {
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums1.length; i++) map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
    for (int i = 0; i < nums2.length; i++) {
      Integer count = map.get(nums2[i]);
      if (count != null) {
        list.add(nums2[i]);
        if (count == 1) map.remove(nums2[i]);
        else map.put(nums2[i], count - 1);
      }
    }
    int[] array = new int[list.size()];
    for (int i = 0; i < list.size(); i++) array[i] = list.get(i);
    return array;
  }

  public int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    List<Integer> list = new ArrayList<Integer>();
    int p1 = 0, p2 = 0;
    while (p1 < nums1.length && p2 < nums2.length) {
      if (nums1[p1] < nums2[p2]) p1++;
      else if (nums1[p1] > nums2[p2]) p2++;
      else {
        list.add(nums1[p1]);
        p1++;
        p2++;
      }
    }
    int[] result = new int[list.size()];
    int i = 0;
    while (i < list.size()) {
      result[i] = list.get(i);
      i++;
    }
    return result;
  }
}
