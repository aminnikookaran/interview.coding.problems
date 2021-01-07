package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import leetcode.Pair;

// https://leetcode.com/problems/range-sum-query-immutable/
public class Q0303RangeSumQueryImmutable {
  class NumArray1 {
    private int[] data;

    public NumArray1(int[] nums) {
      data = nums;
    }

    public int sumRange(int i, int j) {
      int sum = 0;
      for (int k = i; k <= j; k++) sum += data[k];
      return sum;
    }
  }

  class NumArray2 {
    private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

    public NumArray2(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
        int sum = 0;
        for (int j = i; j < nums.length; j++) {
          sum += nums[j];
          map.put(new Pair<>(i, j), sum);
        }
      }
    }

    public int sumRange(int i, int j) {
      return map.get(new Pair<>(i, j));
    }
  }

  class NumArray3 {
    private int[] sum;

    public NumArray3(int[] nums) {
      sum = new int[nums.length + 1];
      for (int i = 0; i < nums.length; i++) sum[i + 1] = sum[i] + nums[i];
    }

    public int sumRange(int i, int j) {
      return sum[j + 1] - sum[i];
    }
  }
}
