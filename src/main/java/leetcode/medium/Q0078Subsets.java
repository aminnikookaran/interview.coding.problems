package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/
public class Q0078Subsets {
  public List<List<Integer>> subsets1(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null) return result;
    result.add(new ArrayList<>());
    for (int i = 0; i < nums.length; i++) {
      int size = result.size();
      for (int j = 0; j < size; j++) {
        List<Integer> list = new ArrayList<>(result.get(j));
        list.add(nums[i]);
        result.add(list);
      }
    }
    return result;
  }

  List<List<Integer>> output = new ArrayList<>();
  int n, k;

  public void backtrack(int first, List<Integer> curr, int[] nums) {
    // if the combination is done
    if (curr.size() == k) output.add(new ArrayList<>(curr));

    for (int i = first; i < n; ++i) {
      // add i into the current combination
      curr.add(nums[i]);
      // use next integers to complete the combination
      backtrack(i + 1, curr, nums);
      // backtrack
      curr.remove(curr.size() - 1);
    }
  }

  public List<List<Integer>> subsets2(int[] nums) {
    n = nums.length;
    for (k = 0; k < n + 1; ++k) backtrack(0, new ArrayList<Integer>(), nums);
    return output;
  }

  public List<List<Integer>> subsets3(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();
    int n = nums.length;

    for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
      // generate bitmask, from 0..00 to 1..11
      String bitmask = Integer.toBinaryString(i).substring(1);

      // append subset corresponding to that bitmask
      List<Integer> curr = new ArrayList<>();
      for (int j = 0; j < n; ++j) if (bitmask.charAt(j) == '1') curr.add(nums[j]);
      output.add(curr);
    }
    return output;
  }
}
