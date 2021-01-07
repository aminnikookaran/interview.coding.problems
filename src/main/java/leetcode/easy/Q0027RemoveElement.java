package leetcode.easy;

// https://leetcode.com/problems/remove-element/
public class Q0027RemoveElement {
  public int removeElement1(int[] nums, int val) {
    if (nums == null || nums.length == 0) return 0;
    int i = 0, j = 0;
    while (j < nums.length) {
      if (j <= i || nums[j] == val) j++;
      else if (nums[i] != val) i++;
      else {
        nums[i] = nums[j];
        nums[j] = val;
        j++;
        i++;
      }
    }
    return nums[i] == val ? i : i + 1;
  }

  public int removeElement2(int[] nums, int val) {
    int i = 0;
    for (int j = 0; j < nums.length; j++) {
      if (nums[j] != val) {
        nums[i] = nums[j];
        i++;
      }
    }
    return i;
  }

  public int removeElement3(int[] nums, int val) {
    int i = 0;
    int n = nums.length;
    while (i < n) {
      if (nums[i] == val) {
        nums[i] = nums[n - 1];
        // reduce array size by one
        n--;
      } else {
        i++;
      }
    }
    return n;
  }
}
