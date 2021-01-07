package leetcode.medium;

import java.util.ArrayList;
import java.util.Stack;
import leetcode.TreeNode;

// https://leetcode.com/problems/binary-search-tree-iterator/
public class Q0173BinarySearchTreeIterator {
  class BSTIterator1 {
    ArrayList<Integer> nodesSorted;
    int index;

    public BSTIterator1(TreeNode root) {
      this.nodesSorted = new ArrayList<Integer>();
      this.index = -1;
      this._inorder(root);
    }

    private void _inorder(TreeNode root) {
      if (root == null) return;
      this._inorder(root.left);
      this.nodesSorted.add(root.val);
      this._inorder(root.right);
    }

    /** @return the next smallest number */
    public int next() {
      return this.nodesSorted.get(++this.index);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
      return this.index + 1 < this.nodesSorted.size();
    }
  }

  class BSTIterator2 {
    Stack<TreeNode> stack;

    public BSTIterator2(TreeNode root) {
      this.stack = new Stack<TreeNode>();
      this._leftmostInorder(root);
    }

    private void _leftmostInorder(TreeNode root) {
      while (root != null) {
        this.stack.push(root);
        root = root.left;
      }
    }

    /** @return the next smallest number */
    public int next() {
      TreeNode topmostNode = this.stack.pop();
      if (topmostNode.right != null) this._leftmostInorder(topmostNode.right);
      return topmostNode.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
      return this.stack.size() > 0;
    }
  }
}
