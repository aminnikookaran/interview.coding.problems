package leetcode.medium;

// https://leetcode.com/problems/product-of-array-except-self/
public class Q238ProductOfArrayExceptSelf {
  public int[] productExceptSelf1(int[] nums) {
    int length = nums.length;
    int[] L = new int[length];
    int[] R = new int[length];
    int[] answer = new int[length];
    L[0] = 1;
    for (int i = 1; i < length; i++) L[i] = nums[i - 1] * L[i - 1];
    R[length - 1] = 1;
    for (int i = length - 2; i >= 0; i--) R[i] = nums[i + 1] * R[i + 1];
    for (int i = 0; i < length; i++) answer[i] = L[i] * R[i];
    return answer;
  }

  public int[] productExceptSelf2(int[] nums) {
    int length = nums.length;
    int[] answer = new int[length];
    answer[0] = 1;
    for (int i = 1; i < length; i++) answer[i] = nums[i - 1] * answer[i - 1];
    int R = 1;
    for (int i = length - 1; i >= 0; i--) {
      answer[i] = answer[i] * R;
      R *= nums[i];
    }
    return answer;
  }
}
