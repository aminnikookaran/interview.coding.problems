package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/majority-element/
public class Q0169MajorityElement {
  public int majorityElement1(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (Integer integer : nums) {
      Integer count = map.get(integer);
      if (count == null) count = 0;
      if (count + 1 > nums.length / 2) return integer;
      map.put(integer, count + 1);
    }
    return -1;
  }

  public int majorityElement2(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }

  private int countInRange(int[] nums, int num, int lo, int hi) {
    int count = 0;
    for (int i = lo; i <= hi; i++) if (nums[i] == num) count++;
    return count;
  }

  private int majorityElementRec(int[] nums, int lo, int hi) {
    // base case; the only element in an array of size 1 is the majority
    // element.
    if (lo == hi) return nums[lo];

    // recurse on left and right halves of this slice.
    int mid = (hi - lo) / 2 + lo;
    int left = majorityElementRec(nums, lo, mid);
    int right = majorityElementRec(nums, mid + 1, hi);

    // if the two halves agree on the majority element, return it.
    if (left == right) return left;

    // otherwise, count each element and return the "winner".
    int leftCount = countInRange(nums, left, lo, hi);
    int rightCount = countInRange(nums, right, lo, hi);

    return leftCount > rightCount ? left : right;
  }

  public int majorityElement3(int[] nums) {
    return majorityElementRec(nums, 0, nums.length - 1);
  }

  public int majorityElement(int[] nums) {
    int count = 0;
    Integer candidate = null;
    for (int num : nums) {
      if (count == 0) candidate = num;
      count += (num == candidate) ? 1 : -1;
    }
    return candidate;
  }
}
