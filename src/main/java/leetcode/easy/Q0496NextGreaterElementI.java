package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/next-greater-element-i/
public class Q0496NextGreaterElementI {
  public int[] nextGreaterElement1(int[] findNums, int[] nums) {
    Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
    Stack<Integer> stack = new Stack<>();
    for (int num : nums) {
      while (!stack.isEmpty() && stack.peek() < num) map.put(stack.pop(), num);
      stack.push(num);
    }
    for (int i = 0; i < findNums.length; i++) findNums[i] = map.getOrDefault(findNums[i], -1);
    return findNums;
  }

  public int[] nextGreaterElement2(int[] findNums, int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    Stack<Integer> stack = new Stack<>();
    for (int i = nums.length - 1; i >= 0; i--) {
      while (!stack.empty() && nums[i] > stack.peek()) stack.pop();
      map.put(nums[i], (stack.empty()) ? -1 : stack.peek());
      stack.push(nums[i]);
    }
    for (int i = 0; i < findNums.length; i++) findNums[i] = map.get(findNums[i]);
    return findNums;
  }
}
