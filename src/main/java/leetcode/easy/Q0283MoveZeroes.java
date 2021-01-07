package leetcode.easy;

// https://leetcode.com/problems/move-zeroes/
public class Q0283MoveZeroes {
  public void moveZeroes1(int[] nums) {
    int i = 0, j = 0;
    while (j < nums.length && j == 0) if (nums[j] != 0) j++;
    while (j < nums.length)
      if (nums[j] == 0) j++;
      else if (nums[i] == 0) {
        nums[i++] = nums[j];
        nums[j++] = 0;
      } else i++;
  }

  public void moveZeroes2(int[] nums) {
    int i = 0, j = 0;
    while (j++ < nums.length) if (nums[j] != 0) nums[i++] = nums[j];
    while (i < nums.length) nums[i++] = 0;
  }
}
