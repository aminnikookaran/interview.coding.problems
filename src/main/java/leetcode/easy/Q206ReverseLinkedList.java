package leetcode.easy;

import leetcode.ListNode;

// https://leetcode.com/problems/reverse-linked-list/
public class Q206ReverseLinkedList {
  public ListNode reverseList1(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode temp1 = head;
    ListNode temp2 = head.next;
    ListNode temp3 = temp2;
    temp1.next = null;
    while (temp2 != null) {
      temp3 = temp3.next;
      temp2.next = temp1;
      temp1 = temp2;
      temp2 = temp3;
    }
    return temp1;
  }

  public ListNode reverseList2(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    ListNode next;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  public ListNode reverseList3(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList3(head.next);
    head.next.next = head;
    head.next = null;
    return p;
  }
}
