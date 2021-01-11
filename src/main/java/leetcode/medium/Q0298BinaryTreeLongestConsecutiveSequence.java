package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import leetcode.TreeNode;

// https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
public class Q0298BinaryTreeLongestConsecutiveSequence {
  public int longestConsecutive1(TreeNode root) {
    if (root == null) return 0;
    Deque<TreeNode> nodeDeque = new ArrayDeque<>();
    Deque<Integer> sizeDeque = new ArrayDeque<>();
    nodeDeque.add(root);
    sizeDeque.add(1);
    int max = 1;
    while (!nodeDeque.isEmpty()) {
      TreeNode head = nodeDeque.poll();
      int size = sizeDeque.poll();
      if (head.left != null) {
        int leftSize = size;
        if (head.val == head.left.val - 1) max = Math.max(max, ++leftSize);
        else leftSize = 1;
        nodeDeque.add(head.left);
        sizeDeque.add(leftSize);
      }
      if (head.right != null) {
        int rightSize = size;
        if (head.val == head.right.val - 1) max = Math.max(max, ++rightSize);
        else rightSize = 1;
        nodeDeque.add(head.right);
        sizeDeque.add(rightSize);
      }
    }
    return max;
  }

  int max;

  public int longestConsecutive2(TreeNode root) {
    helper(root);
    return max;
  }

  private int helper(TreeNode root) {
    if (root == null) return 0;

    int leftMax = helper(root.left);
    int rightMax = helper(root.right);

    int leftTotal = 0;
    if (root.left != null && root.val + 1 == root.left.val) leftTotal = leftMax + 1;
    else leftTotal = 1;

    int rightTotal = 0;
    if (root.right != null && root.val + 1 == root.right.val) rightTotal = rightMax + 1;
    else rightTotal = 1;

    max = Math.max(Math.max(max, leftTotal), rightTotal);
    return Math.max(leftTotal, rightTotal);
  }
}
