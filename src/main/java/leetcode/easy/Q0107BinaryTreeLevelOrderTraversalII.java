package leetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import leetcode.TreeNode;

// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class Q0107BinaryTreeLevelOrderTraversalII {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.add(root);
    while (!deque.isEmpty()) {
      result.add(0, new ArrayList<>());
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = deque.poll();
        result.get(0).add(node.val);
        if (node.left != null) deque.add(node.left);
        if (node.right != null) deque.add(node.right);
      }
    }
    return result;
  }
}
