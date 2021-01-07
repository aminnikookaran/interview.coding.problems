package leetcode.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import leetcode.TreeNode;

// https://leetcode.com/problems/find-mode-in-binary-search-tree/
public class Q0501FindModeInBinarySearchTree {
  Map<Integer, Integer> map;
  int max = 0;

  public int[] findMode1(TreeNode root) {
    if (root == null) return new int[0];
    this.map = new HashMap<>();

    inorder1(root);

    List<Integer> list = new LinkedList<>();
    for (int key : map.keySet()) if (map.get(key) == max) list.add(key);

    int[] res = new int[list.size()];
    for (int i = 0; i < res.length; i++) res[i] = list.get(i);
    return res;
  }

  public void inorder1(TreeNode node) {
    if (node.left != null) inorder1(node.left);
    map.put(node.val, map.getOrDefault(node.val, 0) + 1);
    max = Math.max(max, map.get(node.val));
    if (node.right != null) inorder1(node.right);
  }

  public int[] findMode2(TreeNode root) {
    inorder2(root);
    modes = new int[modeCount];
    modeCount = 0;
    currCount = 0;
    inorder2(root);
    return modes;
  }

  private int currVal;
  private int currCount = 0;
  private int maxCount = 0;
  private int modeCount = 0;

  private int[] modes;

  public void handleValue(int val) {
    if (val != currVal) {
      currVal = val;
      currCount = 0;
    }
    currCount++;
    if (currCount > maxCount) {
      maxCount = currCount;
      modeCount = 1;
    } else if (currCount == maxCount) {
      if (modes != null) modes[modeCount] = currVal;
      modeCount++;
    }
  }

  public void inorder2(TreeNode root) {
    if (root == null) return;
    inorder2(root.left);
    handleValue(root.val);
    inorder2(root.right);
  }

  public void inorder3(TreeNode root) {
    TreeNode node = root;
    while (node != null) {
      if (node.left == null) {
        handleValue(node.val);
        node = node.right;
      } else {
        TreeNode prev = node.left;
        while (prev.right != null && prev.right != node) prev = prev.right;
        if (prev.right == null) {
          prev.right = node;
          node = node.left;
        } else {
          prev.right = null;
          handleValue(node.val);
          node = node.right;
        }
      }
    }
  }
}
