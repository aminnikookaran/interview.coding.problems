package leetcode.medium;

// https://leetcode.com/problems/wiggle-sort/
public class Q0280WiggleSort {
  public void wiggleSort1(int[] nums) {
    if (nums == null || nums.length <= 1) return;

    for (int i = 1; i < nums.length; i++) {
      if (i % 2 == 1) {
        if (nums[i] < nums[i - 1]) swap(nums, i - 1, i);
      } else {
        if (nums[i] > nums[i - 1]) swap(nums, i - 1, i);
      }
    }
  }

  public void wiggleSort2(int[] nums) {
    if (nums == null || nums.length <= 1) return;

    for (int i = 0; i < nums.length; i += 2) {
      if (i > 0 && nums[i] < nums[i - 1]) swap(nums, i - 1, i);
      if (i < nums.length - 1 && nums[i] < nums[i + 1]) swap(nums, i, i + 1);
    }
  }

  private void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }
}
