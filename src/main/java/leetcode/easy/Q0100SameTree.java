package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import leetcode.TreeNode;

// https://leetcode.com/problems/same-tree/
public class Q0100SameTree {
  public boolean isSameTree1(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    return p.val == q.val && isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
  }

  public boolean check(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (q == null || p == null) return false;
    if (p.val != q.val) return false;
    return true;
  }

  public boolean isSameTree2(TreeNode p, TreeNode q) {
    if (!check(p, q)) return false;

    Deque<TreeNode> deqP = new ArrayDeque<>();
    Deque<TreeNode> deqQ = new ArrayDeque<>();
    deqP.add(p);
    deqQ.add(q);

    while (!deqP.isEmpty()) {
      p = deqP.poll();
      q = deqQ.poll();

      if (!check(p, q)) return false;
      if (p != null) {
        if (!check(p.left, q.left)) return false;
        if (p.left != null) {
          deqP.add(p.left);
          deqQ.add(q.left);
        }
        if (!check(p.right, q.right)) return false;
        if (p.right != null) {
          deqP.add(p.right);
          deqQ.add(q.right);
        }
      }
    }
    return true;
  }
}
