package leetcode.medium;

import leetcode.ListNode;

// https://leetcode.com/problems/add-two-numbers/
public class Q2AddTwoNumbers {
  public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
    ListNode n1 = l1;
    int carry = 0;
    int sum = 0;
    while (l2.next != null) {
      sum = n1.val + l2.val + carry;
      carry = sum > 9 ? 1 : 0;
      n1.val = sum % 10;
      if (n1.next == null) n1.next = new ListNode(0);
      n1 = n1.next;
      l2 = l2.next;
    }
    sum = n1.val + l2.val + carry;
    carry = sum > 9 ? 1 : 0;
    n1.val = sum % 10;
    while (n1.next != null) {
      n1 = n1.next;
      sum = n1.val + carry;
      carry = sum > 9 ? 1 : 0;
      n1.val = sum % 10;
    }
    if (carry > 0) n1.next = new ListNode(1);
    return l1;
  }

  public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
      int x = (p != null) ? p.val : 0;
      int y = (q != null) ? q.val : 0;
      int sum = carry + x + y;
      carry = sum / 10;
      curr.next = new ListNode(sum % 10);
      curr = curr.next;
      if (p != null) p = p.next;
      if (q != null) q = q.next;
    }
    if (carry > 0) curr.next = new ListNode(carry);
    return dummyHead.next;
  }
}
