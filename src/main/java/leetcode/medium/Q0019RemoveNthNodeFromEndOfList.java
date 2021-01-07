package leetcode.medium;

import leetcode.ListNode;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class Q0019RemoveNthNodeFromEndOfList {
  public ListNode removeNthFromEnd1(ListNode head, int n) {
    if (head == null) return head;
    ListNode node1 = head;
    int i = 0;
    for (i = 0; i < n && node1.next != null; i++) node1 = node1.next;
    if (i == n - 1) return head.next;
    if (i < n - 1) return head;
    ListNode node2 = head;
    while (node1.next != null) {
      node1 = node1.next;
      node2 = node2.next;
    }
    node2.next = node2.next.next;
    return head;
  }

  public ListNode removeNthFromEnd2(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    int length = 0;
    ListNode first = head;
    while (first != null) {
      length++;
      first = first.next;
    }
    length -= n;
    first = dummy;
    while (length > 0) {
      length--;
      first = first.next;
    }
    first.next = first.next.next;
    return dummy.next;
  }

  public ListNode removeNthFromEnd3(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;
    for (int i = 0; i <= n; i++) first = first.next;
    while (first != null) {
      first = first.next;
      second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
  }
}
