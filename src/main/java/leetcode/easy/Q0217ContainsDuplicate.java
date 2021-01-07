package leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/contains-duplicate/
public class Q0217ContainsDuplicate {
  public boolean containsDuplicate1(int[] nums) {
    if (nums == null) return false;
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) return true;
      set.add(nums[i]);
    }
    return false;
  }

  public boolean containsDuplicate2(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; ++i) if (nums[i] == nums[i + 1]) return true;
    return false;
  }
}
