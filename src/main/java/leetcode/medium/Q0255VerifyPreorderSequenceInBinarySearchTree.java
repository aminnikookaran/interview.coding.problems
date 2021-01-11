package leetcode.medium;

import java.util.Stack;

// https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/
public class Q0255VerifyPreorderSequenceInBinarySearchTree {
  public boolean verifyPreorder1(int[] preorder) {
    Stack<Integer> stack = new Stack<>();
    int low = Integer.MIN_VALUE;
    for (int i = 0; i < preorder.length; i++) {
      if (preorder[i] < low) return false;
      while (!stack.isEmpty() && stack.peek() < preorder[i]) low = stack.pop();
      stack.push(preorder[i]);
    }
    return true;
  }

  public boolean verifyPreorder2(int[] preorder) {
    int low = Integer.MIN_VALUE, i = -1;
    for (int p : preorder) {
      if (p < low) return false;
      while (i >= 0 && p > preorder[i]) low = preorder[i--];
      preorder[++i] = p;
    }
    return true;
  }
}
