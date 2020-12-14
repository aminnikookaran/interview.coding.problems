package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import leetcode.TreeNode;

// https://leetcode.com/problems/invert-binary-tree/
public class Q226InvertBinaryTree {
  public TreeNode invertTree1(TreeNode root) {
    if (root == null) return root;
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.add(root);
    while (!deque.isEmpty()) {
      TreeNode node = deque.poll();
      TreeNode temp = node.left;
      node.left = node.right;
      node.right = temp;
      if (node.left != null) deque.add(node.left);
      if (node.right != null) deque.add(node.right);
    }
    return root;
  }

  public TreeNode invertTree2(TreeNode root) {
    if (root == null) return root;
    TreeNode right = invertTree2(root.right);
    TreeNode left = invertTree2(root.left);
    root.left = right;
    root.right = left;
    return root;
  }
}
