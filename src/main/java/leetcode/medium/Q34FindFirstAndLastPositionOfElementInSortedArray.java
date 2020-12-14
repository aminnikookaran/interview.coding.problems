package leetcode.medium;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class Q34FindFirstAndLastPositionOfElementInSortedArray {
  public int[] searchRange1(int[] nums, int target) {
    int i = 0, j = nums.length - 1;
    while (i < j) {
      int mid = (i + j) / 2;
      if (nums[mid] > target) j = mid - 1;
      else if (nums[mid] < target) i = mid + 1;
      else j = mid;
    }
    if (j < 0 || nums[j] != target) return new int[] {-1, -1};
    int start = j;

    i = 0;
    j = nums.length - 1;
    while (i < j) {
      int mid = (i + j + 1) / 2;
      if (nums[mid] > target) j = mid - 1;
      else if (nums[mid] < target) i = mid + 1;
      else i = mid;
    }
    int end = i;

    return new int[] {start, end};
  }

  // returns leftmost (or rightmost) index at which `target` should be
  // inserted in sorted array `nums` via binary search.
  private int extremeInsertionIndex(int[] nums, int target, boolean left) {
    int lo = 0;
    int hi = nums.length;

    while (lo < hi) {
      int mid = (lo + hi) / 2;
      if (nums[mid] > target || (left && target == nums[mid])) hi = mid;
      else lo = mid + 1;
    }

    return lo;
  }

  public int[] searchRange2(int[] nums, int target) {
    int[] targetRange = {-1, -1};

    int leftIdx = extremeInsertionIndex(nums, target, true);

    // assert that `leftIdx` is within the array bounds and that `target`
    // is actually in `nums`.
    if (leftIdx == nums.length || nums[leftIdx] != target) return targetRange;

    targetRange[0] = leftIdx;
    targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

    return targetRange;
  }

  public int[] searchRange3(int[] nums, int target) {
    int[] targetRange = {-1, -1};

    // find the index of the leftmost appearance of `target`.
    for (int i = 0; i < nums.length; i++)
      if (nums[i] == target) {
        targetRange[0] = i;
        break;
      }

    // if the last loop did not find any index, then there is no valid range
    // and we return [-1, -1].
    if (targetRange[0] == -1) return targetRange;

    // find the index of the rightmost appearance of `target` (by reverse
    // iteration). it is guaranteed to appear.
    for (int j = nums.length - 1; j >= 0; j--)
      if (nums[j] == target) {
        targetRange[1] = j;
        break;
      }

    return targetRange;
  }
}
