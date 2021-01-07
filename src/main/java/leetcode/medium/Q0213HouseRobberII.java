package leetcode.medium;

// https://leetcode.com/problems/house-robber-ii/
public class Q0213HouseRobberII {
  public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];
    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
  }

  public int rob(int[] nums, int left, int right) {
    int preRob = 0, preNotRob = 0, rob = 0, notRob = 0;
    for (int i = left; i <= right; i++) {
      rob = preNotRob + nums[i];
      notRob = Math.max(preRob, preNotRob);
      preNotRob = notRob;
      preRob = rob;
    }
    return Math.max(rob, notRob);
  }
}
