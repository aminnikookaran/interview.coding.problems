package leetcode.easy;

// https://leetcode.com/problems/search-insert-position/
public class Q0035SearchInsertPosition {
  public int searchInsert(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) return mid;
      else if (nums[mid] > target) right = mid - 1;
      else left = mid + 1;
    }
    return left;
  }
}