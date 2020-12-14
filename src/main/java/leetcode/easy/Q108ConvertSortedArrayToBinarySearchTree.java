package leetcode.easy;

import leetcode.TreeNode;

public class Q108ConvertSortedArrayToBinarySearchTree {
  public TreeNode sortedArrayToBST(int[] nums) {
    return sortedArrayToBST(nums, 0, nums.length - 1);
  }

  public TreeNode sortedArrayToBST(int[] nums, int low, int high) {
    if (low > high) return null;
    int mid = (low + high) / 2;
    return new TreeNode(
        nums[mid], sortedArrayToBST(nums, low, mid - 1), sortedArrayToBST(nums, mid + 1, high));
  }
}
