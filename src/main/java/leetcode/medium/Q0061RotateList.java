package leetcode.medium;

import leetcode.ListNode;

// https://leetcode.com/problems/rotate-list/
public class Q0061RotateList {
  public ListNode rotateRight1(ListNode head, int k) {
    if (head == null || head.next == null) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy, slow = dummy;
    int i;
    for (i = 0; fast.next != null; i++) fast = fast.next;
    for (int j = i - k % i; j > 0; j--) slow = slow.next;
    fast.next = dummy.next;
    dummy.next = slow.next;
    slow.next = null;
    return dummy.next;
  }

  public ListNode rotateRight2(ListNode head, int k) {
    if (head == null || k == 0) return head;
    ListNode p = head;
    int len;
    for (len = 0; p.next != null; len++) p = p.next;
    p.next = head;
    k %= len;
    for (int i = 0; i < len - k; i++) p = p.next;
    head = p.next;
    p.next = null;
    return head;
  }
}
