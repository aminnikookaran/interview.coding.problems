package leetcode.medium;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class Q0033SearchInRotatedSortedArray {
  public int search1(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) return mid;
      if (nums[mid] <= nums[right]) {
        if (target > nums[mid] && target <= nums[right]) left = mid + 1;
        else right = mid - 1;
      } else {
        if (target < nums[mid] && target >= nums[left]) right = mid - 1;
        else left = mid + 1;
      }
    }
    return -1;
  }

  public int search2(int[] nums, int target) {
    return binarySearch(nums, 0, nums.length - 1, target);
  }

  public int binarySearch(int[] nums, int left, int right, int target) {
    if (left > right) return -1;
    int mid = left + (right - left) / 2;
    if (target == nums[mid]) return mid;
    if (nums[left] <= nums[mid]) {
      if (nums[left] <= target && target < nums[mid])
        return binarySearch(nums, left, mid - 1, target);
      else return binarySearch(nums, mid + 1, right, target);
    } else {
      if (nums[mid] < target && target <= nums[right])
        return binarySearch(nums, mid + 1, right, target);
      else return binarySearch(nums, left, mid - 1, target);
    }
  }
}
