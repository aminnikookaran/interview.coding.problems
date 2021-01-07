package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import leetcode.ListNode;
import leetcode.TreeNode;

// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
public class Q0109ConvertSortedListToBinarySearchTree {
  private ListNode findMiddleElement(ListNode head) {
    ListNode prevPtr = null;
    ListNode slowPtr = head;
    ListNode fastPtr = head;
    while (fastPtr != null && fastPtr.next != null) {
      prevPtr = slowPtr;
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next.next;
    }
    // Handling the case when slowPtr was equal to head.
    if (prevPtr != null) prevPtr.next = null;
    return slowPtr;
  }

  public TreeNode sortedListToBST1(ListNode head) {
    if (head == null) return null;

    // Find the middle element for the list.
    ListNode mid = this.findMiddleElement(head);

    // The mid becomes the root of the BST.
    TreeNode node = new TreeNode(mid.val);

    // Base case when there is just one element in the linked list
    if (head == mid) return node;

    // Recursively form balanced BSTs using the left and right halves of the original list.
    node.left = this.sortedListToBST1(head);
    node.right = this.sortedListToBST1(mid.next);
    return node;
  }

  private List<Integer> values = new ArrayList<Integer>();

  private void mapListToValues(ListNode head) {
    while (head != null) {
      this.values.add(head.val);
      head = head.next;
    }
  }

  private TreeNode convertListToBST2(int left, int right) {
    // Invalid case
    if (left > right) return null;

    // Middle element forms the root.
    int mid = (left + right) / 2;
    TreeNode node = new TreeNode(this.values.get(mid));

    // Base case for when there is only one element left in the array
    if (left == right) return node;

    // Recursively form BST on the two halves
    node.left = convertListToBST2(left, mid - 1);
    node.right = convertListToBST2(mid + 1, right);
    return node;
  }

  public TreeNode sortedListToBST2(ListNode head) {

    // Form an array out of the given linked list and then
    // use the array to form the BST.
    this.mapListToValues(head);

    // Convert the array to
    return convertListToBST2(0, this.values.size() - 1);
  }

  private ListNode head;

  private int findSize(ListNode head) {
    ListNode ptr = head;
    int c = 0;
    while (ptr != null) {
      ptr = ptr.next;
      c += 1;
    }
    return c;
  }

  private TreeNode convertListToBST3(int l, int r) {
    // Invalid case
    if (l > r) return null;

    int mid = (l + r) / 2;

    // First step of simulated inorder traversal. Recursively form
    // the left half
    TreeNode left = this.convertListToBST3(l, mid - 1);

    // Once left half is traversed, process the current node
    TreeNode node = new TreeNode(this.head.val);
    node.left = left;

    // Maintain the invariance mentioned in the algorithm
    this.head = this.head.next;

    // Recurse on the right hand side and form BST out of them
    node.right = this.convertListToBST3(mid + 1, r);
    return node;
  }

  public TreeNode sortedListToBST3(ListNode head) {
    // Get the size of the linked list first
    int size = this.findSize(head);

    this.head = head;

    // Form the BST now that we know the size
    return convertListToBST3(0, size - 1);
  }
}
