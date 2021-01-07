package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/summary-ranges/
public class Q0228SummaryRanges {
  public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    if (nums == null || nums.length == 0) return result;
    int start = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1] + 1) {
        if (start == nums[i - 1]) result.add(String.valueOf(start));
        else result.add(start + "->" + nums[i - 1]);
        start = nums[i];
      }
    }
    if (start == nums[nums.length - 1]) result.add(String.valueOf(start));
    else result.add(start + "->" + nums[nums.length - 1]);
    return result;
  }
}
