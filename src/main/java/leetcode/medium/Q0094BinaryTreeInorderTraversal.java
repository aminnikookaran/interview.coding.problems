package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import leetcode.TreeNode;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class Q0094BinaryTreeInorderTraversal {
  public List<Integer> inorderTraversal1(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    inorderTraversal1(root, list);
    return list;
  }

  public void inorderTraversal1(TreeNode root, List<Integer> list) {
    if (root == null) return;
    inorderTraversal1(root.left, list);
    list.add(root.val);
    inorderTraversal1(root.right, list);
  }

  public List<Integer> inorderTraversal2(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      res.add(curr.val);
      curr = curr.right;
    }
    return res;
  }

  public List<Integer> inorderTraversal3(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    TreeNode curr = root;
    TreeNode pre;
    while (curr != null) {
      if (curr.left == null) {
        res.add(curr.val);
        curr = curr.right; // move to next right node
      } else { // has a left subtree
        pre = curr.left;
        while (pre.right != null) pre = pre.right; // find rightmost
        pre.right = curr; // put cur after the pre node
        TreeNode temp = curr; // store cur node
        curr = curr.left; // move cur to the top of the new tree
        temp.left = null; // original cur left be null, avoid infinite loops
      }
    }
    return res;
  }
}
