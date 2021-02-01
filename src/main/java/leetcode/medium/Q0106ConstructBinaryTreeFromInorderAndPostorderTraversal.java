package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import leetcode.TreeNode;

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class Q0106ConstructBinaryTreeFromInorderAndPostorderTraversal {
  public TreeNode buildTree1(int[] inorder, int[] postorder) {
    return buildTree1(inorder, inorder.length - 1, 0, postorder, postorder.length - 1);
  }

  private TreeNode buildTree1(
      int[] inorder, int inStart, int inEnd, int[] postorder, int postStart) {
    if (postStart < 0 || inStart < inEnd) return null;

    // The last element in postorder is the root.
    TreeNode root = new TreeNode(postorder[postStart]);

    // find the index of the root from inorder. Iterating from the end.
    int rIndex = inStart;
    for (int i = inStart; i >= inEnd; i--) {
      if (inorder[i] == postorder[postStart]) {
        rIndex = i;
        break;
      }
    }
    // build right and left subtrees. Again, scanning from the end to find the sections.
    root.left =
        buildTree1(inorder, inStart, rIndex - 1, postorder, postStart + rIndex - inStart - 1);
    root.right = buildTree1(inorder, rIndex + 1, inEnd, postorder, postStart + rIndex - inStart);
    return root;
  }

  public TreeNode buildTree2(int[] inorder, int[] postorder) {
    if (inorder.length == 0 || postorder.length == 0) return null;
    int ip = inorder.length - 1;
    int pp = postorder.length - 1;

    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode prev = null;
    TreeNode root = new TreeNode(postorder[pp]);
    stack.push(root);
    pp--;

    while (pp >= 0) {
      while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
        prev = stack.pop();
        ip--;
      }
      TreeNode newNode = new TreeNode(postorder[pp]);
      if (prev != null) {
        prev.left = newNode;
      } else if (!stack.isEmpty()) {
        TreeNode currTop = stack.peek();
        currTop.right = newNode;
      }
      stack.push(newNode);
      prev = null;
      pp--;
    }

    return root;
  }

  public TreeNode buildTree3(int[] inorder, int[] postorder) {
    if (inorder == null || postorder == null || inorder.length != postorder.length) return null;
    Map<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < inorder.length; ++i) hm.put(inorder[i], i);
    return buildTree3(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, hm);
  }

  private TreeNode buildTree3(
      int[] inorder, int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> hm) {
    if (ps > pe || is > ie) return null;
    TreeNode root = new TreeNode(postorder[pe]);
    int ri = hm.get(postorder[pe]);
    root.left = buildTree3(inorder, is, ri - 1, postorder, ps, ps + ri - is - 1, hm);
    root.right = buildTree3(inorder, ri + 1, ie, postorder, ps + ri - is, pe - 1, hm);
    return root;
  }
}
