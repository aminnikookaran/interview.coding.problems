package leetcode.medium;

import leetcode.TreeNode;

// https://leetcode.com/problems/count-univalue-subtrees/
public class Q0250CountUnivalueSubtrees {
  class Count {
    int count = 0;
  }

  public int countUnivalSubtrees(TreeNode root) {
    Count count = new Count();
    countUnivalSubtrees(root, count);
    return count.count;
  }

  boolean countUnivalSubtrees(TreeNode root, Count count) {
    if (root == null) return true;
    boolean left = countUnivalSubtrees(root.left, count);
    boolean right = countUnivalSubtrees(root.right, count);
    if (left == false || right == false) return false;
    if (root.left != null && root.val != root.left.val) return false;
    if (root.right != null && root.val != root.right.val) return false;
    count.count++;
    return true;
  }
}
