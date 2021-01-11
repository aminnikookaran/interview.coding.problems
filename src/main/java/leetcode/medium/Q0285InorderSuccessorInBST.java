package leetcode.medium;

import leetcode.TreeNode;

// https://leetcode.com/problems/inorder-successor-in-bst/
public class Q0285InorderSuccessorInBST {
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null || p == null) return null;

    if (p.right != null) {
      p = p.right;
      while (p.left != null) p = p.left;
      return p;
    }

    TreeNode next = null;
    while (root != null) {
      if (root.val > p.val) {
        next = root;
        root = root.left;
      } else if (root.val < p.val) root = root.right;
      else break;
    }
    return next;
  }
}
