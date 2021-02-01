package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/next-greater-element-i/
public class Q0496NextGreaterElementI {
  public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
    Stack<Integer> stack = new Stack<>();
    for (int num : nums2) {
      while (!stack.isEmpty() && stack.peek() < num) map.put(stack.pop(), num);
      stack.push(num);
    }
    for (int i = 0; i < nums1.length; i++) nums1[i] = map.getOrDefault(nums1[i], -1);
    return nums1;
  }

  public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    Stack<Integer> stack = new Stack<>();
    for (int i = nums2.length - 1; i >= 0; i--) {
      while (!stack.empty() && nums2[i] > stack.peek()) stack.pop();
      map.put(nums2[i], (stack.empty()) ? -1 : stack.peek());
      stack.push(nums2[i]);
    }
    for (int i = 0; i < nums1.length; i++) nums1[i] = map.get(nums1[i]);
    return nums1;
  }
}
