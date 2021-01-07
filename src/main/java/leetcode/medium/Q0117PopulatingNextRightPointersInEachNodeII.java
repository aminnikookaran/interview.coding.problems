package leetcode.medium;

import leetcode.Node;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
public class Q0117PopulatingNextRightPointersInEachNodeII {
  public Node connect(Node root) {
    if (root == null) return root;
    Node parent = root;
    Node row = new Node(0);
    Node child = row;
    while (parent != null) {
      if (parent.left != null) {
        child.next = parent.left;
        child = child.next;
      }
      if (parent.right != null) {
        child.next = parent.right;
        child = child.next;
      }
      parent = parent.next;
      if (parent == null) {
        parent = row.next;
        row.next = null;
        child = row;
      }
    }
    return root;
  }
}
