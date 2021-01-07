package leetcode.medium;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
public class Q0080RemoveDuplicatesFromSortedArrayII {
  public int removeDuplicates1(int[] nums) {
    int i = 0;
    for (int n : nums) if (i < 2 || n > nums[i - 2]) nums[i++] = n;
    return i;
  }

  public int removeDuplicates(int[] nums) {
    final int k = 2;
    if (nums.length == 0) return 0;
    int m = 1;
    int count = 1;
    for (int i = 1; i < nums.length; ++i) {
      if (nums[i] == nums[i - 1]) {
        if (count < k) nums[m++] = nums[i];
        count++;
      } else {
        count = 1;
        nums[m++] = nums[i];
      }
    }
    return m;
  }
}
