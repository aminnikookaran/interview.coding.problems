package leetcode.easy;

// https://leetcode.com/problems/third-maximum-number/
public class Q0414ThirdMaximumNumber {
  public int thirdMax1(int[] nums) {
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

  public int thirdMax2(int[] nums) {
    Integer max1 = null;
    Integer max2 = null;
    Integer max3 = null;
    for (Integer n : nums) {
      if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
      if (max1 == null || n > max1) {
        max3 = max2;
        max2 = max1;
        max1 = n;
      } else if (max2 == null || n > max2) {
        max3 = max2;
        max2 = n;
      } else if (max3 == null || n > max3) {
        max3 = n;
      }
    }
    return max3 == null ? max1 : max3;
  }
}
