package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/permutations/
public class Q0046Permutations {
  public List<List<Integer>> permute1(int[] nums) {
    LinkedList<List<Integer>> result = new LinkedList<>();
    if (nums == null || nums.length == 0) return result;
    List<Integer> list = new ArrayList<>();
    list.add(nums[0]);
    result.add(list);
    for (int i = 1; i < nums.length; i++) {
      int size = result.size();
      for (int j = 0; j < size; j++) {
        list = result.remove();
        int listSize = list.size();
        for (int k = 0; k <= listSize; k++) {
          List<Integer> newList = new ArrayList<>();
          newList.addAll(list.subList(0, k));
          newList.add(nums[i]);
          newList.addAll(list.subList(k, listSize));
          result.add(newList);
        }
      }
    }
    return result;
  }

  public List<List<Integer>> permute2(int[] num) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    for (int i = 0; i < num.length; i++) {
      List<List<Integer>> current = new ArrayList<>();
      for (List<Integer> l : result) {
        for (int j = 0; j < l.size() + 1; j++) {
          l.add(j, num[i]);
          List<Integer> temp = new ArrayList<>(l);
          current.add(temp);
          l.remove(j);
        }
      }
      result = new ArrayList<>(current);
    }
    return result;
  }

  public List<List<Integer>> permute3(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    helper(0, nums, result);
    return result;
  }

  private void helper(int start, int[] nums, List<List<Integer>> result) {
    if (start == nums.length - 1) {
      List<Integer> list = new ArrayList<>();
      for (int num : nums) list.add(num);
      result.add(list);
      return;
    }
    for (int i = start; i < nums.length; i++) {
      swap(nums, i, start);
      helper(start + 1, nums, result);
      swap(nums, i, start);
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
