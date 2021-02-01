package leetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import leetcode.TreeNode;

// https://leetcode.com/problems/symmetric-tree/
public class Q0101SymmetricTree {
  public boolean isSymmetric1(TreeNode root) {
    if (root == null) return true;
    Deque<TreeNode> queue = new ArrayDeque<>();
    List<TreeNode> list = new ArrayList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      list.add(node.left);
      list.add(node.right);
      if (queue.isEmpty()) {
        for (int i = 0; i <= (list.size() / 2); i++) {
          if (list.get(i) == null && list.get(list.size() - 1 - i) == null) continue;
          if (list.get(i) == null || list.get(list.size() - 1 - i) == null) return false;
          if (list.get(i).val != list.get(list.size() - 1 - i).val) return false;
        }
        for (int i = 0; i < list.size(); i++) if (list.get(i) != null) queue.add(list.get(i));
        list = new ArrayList<>();
      }
    }
    return true;
  }

  public boolean isSymmetric2(TreeNode root) {
    return isSymmetric2(root, root);
  }

  public boolean isSymmetric2(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    return (t1.val == t2.val) && isSymmetric2(t1.right, t2.left) && isSymmetric2(t1.left, t2.right);
  }

  public boolean isSymmetric3(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
      TreeNode t1 = q.poll();
      TreeNode t2 = q.poll();
      if (t1 == null && t2 == null) continue;
      if (t1 == null || t2 == null) return false;
      if (t1.val != t2.val) return false;
      q.add(t1.left);
      q.add(t2.right);
      q.add(t1.right);
      q.add(t2.left);
    }
    return true;
  }
}
