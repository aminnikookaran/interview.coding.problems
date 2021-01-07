package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/
public class Q00153Sum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      int j = i + 1, k = nums.length - 1;
      while (j < k) {
        if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
          k--;
          continue;
        }
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == 0) {
          List<Integer> list = new ArrayList<>();
          list.add(nums[i]);
          list.add(nums[j]);
          list.add(nums[k]);
          result.add(list);
          j++;
          k--;
        } else if (sum < 0) j++;
        else k--;
      }
    }
    return result;
  }
}
