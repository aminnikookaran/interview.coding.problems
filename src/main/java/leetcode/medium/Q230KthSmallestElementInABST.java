package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import leetcode.TreeNode;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class Q230KthSmallestElementInABST {
  public void inOrder(TreeNode root, List<Integer> list) {
    if (root == null) return;
    inOrder(root.left, list);
    list.add(root.val);
    inOrder(root.right, list);
  }

  public int kthSmallest1(TreeNode root, int k) {
    List<Integer> list = new ArrayList<>();
    inOrder(root, list);
    return list.get(k - 1);
  }

  public int kthSmallest2(TreeNode root, int k) {
    Deque<TreeNode> deque = new ArrayDeque<>();
    while (true) {
      while (root != null) {
        deque.push(root);
        root = root.left;
      }
      root = deque.poll();
      if (--k == 0) return root.val;
      root = root.right;
    }
  }
}
