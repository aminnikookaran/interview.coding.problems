package leetcode.medium;

import leetcode.ListNode;

// https://leetcode.com/problems/partition-list/
public class Q0086PartitionList {
  public ListNode partition(ListNode head, int x) {
    ListNode smallerHead = new ListNode(0);
    ListNode smallerTail = smallerHead;
    ListNode greaterHead = new ListNode(0);
    ListNode greaterTail = greaterHead;
    while (head != null) {
      if (head.val < x) {
        smallerTail.next = head;
        smallerTail = smallerTail.next;
      } else {
        greaterTail.next = head;
        greaterTail = greaterTail.next;
      }
      head = head.next;
    }
    greaterTail.next = null;
    smallerTail.next = greaterHead.next;
    return smallerHead.next;
  }
}
