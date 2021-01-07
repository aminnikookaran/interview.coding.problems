package leetcode.easy;

import leetcode.TreeNode;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class Q0235LowestCommonAncestorOfABinarySearchTree {
  public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
    while (root != null) {
      boolean pright = p.val > root.val;
      boolean qright = q.val > root.val;
      if (root.val == p.val || root.val == q.val || (pright ^ qright)) break;
      if (pright) root = root.right;
      else root = root.left;
    }
    return root;
  }

  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val > root.val && q.val > root.val) return lowestCommonAncestor2(root.right, p, q);
    else if (p.val < root.val && q.val < root.val) return lowestCommonAncestor2(root.left, p, q);
    else return root;
  }

  public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
    while (root != null)
      if (p.val > root.val && q.val > root.val) root = root.right;
      else if (p.val < root.val && q.val < root.val) root = root.left;
      else return root;
    return root;
  }
}
