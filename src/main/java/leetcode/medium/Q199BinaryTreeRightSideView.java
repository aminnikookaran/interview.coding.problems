package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import leetcode.TreeNode;

// https://leetcode.com/problems/binary-tree-right-side-view/
public class Q199BinaryTreeRightSideView {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.add(root);
    while (!deque.isEmpty()) {
      result.add(deque.peek().val);
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = deque.poll();
        if (node.right != null) deque.add(node.right);
        if (node.left != null) deque.add(node.left);
      }
    }
    return result;
  }
}
