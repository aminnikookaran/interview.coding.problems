package leetcode.easy;

import leetcode.ListNode;

// https://leetcode.com/problems/delete-node-in-a-linked-list/
public class Q237DeleteNodeInALinkedList {
  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }
}
