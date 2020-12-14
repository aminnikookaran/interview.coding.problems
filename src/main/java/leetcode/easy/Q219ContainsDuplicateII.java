package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/contains-duplicate-ii/
public class Q219ContainsDuplicateII {
  public boolean containsNearbyDuplicate1(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      Integer index = map.get(nums[i]);
      if (index != null && i - index <= k) return true;
      map.put(nums[i], i);
    }
    return false;
  }

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    if (nums == null || nums.length < 2 || k == 0) return false;
    Set<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (!set.add(nums[i])) return true;
      if (i >= k) set.remove(nums[i - k]);
    }
    return false;
  }
}
