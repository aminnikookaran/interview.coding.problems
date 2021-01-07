package leetcode.medium;

// https://leetcode.com/problems/minimum-size-subarray-sum/
public class Q0209MinimumSizeSubarraySum {
  public int minSubArrayLen1(int s, int[] nums) {
    int sum = 0, left = 0, min = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      while (sum >= s) {
        min = Math.min(min, i - left + 1);
        sum -= nums[left++];
      }
    }
    return (min == Integer.MAX_VALUE) ? 0 : min;
  }

  // search if a window of size k exists that satisfy the condition
  public int minSubArrayLen2(int s, int[] nums) {
    int left = 1, right = nums.length, min = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (windowExist2(mid, nums, s)) {
        right = mid - 1;
        min = mid;
      } else left = mid + 1;
    }
    return min;
  }

  private boolean windowExist2(int size, int[] nums, int s) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i >= size) sum -= nums[i - size];
      sum += nums[i];
      if (sum >= s) return true;
    }
    return false;
  }

  public int minSubArrayLen3(int s, int[] nums) {
    int min = Integer.MAX_VALUE;

    int[] sums = new int[nums.length];
    for (int i = 0; i < nums.length; i++) sums[i] = nums[i] + (i == 0 ? 0 : sums[i - 1]);

    for (int i = 0; i < nums.length; i++) {
      int right = findWindowEnd3(i, sums, s);
      if (right == nums.length) break;
      min = Math.min(right - i + 1, min);
    }

    return min == Integer.MAX_VALUE ? 0 : min;
  }

  private int findWindowEnd3(int start, int[] sums, int s) {
    int left = start, right = sums.length - 1, offset = start == 0 ? 0 : sums[start - 1];
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int sum = sums[mid] - offset;
      if (sum >= s) right = mid - 1;
      else left = mid + 1;
    }
    return left;
  }
}
