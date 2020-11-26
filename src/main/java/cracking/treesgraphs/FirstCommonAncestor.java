package cracking.treesgraphs;

public class FirstCommonAncestor {
  TreeNode commonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
    /* Check if either node is not in the tree, or if one covers the other. */
    if (!covers(root, p) || !covers(root, q)) return null;
    else if (covers(p, q)) return p;
    else if (covers(q, p)) return q;

    /* Traverse upwards until you find a node that covers q. */
    TreeNode sibling = getSibling(p);
    TreeNode parent = p.parent;
    while (!covers(sibling, q)) {
      sibling = getSibling(parent);
      parent = parent.parent;
    }
    return parent;
  }

  boolean covers(TreeNode root, TreeNode p) {
    if (root == null) return false;
    if (root == p) return true;
    return covers(root.left, p) || covers(root.right, p);
  }

  TreeNode getSibling(TreeNode node) {
    if (node == null || node.parent == null) return null;
    TreeNode parent = node.parent;
    return parent.left == node ? parent.right : parent.left;
  }

  TreeNode commonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    /* Error check - one node is not in the tree. */
    if (!covers(root, p) || !covers(root, q)) return null;
    return ancestorHelper(root, p, q);
  }

  TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    boolean pIsOnLeft = covers(root.left, p);
    boolean qlsOnLeft = covers(root.left, q);
    if (pIsOnLeft != qlsOnLeft) return root; // Nodes are on different side
    TreeNode childSide = pIsOnLeft ? root.left : root.right;
    return ancestorHelper(childSide, p, q);
  }

  class Result {
    public TreeNode node;
    public boolean isAncestor;

    public Result(TreeNode n, boolean isAnc) {
      node = n;
      isAncestor = isAnc;
    }
  }

  TreeNode commonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
    Result r = commonAncHelper(root, p, q);
    if (r.isAncestor) return r.node;
    return null;
  }

  Result commonAncHelper(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return new Result(null, false);
    if (root == p && root == q) return new Result(root, true);
    Result rx = commonAncHelper(root.left, p, q);
    if (rx.isAncestor) return rx; // Found common ancestor
    Result ry = commonAncHelper(root.right, p, q);
    if (ry.isAncestor) return ry; // Found common ancestor
    if (rx.node != null && ry.node != null)
      return new Result(root, true); // This is the common ancestor
    else if (root == p || root == q) {
      /* If we're currently at p or q, and we also found one of those nodes in a
       * subtree, then this is truly an ancestor and the flag should be true. */
      boolean isAncestor = rx.node != null || ry.node != null;

      return new Result(root, isAncestor);
    } else return new Result(rx.node != null ? rx.node : ry.node, false);
  }
}
