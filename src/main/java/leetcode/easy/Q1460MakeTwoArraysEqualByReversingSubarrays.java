package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
public class Q1460MakeTwoArraysEqualByReversingSubarrays {
  public boolean canBeEqual1(int[] target, int[] arr) {
    if (arr == null && target == null) return true;
    if (arr == null || target == null) return false;
    if (arr.length != target.length) return false;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    for (int i = 0; i < target.length; i++) {
      Integer count = map.get(target[i]);
      if (count == null) return false;
      else if (count == 1) map.remove(target[i]);
      else map.put(target[i], count - 1);
    }
    return map.isEmpty();
  }

  public boolean canBeEqual2(int[] target, int[] arr) {
    if (arr == null && target == null) return true;
    if (arr == null || target == null) return false;
    if (arr.length != target.length) return false;
    Arrays.sort(arr);
    Arrays.sort(target);
    for (int i = 0; i < arr.length; i++) if (arr[i] != target[i]) return false;
    return true;
  }
}
