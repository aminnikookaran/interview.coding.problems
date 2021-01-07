package leetcode.medium;

// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
public class Q0081SearchInRotatedSortedArrayII {
  public boolean search(int[] nums, int target) {
    int start = 0, end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target) return true;
      if (nums[start] < nums[mid] || nums[mid] > nums[end]) {
        if (target < nums[mid] && target >= nums[start]) end = mid - 1;
        else start = mid + 1;
      } else if (nums[mid] < nums[end] || nums[start] > nums[mid]) {
        if (target > nums[mid] && target <= nums[end]) start = mid + 1;
        else end = mid - 1;
      } else {
        start++;
      }
    }
    return false;
  }
}
