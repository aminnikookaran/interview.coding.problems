package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import leetcode.TreeNode;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class Q103BinaryTreeZigzagLevelOrderTraversal {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.add(root);
    boolean leftToRight = true;
    while (!deque.isEmpty()) {
      int size = deque.size();
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = null;
        if (leftToRight) node = deque.pollFirst();
        else node = deque.pollLast();
        list.add(node.val);
        if (leftToRight) {
          if (node.left != null) deque.addLast(node.left);
          if (node.right != null) deque.addLast(node.right);
        } else {
          if (node.right != null) deque.addFirst(node.right);
          if (node.left != null) deque.addFirst(node.left);
        }
      }
      result.add(list);
      leftToRight = !leftToRight;
    }
    return result;
  }
}
