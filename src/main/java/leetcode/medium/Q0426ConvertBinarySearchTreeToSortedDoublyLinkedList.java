package leetcode.medium;

import leetcode.Node;

// https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
public class Q0426ConvertBinarySearchTreeToSortedDoublyLinkedList {
  Node prev = null;
  Node head = null;

  public Node treeToDoublyList(Node root) {
    if (root == null) return root;
    inorder(root);
    head.left = prev;
    prev.right = head;
    return head;
  }

  private void inorder(Node root) {
    if (root == null) return;
    inorder(root.left);
    if (prev == null) head = root;
    else {
      prev.right = root;
      root.left = prev;
    }
    prev = root;
    inorder(root.right);
  }
}
