package leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import leetcode.TreeNode;

// https://leetcode.com/problems/binary-tree-paths/
public class Q257BinaryTreePaths {
  public List<String> binaryTreePaths1(TreeNode root) {
    List<String> result = new ArrayList<>();
    if (root == null) return result;
    binaryTreePaths1(root, result, new StringBuilder());
    return result;
  }

  public void binaryTreePaths1(TreeNode root, List<String> result, StringBuilder path) {
    int length = path.length();
    path.append(root.val);
    if (root.left == null && root.right == null) result.add(path.toString());
    else {
      path.append("->");
      if (root.left != null) binaryTreePaths1(root.left, result, path);
      if (root.right != null) binaryTreePaths1(root.right, result, path);
    }
    path.setLength(length);
  }

  public List<String> binaryTreePaths2(TreeNode root) {
    String sb = "";
    List<String> result = new ArrayList<String>();
    helper(root, result, sb);
    return result;
  }

  public void helper(TreeNode root, List<String> result, String s) {
    if (root == null) return;
    s = s + "->" + root.val;
    if (root.left == null && root.right == null) {
      result.add(s.substring(2));
      return;
    }
    if (root.left != null) helper(root.left, result, s);
    if (root.right != null) helper(root.right, result, s);
  }
}
