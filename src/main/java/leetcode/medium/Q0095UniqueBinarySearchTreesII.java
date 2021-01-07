package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import leetcode.TreeNode;

// https://leetcode.com/problems/unique-binary-search-trees-ii/
public class Q0095UniqueBinarySearchTreesII {
  public List<TreeNode> generateTrees1(int n) {
    if (n == 0) return new ArrayList<>();
    return genTreeList(1, n);
  }

  private List<TreeNode> genTreeList(int start, int end) {
    List<TreeNode> list = new ArrayList<>();
    if (start > end) list.add(null);
    for (int idx = start; idx <= end; idx++) {
      List<TreeNode> leftList = genTreeList(start, idx - 1);
      List<TreeNode> rightList = genTreeList(idx + 1, end);
      for (TreeNode left : leftList) {
        for (TreeNode right : rightList) {
          TreeNode root = new TreeNode(idx);
          root.left = left;
          root.right = right;
          list.add(root);
        }
      }
    }
    return list;
  }

  public static List<TreeNode> generateTrees(int n) {
    @SuppressWarnings("unchecked")
    List<TreeNode>[] result = new List[n + 1];
    result[0] = new ArrayList<>();
    if (n == 0) return result[0];

    result[0].add(null);
    for (int len = 1; len <= n; len++) {
      result[len] = new ArrayList<>();
      for (int j = 0; j < len; j++) {
        for (TreeNode nodeL : result[j]) {
          for (TreeNode nodeR : result[len - j - 1]) {
            TreeNode node = new TreeNode(j + 1);
            node.left = nodeL;
            node.right = clone(nodeR, j + 1);
            result[len].add(node);
          }
        }
      }
    }
    return result[n];
  }

  private static TreeNode clone(TreeNode n, int offset) {
    if (n == null) return null;
    TreeNode node = new TreeNode(n.val + offset);
    node.left = clone(n.left, offset);
    node.right = clone(n.right, offset);
    return node;
  }
}
