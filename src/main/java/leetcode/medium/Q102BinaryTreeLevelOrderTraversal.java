package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import leetcode.TreeNode;

// https://leetcode.com/problems/binary-tree-level-order-traversal/
public class Q102BinaryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder1(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.add(root);
    while (!deque.isEmpty()) {
      int size = deque.size();
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = deque.poll();
        list.add(node.val);
        if (node.left != null) deque.add(node.left);
        if (node.right != null) deque.add(node.right);
      }
      result.add(list);
    }
    return result;
  }

  public List<List<Integer>> levelOrder2(TreeNode root) {
    List<List<Integer>> al = new ArrayList<>();
    List<Integer> nodeValues = new ArrayList<>();
    if (root == null) return al;
    LinkedList<TreeNode> current = new LinkedList<>();
    LinkedList<TreeNode> next = new LinkedList<>();
    current.add(root);
    while (!current.isEmpty()) {
      TreeNode node = current.remove();
      if (node.left != null) next.add(node.left);
      if (node.right != null) next.add(node.right);
      nodeValues.add(node.val);
      if (current.isEmpty()) {
        current = next;
        next = new LinkedList<TreeNode>();
        al.add(nodeValues);
        nodeValues = new ArrayList<>();
      }
    }
    return al;
  }

  public List<List<Integer>> levelOrder3(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    LinkedList<TreeNode> nodeQueue = new LinkedList<>();
    LinkedList<Integer> levelQueue = new LinkedList<>();
    nodeQueue.offer(root);
    levelQueue.offer(1); // start from 1
    while (!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.poll();
      int level = levelQueue.poll();
      List<Integer> l = null;
      if (result.size() < level) {
        l = new ArrayList<>();
        result.add(l);
      } else l = result.get(level - 1);
      l.add(node.val);
      if (node.left != null) {
        nodeQueue.offer(node.left);
        levelQueue.offer(level + 1);
      }
      if (node.right != null) {
        nodeQueue.offer(node.right);
        levelQueue.offer(level + 1);
      }
    }
    return result;
  }
}
