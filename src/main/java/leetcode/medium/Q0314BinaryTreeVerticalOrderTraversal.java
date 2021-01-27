package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.TreeMap;
import leetcode.TreeNode;

// https://leetcode.com/problems/binary-tree-vertical-order-traversal/
public class Q0314BinaryTreeVerticalOrderTraversal {
  public List<List<Integer>> verticalOrder1(TreeNode root) {
    TreeMap<Integer, List<Integer>> map = new TreeMap<>();
    verticalOrder1(root, map);
    List<List<Integer>> result = new ArrayList<>();
    result.addAll(map.values());
    return result;
  }

  private void verticalOrder1(TreeNode t, TreeMap<Integer, List<Integer>> map) {
    if (t == null) return;
    Deque<TreeNode> q1 = new ArrayDeque<>();
    Deque<Integer> q2 = new ArrayDeque<>();
    q1.add(t);
    q2.add(0);
    while (!q1.isEmpty()) {
      TreeNode node = q1.poll();
      int order = q2.poll();
      // add to map
      List<Integer> list = map.get(order);
      if (list == null) {
        list = new ArrayList<>();
        map.put(order, list);
      }
      list.add(node.val);
      if (node.left != null) {
        q1.add(node.left);
        q2.add(order - 1);
      }
      if (node.right != null) {
        q1.add(node.right);
        q2.add(order + 1);
      }
    }
  }

  public List<List<Integer>> verticalOrder2(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    int[] mm = new int[2];
    getMinMax2(root, mm, 0);
    int len = mm[1] - mm[0] + 1;
    for (int i = 0; i < len; i++) result.add(new ArrayList<>());
    Deque<TreeNode> q1 = new ArrayDeque<>();
    Deque<Integer> q2 = new ArrayDeque<>();
    q1.add(root);
    q2.add(0);
    while (!q1.isEmpty()) {
      TreeNode h = q1.poll();
      int order = q2.poll();
      result.get(order - mm[0]).add(h.val);
      if (h.left != null) {
        q1.add(h.left);
        q2.add(order - 1);
      }
      if (h.right != null) {
        q1.add(h.right);
        q2.add(order + 1);
      }
    }
    return result;
  }

  private void getMinMax2(TreeNode node, int[] mm, int order) {
    if (node == null) return;
    mm[0] = Math.min(mm[0], order);
    mm[1] = Math.max(mm[1], order);
    getMinMax2(node.left, mm, order - 1);
    getMinMax2(node.right, mm, order + 1);
  }
}
