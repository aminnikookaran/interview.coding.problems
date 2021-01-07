package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/combination-sum-ii/
public class Q0040CombinationSumII {
  public List<List<Integer>> combinationSum21(int[] candidates, int target) {
    List<List<Integer>> results = new ArrayList<>();
    Map<Integer, Integer> counter = new HashMap<>();
    for (int candidate : candidates) counter.put(candidate, counter.getOrDefault(candidate, 0) + 1);
    List<int[]> counterList = new ArrayList<>();
    counter.forEach(
        (key, value) -> {
          counterList.add(new int[] {key, value});
        });
    backtrack1(new LinkedList<>(), target, 0, counterList, results);
    return results;
  }

  private void backtrack1(
      LinkedList<Integer> comb,
      int remain,
      int curr,
      List<int[]> counter,
      List<List<Integer>> results) {
    if (remain == 0) results.add(new ArrayList<Integer>(comb));
    else
      for (int nextCurr = curr; nextCurr < counter.size(); ++nextCurr) {
        int[] entry = counter.get(nextCurr);
        Integer candidate = entry[0], freq = entry[1];
        if (freq <= 0) continue;
        comb.addLast(candidate);
        counter.set(nextCurr, new int[] {candidate, freq - 1});
        backtrack1(comb, remain - candidate, nextCurr, counter, results);
        counter.set(nextCurr, new int[] {candidate, freq});
        comb.removeLast();
      }
  }

  public List<List<Integer>> combinationSum22(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack2(list, new ArrayList<>(), nums, target, 0);
    return list;
  }

  private void backtrack2(
      List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
    if (remain == 0) list.add(new ArrayList<>(tempList));
    else {
      for (int i = start; i < nums.length && nums[i] <= remain; i++) {
        if (i > start && nums[i] == nums[i - 1]) continue;
        tempList.add(nums[i]);
        backtrack2(list, tempList, nums, remain - nums[i], i + 1);
        tempList.remove(tempList.size() - 1);
      }
    }
  }
}
