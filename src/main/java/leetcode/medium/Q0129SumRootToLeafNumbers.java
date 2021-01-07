package leetcode.medium;

import leetcode.TreeNode;

// https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class Q0129SumRootToLeafNumbers {
  public int sumNumbers(TreeNode root) {
    return sum(root, 0);
  }

  public int sum(TreeNode root, int sum) {
    if (root == null) return 0;
    sum = sum * 10 + root.val;
    if (root.right == null && root.left == null) return sum;
    return sum(root.left, sum) + sum(root.right, sum);
  }
}
