package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import leetcode.TreeNode;

public class Q0104MaximumDepthOfBinaryTree {
  public int maxDepth1(TreeNode root) {
    int height = 0;
    if (root == null) return height;
    Deque<TreeNode> deque = new ArrayDeque<>();
    Deque<TreeNode> dequeTemp = new ArrayDeque<>();
    deque.add(root);
    while (!deque.isEmpty()) {
      TreeNode node = deque.poll();
      if (node.left != null) dequeTemp.add(node.left);
      if (node.right != null) dequeTemp.add(node.right);
      if (deque.isEmpty()) {
        deque = dequeTemp;
        dequeTemp = new ArrayDeque<>();
        height++;
      }
    }
    return height;
  }

  public int maxDepth2(TreeNode root) {
    int height = 0;
    if (root == null) return height;
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.add(root);
    while (!deque.isEmpty()) {
      height++;
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = deque.poll();
        if (node.left != null) deque.add(node.left);
        if (node.right != null) deque.add(node.right);
      }
    }
    return height;
  }

  public int maxDepth3(TreeNode root) {
    return root == null ? 0 : Math.max(maxDepth3(root.left), maxDepth3(root.right)) + 1;
  }
}
