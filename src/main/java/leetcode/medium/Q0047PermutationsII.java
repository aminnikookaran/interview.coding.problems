package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/permutations-ii/
public class Q0047PermutationsII {
  public List<List<Integer>> permuteUnique1(int[] nums) {
    List<List<Integer>> results = new ArrayList<>();
    Map<Integer, Integer> counter = new HashMap<>();
    for (int num : nums) {
      if (!counter.containsKey(num)) counter.put(num, 0);
      counter.put(num, counter.get(num) + 1);
    }
    this.backtrack(new LinkedList<>(), nums.length, counter, results);
    return results;
  }

  protected void backtrack(
      LinkedList<Integer> comb,
      Integer N,
      Map<Integer, Integer> counter,
      List<List<Integer>> results) {
    if (comb.size() == N) results.add(new ArrayList<Integer>(comb));
    else
      for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
        Integer num = entry.getKey();
        Integer count = entry.getValue();
        if (count == 0) continue;
        comb.addLast(num);
        counter.put(num, count - 1);
        backtrack(comb, N, counter, results);
        comb.removeLast();
        counter.put(num, count);
      }
  }

  public List<List<Integer>> permuteUnique2(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack2(list, new ArrayList<>(), nums, new boolean[nums.length]);
    return list;
  }

  private void backtrack2(
      List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
    if (tempList.size() == nums.length) list.add(new ArrayList<>(tempList));
    else
      for (int i = 0; i < nums.length; i++) {
        if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
        used[i] = true;
        tempList.add(nums[i]);
        backtrack2(list, tempList, nums, used);
        used[i] = false;
        tempList.remove(tempList.size() - 1);
      }
  }
}
