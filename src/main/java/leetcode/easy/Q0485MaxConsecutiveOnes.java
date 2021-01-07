package leetcode.easy;

// https://leetcode.com/problems/max-consecutive-ones/
public class Q0485MaxConsecutiveOnes {
  public int findMaxConsecutiveOnes1(int[] nums) {
    int result = 0;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        count++;
        result = Math.max(count, result);
      } else count = 0;
    }
    return result;
  }

  public int findMaxConsecutiveOnes2(int[] nums) {
    int maxHere = 0, max = 0;
    for (int n : nums) max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
    return max;
  }
}
