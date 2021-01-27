package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import leetcode.TreeNode;

// https://leetcode.com/problems/find-leaves-of-binary-tree/
public class Q0366FindLeavesOfBinaryTree {
  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    findLeaves(result, root);
    return result;
  }

  public int findLeaves(List<List<Integer>> list, TreeNode root) {
    if (root == null) return -1;
    int left = findLeaves(list, root.left);
    int right = findLeaves(list, root.right);
    int curr = Math.max(left, right) + 1;
    if (list.size() <= curr) list.add(new ArrayList<>());
    list.get(curr).add(root.val);
    return curr;
  }
}
