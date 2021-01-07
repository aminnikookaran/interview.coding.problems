package leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/find-the-duplicate-number/
public class Q0287FindTheDuplicateNumber {
  public int findDuplicate1(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++)
      if (set.contains(nums[i])) return nums[i];
      else set.add(nums[i]);
    return -1;
  }

  public int findDuplicate2(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) if (nums[i] == nums[i - 1]) return nums[i];
    return -1;
  }

  public int findDuplicate3(int[] nums) {
    // Find the intersection point of the two runners.
    int tortoise = nums[0];
    int hare = nums[0];
    do {
      tortoise = nums[tortoise];
      hare = nums[nums[hare]];
    } while (tortoise != hare);

    // Find the "entrance" to the cycle.
    tortoise = nums[0];
    while (tortoise != hare) {
      tortoise = nums[tortoise];
      hare = nums[hare];
    }

    return hare;
  }
}
