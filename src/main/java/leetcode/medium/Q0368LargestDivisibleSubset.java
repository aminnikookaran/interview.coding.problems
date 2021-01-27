package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/largest-divisible-subset/
public class Q0368LargestDivisibleSubset {
  List<Integer> answer;

  public List<Integer> largestDivisibleSubset1(int[] nums) {
    if (nums == null || nums.length == 0) return new ArrayList<>();
    Arrays.sort(nums);
    int[] max = new int[1];
    List<Integer> result = new ArrayList<>();
    largestDivisibleSubset1(nums, 0, result, max);
    return answer;
  }

  public void largestDivisibleSubset1(int[] nums, int start, List<Integer> result, int[] max) {
    if (result.size() > max[0]) {
      max[0] = result.size();
      answer = new ArrayList<>(result);
    }
    if (start == nums.length) return;
    for (int i = start; i < nums.length; i++) {
      if (result.size() == 0) {
        result.add(nums[i]);
        largestDivisibleSubset1(nums, i + 1, result, max);
        result.remove(result.size() - 1);
      } else {
        int top = result.get(result.size() - 1);
        if (nums[i] % top == 0) {
          result.add(nums[i]);
          largestDivisibleSubset1(nums, i + 1, result, max);
          result.remove(result.size() - 1);
        }
      }
    }
  }

  public List<Integer> largestDivisibleSubset2(int[] nums) {
    List<Integer> result = new ArrayList<>();
    if (nums == null || nums.length == 0) return result;
    Arrays.sort(nums);
    int[] dp = new int[nums.length];
    int[] index = new int[nums.length];
    Arrays.fill(dp, 1);
    Arrays.fill(index, -1);
    int max = 0;
    int maxIndex = -1;
    for (int i = 0; i < dp.length; i++) {
      dp[i] = 1;
      index[i] = -1;
      for (int j = i - 1; j >= 0; j--) {
        if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
          dp[i] = dp[j] + 1;
          index[i] = j;
        }
      }
      if (max < dp[i]) {
        max = dp[i];
        maxIndex = i;
      }
    }
    int i = maxIndex;
    while (i >= 0) {
      result.add(nums[i]);
      i = index[i];
    }
    return result;
  }
}
