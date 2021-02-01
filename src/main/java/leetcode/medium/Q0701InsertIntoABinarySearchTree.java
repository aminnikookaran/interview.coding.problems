package leetcode.medium;

import leetcode.TreeNode;

// https://leetcode.com/problems/insert-into-a-binary-search-tree/
public class Q0701InsertIntoABinarySearchTree {
  public TreeNode insertIntoBST1(TreeNode root, int val) {
    if (root == null) return new TreeNode(val);
    if (val > root.val) root.right = insertIntoBST1(root.right, val);
    else root.left = insertIntoBST1(root.left, val);
    return root;
  }

  public TreeNode insertIntoBST2(TreeNode root, int val) {
    if (root == null) return new TreeNode(val);
    TreeNode cur = root;
    while (true) {
      if (cur.val <= val) {
        if (cur.right != null) cur = cur.right;
        else {
          cur.right = new TreeNode(val);
          break;
        }
      } else {
        if (cur.left != null) cur = cur.left;
        else {
          cur.left = new TreeNode(val);
          break;
        }
      }
    }
    return root;
  }
}
