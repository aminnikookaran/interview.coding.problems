package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import leetcode.TreeNode;

// https://leetcode.com/problems/sum-of-left-leaves/
public class Q404SumOfLeftLeaves {
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;
    Deque<TreeNode> dequeLeft = new ArrayDeque<>();
    Deque<TreeNode> dequeRight = new ArrayDeque<>();
    dequeRight.add(root);
    int sum = 0;
    while (!dequeLeft.isEmpty() || !dequeRight.isEmpty()) {
      int size = dequeLeft.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = dequeLeft.poll();
        if (node.left == null && node.right == null) sum += node.val;
        if (node.left != null) dequeLeft.add(node.left);
        if (node.right != null) dequeRight.add(node.right);
      }
      size = dequeRight.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = dequeRight.poll();
        if (node.left != null) dequeLeft.add(node.left);
        if (node.right != null) dequeRight.add(node.right);
      }
    }
    return sum;
  }
}
