package leetcode.medium;

// https://leetcode.com/problems/find-peak-element/
public class Q162FindPeakElement {
  public int findPeakElement1(int[] nums) {
    for (int i = 0; i < nums.length; i++)
      if ((i == 0 || nums[i] > nums[i - 1]) && (i == nums.length - 1 || nums[i] > nums[i + 1]))
        return i;
    return -1;
  }

  public int findPeakElement2(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) if (nums[i] > nums[i + 1]) return i;
    return nums.length - 1;
  }

  public int findPeakElement3(int[] nums) {
    return search(nums, 0, nums.length - 1);
  }

  public int search(int[] nums, int l, int r) {
    if (l == r) return l;
    int mid = (l + r) / 2;
    if (nums[mid] > nums[mid + 1]) return search(nums, l, mid);
    return search(nums, mid + 1, r);
  }

  public int findPeakElement4(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
      int mid = (l + r) / 2;
      if (nums[mid] > nums[mid + 1]) r = mid;
      else l = mid + 1;
    }
    return l;
  }
}
