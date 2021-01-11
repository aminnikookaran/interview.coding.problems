package leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class Q0215KthLargestElementInAnArray {
  public int findKthLargest1(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
  }

  public int findKthLargest2(int[] nums, int k) {
    PriorityQueue<Integer> q = new PriorityQueue<>(k);
    for (int i : nums) {
      q.offer(i);
      if (q.size() > k) q.poll();
    }
    return q.peek();
  }

  public int findKthLargest3(int[] nums, int k) {
    if (k < 1 || nums == null) return 0;
    return getKth(nums.length - k + 1, nums, 0, nums.length - 1);
  }

  public int getKth(int k, int[] nums, int start, int end) {
    int pivot = nums[end];
    int left = start;
    int right = end;
    while (true) {
      while (nums[left] < pivot && left < right) left++;
      while (nums[right] >= pivot && right > left) right--;
      if (left == right) break;
      swap(nums, left, right);
    }
    swap(nums, left, end);
    if (k == left + 1) return pivot;
    else if (k < left + 1) return getKth(k, nums, start, left - 1);
    else return getKth(k, nums, left + 1, end);
  }

  public void swap(int[] nums, int n1, int n2) {
    int tmp = nums[n1];
    nums[n1] = nums[n2];
    nums[n2] = tmp;
  }
}