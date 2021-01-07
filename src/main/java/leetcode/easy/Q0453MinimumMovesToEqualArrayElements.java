package leetcode.easy;

import java.util.stream.IntStream;

// https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
public class Q0453MinimumMovesToEqualArrayElements {
  public int minMoves1(int[] nums) {
    if (nums.length == 0) return 0;
    int min = nums[0];
    for (int n : nums) min = Math.min(min, n);
    int res = 0;
    for (int n : nums) res += n - min;
    return res;
  }

  public int minMoves(int[] nums) {
    return IntStream.of(nums).sum() - nums.length * IntStream.of(nums).min().getAsInt();
  }
}
