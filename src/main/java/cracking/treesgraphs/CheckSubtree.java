package cracking.treesgraphs;

public class CheckSubtree {
  boolean containsTree1(TreeNode tl, TreeNode t2) {
    StringBuilder string1 = new StringBuilder();
    StringBuilder string2 = new StringBuilder();

    getOrderString(tl, string1);
    getOrderString(t2, string2);

    return string1.indexOf(string2.toString()) != -1;
  }

  void getOrderString(TreeNode node, StringBuilder sb) {
    if (node == null) {
      sb.append("X"); // Add null indicator
      return;
    }
    sb.append(node.data + " "); // Add root
    getOrderString(node.left, sb); // Add left
    getOrderString(node.right, sb); // Add right
  }

  boolean containsTree2(TreeNode tl, TreeNode t2) {
    if (t2 == null) return true; // The empty tree is always a subtree
    return subTree(tl, t2);
  }

  boolean subTree(TreeNode rl, TreeNode r2) {
    if (rl == null) return false; // big tree empty & subtree still not found.
    else if (rl.data == r2.data && matchTree(rl, r2)) return true;
    return subTree(rl.left, r2) || subTree(rl.right, r2);
  }

  boolean matchTree(TreeNode rl, TreeNode r2) {
    if (rl == null && r2 == null) return true; // nothing left in the subtree
    else if (rl == null || r2 == null)
      return false; // exactly tree is empty, therefore trees don't match
    else if (rl.data != r2.data) return false; // data doesn't match
    else return matchTree(rl.left, r2.left) && matchTree(rl.right, r2.right);
  }
}
