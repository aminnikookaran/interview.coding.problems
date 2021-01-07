package leetcode.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import leetcode.TreeNode;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class Q0105ConstructBinaryTreeFromPreorderAndInorderTraversal {
  public TreeNode buildTree1(int[] preorder, int[] inorder) {
    return buildTree1(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
  }

  public TreeNode buildTree1(
      int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
    if (preLeft > preRight || inLeft > inRight) return null;
    TreeNode node = new TreeNode(preorder[preLeft]);
    int i = inLeft;
    while (i <= inRight)
      if (inorder[i] == preorder[preLeft]) break;
      else i++;
    node.left = buildTree1(preorder, inorder, preLeft + 1, preLeft + (i - inLeft), inLeft, i - 1);
    node.right =
        buildTree1(preorder, inorder, preLeft + (i - inLeft) + 1, preRight, i + 1, inRight);
    return node;
  }

  public TreeNode buildTree2(int[] preorder, int[] inorder) {
    int preStart = 0;
    int preEnd = preorder.length - 1;
    int inStart = 0;
    int inEnd = inorder.length - 1;
    return construct(preorder, preStart, preEnd, inorder, inStart, inEnd);
  }

  public TreeNode construct(
      int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
    if (preStart > preEnd || inStart > inEnd) return null;
    int val = preorder[preStart];
    TreeNode p = new TreeNode(val);
    // find parent element index from inorder
    int k = 0;
    for (int i = 0; i < inorder.length; i++) {
      if (val == inorder[i]) {
        k = i;
        break;
      }
    }
    p.left = construct(preorder, preStart + 1, preStart + (k - inStart), inorder, inStart, k - 1);
    p.right = construct(preorder, preStart + (k - inStart) + 1, preEnd, inorder, k + 1, inEnd);
    return p;
  }

  static Set<TreeNode> set = new HashSet<>();
  static Stack<TreeNode> stack = new Stack<>();

  // Function to build tree using given traversal
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    TreeNode root = null;
    for (int pre = 0, in = 0; pre < preorder.length; ) {
      TreeNode node = null;
      do {
        node = new TreeNode(preorder[pre]);
        if (root == null) root = node;

        if (!stack.isEmpty()) {
          if (set.contains(stack.peek())) {
            set.remove(stack.peek());
            stack.pop().right = node;
          } else stack.peek().left = node;
        }
        stack.push(node);
      } while (preorder[pre++] != inorder[in] && pre < preorder.length);

      node = null;
      while (!stack.isEmpty() && in < inorder.length && stack.peek().val == inorder[in]) {
        node = stack.pop();
        in++;
      }

      if (node != null) {
        set.add(node);
        stack.push(node);
      }
    }

    return root;
  }
}
