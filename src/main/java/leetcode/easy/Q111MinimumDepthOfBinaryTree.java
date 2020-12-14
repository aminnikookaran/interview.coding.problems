package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import leetcode.TreeNode;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class Q111MinimumDepthOfBinaryTree {
  public int minDepth1(TreeNode root) {
    if (root == null) return 0;
    int left = minDepth1(root.left);
    int right = minDepth1(root.right);
    if (root.left == null || root.right == null) return 1 + Math.max(left, right);
    return 1 + Math.min(left, right);
  }

  public int minDepth2(TreeNode root) {
    if (root == null) return 0;
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.add(root);
    int height = 1;
    while (!deque.isEmpty()) {
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        TreeNode poll = deque.poll();
        if (poll.left == null && poll.right == null) return height;
        if (poll.left != null) deque.add(poll.left);
        if (poll.right != null) deque.add(poll.right);
      }
      height++;
    }
    return 0;
  }

  public int minDept3(TreeNode root) {
    if (root == null) return 0;
    LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
    LinkedList<Integer> counts = new LinkedList<Integer>();
    nodes.add(root);
    counts.add(1);
    while (!nodes.isEmpty()) {
      TreeNode curr = nodes.remove();
      int count = counts.remove();
      if (curr.left == null && curr.right == null) return count;
      if (curr.left != null) {
        nodes.add(curr.left);
        counts.add(count + 1);
      }
      if (curr.right != null) {
        nodes.add(curr.right);
        counts.add(count + 1);
      }
    }
    return 0;
  }
}
