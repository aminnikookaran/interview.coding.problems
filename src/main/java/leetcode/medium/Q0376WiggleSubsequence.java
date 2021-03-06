package leetcode.medium;

// https://leetcode.com/problems/wiggle-subsequence/
public class Q0376WiggleSubsequence {
  public int wiggleMaxLength1(int[] nums) {
    if (nums.length < 2) return nums.length;
    return 1 + Math.max(calculate(nums, 0, true), calculate(nums, 0, false));
  }

  private int calculate(int[] nums, int index, boolean isUp) {
    int maxcount = 0;
    for (int i = index + 1; i < nums.length; i++) {
      if ((isUp && nums[i] > nums[index]) || (!isUp && nums[i] < nums[index]))
        maxcount = Math.max(maxcount, 1 + calculate(nums, i, !isUp));
    }
    return maxcount;
  }

  public int wiggleMaxLength2(int[] nums) {
    if (nums.length < 2) return nums.length;
    int[] up = new int[nums.length];
    int[] down = new int[nums.length];
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) up[i] = Math.max(up[i], down[j] + 1);
        else if (nums[i] < nums[j]) down[i] = Math.max(down[i], up[j] + 1);
      }
    }
    return 1 + Math.max(down[nums.length - 1], up[nums.length - 1]);
  }

  public int wiggleMaxLength3(int[] nums) {
    if (nums.length < 2) return nums.length;
    int[] up = new int[nums.length];
    int[] down = new int[nums.length];
    up[0] = down[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        up[i] = down[i - 1] + 1;
        down[i] = down[i - 1];
      } else if (nums[i] < nums[i - 1]) {
        down[i] = up[i - 1] + 1;
        up[i] = up[i - 1];
      } else {
        down[i] = down[i - 1];
        up[i] = up[i - 1];
      }
    }
    return Math.max(down[nums.length - 1], up[nums.length - 1]);
  }

  public int wiggleMaxLength4(int[] nums) {
    if (nums.length < 2) return nums.length;
    int down = 1, up = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) up = down + 1;
      else if (nums[i] < nums[i - 1]) down = up + 1;
    }
    return Math.max(down, up);
  }

  public int wiggleMaxLength5(int[] nums) {
    if (nums.length < 2) return nums.length;
    int maxLen = 1;
    int sign = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[i - 1] && sign != -1) { // peak
        sign = -1;
        maxLen++;
      } else if (nums[i] > nums[i - 1] && sign != 1) { // valley
        sign = 1;
        maxLen++;
      }
    }
    return maxLen;
  }
}
