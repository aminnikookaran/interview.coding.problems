package leetcode.medium;

// https://leetcode.com/problems/maximum-product-subarray/
public class Q0152MaximumProductSubarray {
  public int maxProduct(int[] nums) {
    int currMax = nums[0];
    int currMin = nums[0];
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > 0) {
        currMax = Math.max(nums[i], currMax * nums[i]);
        currMin = Math.min(nums[i], currMin * nums[i]);
      } else {
        int temp = Math.max(nums[i], currMin * nums[i]);
        currMin = Math.min(nums[i], currMax * nums[i]);
        currMax = temp;
      }
      max = Math.max(max, currMax);
    }
    return max;
  }

  public int maxProduct2(int[] nums) {
    int[] max = new int[nums.length];
    int[] min = new int[nums.length];
    max[0] = min[0] = nums[0];
    int result = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > 0) {
        max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
        min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
      } else {
        max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
        min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
      }
      result = Math.max(result, max[i]);
    }
    return result;
  }

  public static void main(String[] args) {
    Q0152MaximumProductSubarray q = new Q0152MaximumProductSubarray();
    System.out.println(q.maxProduct(new int[] {2, 0, 3, 0, 4, -2, -1}));
  }
}
