package leetcode.medium;

import leetcode.TreeNode;

// https://leetcode.com/problems/count-complete-tree-nodes/
public class Q0222CountCompleteTreeNodes {
  public int countNodes1(TreeNode root) {
    int h = height(root);
    if (h < 0) return 0;
    if (height(root.right) == h - 1) return (1 << h) + countNodes1(root.right);
    else return (1 << h - 1) + countNodes1(root.left);
  }

  public int countNodes2(TreeNode root) {
    int nodes = 0, h = height(root);
    while (root != null) {
      if (height(root.right) == h - 1) {
        nodes += 1 << h;
        root = root.right;
      } else {
        nodes += 1 << h - 1;
        root = root.left;
      }
      h--;
    }
    return nodes;
  }

  int height(TreeNode root) {
    return root == null ? -1 : 1 + height(root.left);
  }

  public int countNodes3(TreeNode root) {
    if (root == null) return 0;
    TreeNode left = root, right = root;
    int height = 0;
    while (right != null) {
      left = left.left;
      right = right.right;
      height++;
    }
    if (left == null) return (1 << height) - 1;
    return 1 + countNodes3(root.left) + countNodes3(root.right);
  }

  public int countNodes4(TreeNode root) {
    int leftDepth = leftDepth(root);
    int rightDepth = rightDepth(root);
    if (leftDepth == rightDepth) return (1 << leftDepth) - 1;
    else return 1 + countNodes4(root.left) + countNodes4(root.right);
  }

  private int leftDepth(TreeNode root) {
    int dep = 0;
    while (root != null) {
      root = root.left;
      dep++;
    }
    return dep;
  }

  private int rightDepth(TreeNode root) {
    int dep = 0;
    while (root != null) {
      root = root.right;
      dep++;
    }
    return dep;
  }
}
