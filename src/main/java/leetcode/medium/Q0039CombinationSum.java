package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class Q0039CombinationSum {
  public List<List<Integer>> combinationSum1(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
  }

  private void backtrack(
      List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
    if (remain == 0) list.add(new ArrayList<>(tempList));
    else {
      for (int i = start; i < nums.length && nums[i] <= remain; i++) {
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, remain - nums[i], i);
        tempList.remove(tempList.size() - 1);
      }
    }
  }
}
