package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// https://leetcode.com/problems/random-pick-index/
public class Q0398RandomPickIndex {
  class Solution1 {
    private int[] nums;
    private Random rand;

    public Solution1(int[] nums) {
      this.nums = nums;
      this.rand = new Random();
    }

    public int pick(int target) {
      List<Integer> indices = new ArrayList<>();
      int n = this.nums.length;
      for (int i = 0; i < n; ++i) if (this.nums[i] == target) indices.add(i);
      int l = indices.size();
      int randomIndex = indices.get(rand.nextInt(l));
      return randomIndex;
    }
  }

  class Solution2 {
    private Map<Integer, List<Integer>> indices;
    private Random rand;

    public Solution2(int[] nums) {
      this.rand = new Random();
      this.indices = new HashMap<>();
      int l = nums.length;
      for (int i = 0; i < l; ++i) {
        if (!this.indices.containsKey(nums[i])) this.indices.put(nums[i], new ArrayList<>());
        this.indices.get(nums[i]).add(i);
      }
    }

    public int pick(int target) {
      int l = indices.get(target).size();
      int randomIndex = indices.get(target).get(rand.nextInt(l));
      return randomIndex;
    }
  }

  class Solution3 {
    private int[] nums;
    private Random rand;

    public Solution3(int[] nums) {
      this.nums = nums;
      this.rand = new Random();
    }

    public int pick(int target) {
      int n = this.nums.length;
      int count = 0;
      int idx = 0;
      for (int i = 0; i < n; ++i) {
        if (this.nums[i] == target) {
          count++;
          if (rand.nextInt(count) == 0) idx = i;
        }
      }
      return idx;
    }
  }
}
