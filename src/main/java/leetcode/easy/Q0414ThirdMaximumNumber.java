package leetcode.easy;

// https://leetcode.com/problems/third-maximum-number/
public class Q0414ThirdMaximumNumber {
  public int thirdMax(int[] nums) {
    Integer first = null;
    Integer second = null;
    Integer third = null;
    for (int i = 0; i < nums.length; i++) {
      if (first == null || nums[i] > first) {
        third = second;
        second = first;
        first = nums[i];
      } else if (nums[i] != first && (second == null || nums[i] > second)) {
        third = second;
        second = nums[i];
      } else if (nums[i] != first && nums[i] != second && (third == null || nums[i] > third)) {
        third = nums[i];
      }
    }
    return third == null ? first : third;
  }
}
