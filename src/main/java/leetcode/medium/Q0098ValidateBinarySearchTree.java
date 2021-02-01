package leetcode.medium;

import java.util.LinkedList;
import java.util.Stack;
import leetcode.TreeNode;

// https://leetcode.com/problems/validate-binary-search-tree/
public class Q0098ValidateBinarySearchTree {
  public boolean isValidBST1(TreeNode root) {
    return isValidBST1(root, Integer.MAX_VALUE + 1l, Integer.MIN_VALUE - 1l);
  }

  public boolean isValidBST1(TreeNode root, long max, long min) {
    if (root == null) return true;
    if (root.val <= min || root.val >= max) return false;
    return (isValidBST1(root.left, root.val, min) && isValidBST1(root.right, max, root.val));
  }

  public boolean isValidBST2(TreeNode root) {
    return isValidBST2(root, null, null);
  }

  public boolean isValidBST2(TreeNode root, Integer lower, Integer upper) {
    if (root == null) return true;
    if (lower != null && root.val <= lower) return false;
    if (upper != null && root.val >= upper) return false;
    if (!isValidBST2(root.right, root.val, upper)) return false;
    if (!isValidBST2(root.left, lower, root.val)) return false;
    return true;
  }

  LinkedList<TreeNode> stack = new LinkedList<>();
  LinkedList<Integer> uppers = new LinkedList<>(), lowers = new LinkedList<>();

  public void update(TreeNode root, Integer lower, Integer upper) {
    stack.add(root);
    lowers.add(lower);
    uppers.add(upper);
  }

  public boolean isValidBST3(TreeNode root) {
    Integer lower = null, upper = null, val;
    update(root, lower, upper);
    while (!stack.isEmpty()) {
      root = stack.poll();
      lower = lowers.poll();
      upper = uppers.poll();
      if (root == null) continue;
      val = root.val;
      if (lower != null && val <= lower) return false;
      if (upper != null && val >= upper) return false;
      update(root.right, val, upper);
      update(root.left, lower, val);
    }
    return true;
  }

  public boolean isValidBST4(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    double inorder = -Double.MAX_VALUE;
    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if (root.val <= inorder) return false;
      inorder = root.val;
      root = root.right;
    }
    return true;
  }
}
