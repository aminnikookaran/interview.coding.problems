package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import leetcode.TreeNode;

// https://leetcode.com/problems/path-sum/
public class Q0112PathSum {
  public boolean hasPathSum1(TreeNode root, int sum) {
    return hasPathSum1(root, sum, 0);
  }

  public boolean hasPathSum1(TreeNode root, int sum, int curr) {
    if (root == null) return false;
    if (root.left == null && root.right == null) return curr + root.val == sum;
    return hasPathSum1(root.left, sum, curr + root.val)
        || hasPathSum1(root.right, sum, curr + root.val);
  }

  public boolean hasPathSum2(TreeNode root, int sum) {
    if (root == null) return false;
    if (root.val == sum && (root.left == null && root.right == null)) return true;
    return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
  }

  public boolean hasPathSum3(TreeNode root, int sum) {
    if (root == null) return false;
    Deque<TreeNode> nodes = new ArrayDeque<>();
    Deque<Integer> values = new ArrayDeque<>();
    nodes.add(root);
    values.add(root.val);
    while (!nodes.isEmpty()) {
      TreeNode curr = nodes.poll();
      int sumValue = values.poll();
      if (curr.left == null && curr.right == null && sumValue == sum) return true;
      if (curr.left != null) {
        nodes.add(curr.left);
        values.add(sumValue + curr.left.val);
      }
      if (curr.right != null) {
        nodes.add(curr.right);
        values.add(sumValue + curr.right.val);
      }
    }
    return false;
  }
}
