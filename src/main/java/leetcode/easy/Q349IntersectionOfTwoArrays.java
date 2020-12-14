package leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/intersection-of-two-arrays/
public class Q349IntersectionOfTwoArrays {
  public int[] intersection1(int[] nums1, int[] nums2) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums1.length; i++) set.add(nums1[i]);
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < nums2.length; i++)
      if (set.contains(nums2[i])) {
        set.remove(nums2[i]);
        list.add(nums2[i]);
      }
    int[] result = new int[list.size()];
    for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
    return result;
  }

  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set1 = new HashSet<>();
    for (Integer n : nums1) set1.add(n);
    Set<Integer> set2 = new HashSet<>();
    for (Integer n : nums2) set2.add(n);
    set1.retainAll(set2);
    int[] output = new int[set1.size()];
    int idx = 0;
    for (int s : set1) output[idx++] = s;
    return output;
  }
}
