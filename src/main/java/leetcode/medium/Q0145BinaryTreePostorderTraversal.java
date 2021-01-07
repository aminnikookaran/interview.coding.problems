package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import leetcode.TreeNode;

// https://leetcode.com/problems/binary-tree-postorder-traversal/
public class Q0145BinaryTreePostorderTraversal {
  public List<Integer> postorderTraversal1(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root != null) {
      result.addAll(postorderTraversal1(root.left));
      result.addAll(postorderTraversal1(root.right));
      result.add(root.val);
    }
    return result;
  }

  public List<Integer> postorderTraversal2(TreeNode root) {
    LinkedList<Integer> result = new LinkedList<>();
    if (root == null) return result;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      result.addFirst(node.val);
      if (node.left != null) stack.push(node.left);
      if (node.right != null) stack.push(node.right);
    }
    return result;
  }

  public List<Integer> postorderTraversal3(TreeNode root) {
    LinkedList<Integer> result = new LinkedList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode node = root;
    while (!stack.isEmpty() || node != null) {
      if (node != null) {
        stack.push(node);
        result.addFirst(node.val);
        node = node.right;
      } else node = stack.pop().left;
    }
    return result;
  }
}
