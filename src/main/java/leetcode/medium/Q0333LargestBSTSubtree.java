package leetcode.medium;

import leetcode.TreeNode;

// https://leetcode.com/problems/largest-bst-subtree/
public class Q0333LargestBSTSubtree {
  public int largestBSTSubtree1(TreeNode root) {
    return helper(root).size;
  }

  class Wrapper {
    int size;
    int lower, upper;
    boolean isBST;

    public Wrapper() {
      lower = Integer.MAX_VALUE;
      upper = Integer.MIN_VALUE;
      isBST = false;
      size = 0;
    }
  }

  public Wrapper helper(TreeNode node) {
    Wrapper curr = new Wrapper();
    if (node == null) {
      curr.isBST = true;
      return curr;
    }
    Wrapper l = helper(node.left);
    Wrapper r = helper(node.right);
    // current subtree's boundaries
    curr.lower = Math.min(node.val, Math.min(l.lower, r.lower));
    curr.upper = Math.max(node.val, Math.max(l.upper, r.upper));
    // check left and right subtrees are BST or not
    // check left's upper again current's value and right's lower against current's value
    if (l.isBST && r.isBST && l.upper <= node.val && r.lower >= node.val) {
      curr.size = l.size + r.size + 1;
      curr.isBST = true;
    } else {
      curr.size = Math.max(l.size, r.size);
      curr.isBST = false;
    }
    return curr;
  }
}
