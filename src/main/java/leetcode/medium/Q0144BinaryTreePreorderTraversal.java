package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import leetcode.TreeNode;

// https://leetcode.com/problems/binary-tree-preorder-traversal/
public class Q0144BinaryTreePreorderTraversal {
  public List<Integer> preorderTraversal1(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root != null) {
      result.add(root.val);
      result.addAll(preorderTraversal1(root.left));
      result.addAll(preorderTraversal1(root.right));
    }
    return result;
  }

  public List<Integer> preorderTraversal2(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      result.add(node.val);
      if (node.right != null) stack.push(node.right);
      if (node.left != null) stack.push(node.left);
    }
    return result;
  }

  public List<Integer> preorderTraversal3(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode node = root;
    while (!stack.isEmpty() || node != null) {
      if (node != null) {
        stack.push(node);
        result.add(node.val);
        node = node.left;
      } else node = stack.pop().right;
    }
    return result;
  }
}
