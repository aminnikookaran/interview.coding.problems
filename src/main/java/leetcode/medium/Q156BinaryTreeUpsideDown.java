package leetcode.medium;

import leetcode.TreeNode;

// https://leetcode.com/problems/binary-tree-upside-down/
public class Q156BinaryTreeUpsideDown {
  public TreeNode upsideDownBinaryTree1(TreeNode root) {
    if (root == null || root.left == null) return root;

    TreeNode newRoot = upsideDownBinaryTree1(root.left);
    root.left.left = root.right;
    root.left.right = root;

    root.left = null;
    root.right = null;

    return newRoot;
  }

  static TreeNode upsideDownBinaryTree2(TreeNode root) {
    TreeNode prev = null;
    TreeNode curr = root;
    TreeNode next = null;
    TreeNode lastRight = null;

    while (curr != null) {
      next = curr.left;

      curr.left = lastRight;
      lastRight = curr.right;

      curr.right = prev;

      prev = curr;
      curr = next;
    }
    return prev;
  }
}
