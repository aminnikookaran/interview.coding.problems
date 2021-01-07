package leetcode.medium;

import java.util.Stack;
import leetcode.TreeNode;

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class Q0114FlattenBinaryTreeToLinkedList {
  public void flatten1(TreeNode root) {
    flatten1(root, null);
  }

  private TreeNode flatten1(TreeNode root, TreeNode pre) {
    if (root == null) return pre;
    pre = flatten1(root.right, pre);
    pre = flatten1(root.left, pre);
    root.right = pre;
    root.left = null;
    return root;
  }

  public void flatten2(TreeNode root) {
    if (root == null) return;
    Stack<TreeNode> s = new Stack<>();
    s.push(root);
    TreeNode prev = null, curr = null;
    while (!s.isEmpty()) {
      curr = s.pop();
      if (prev != null) {
        prev.right = curr;
        prev.left = null;
      }
      if (curr.right != null) s.push(curr.right);
      if (curr.left != null) s.push(curr.left);
      prev = curr;
    }
  }
}
