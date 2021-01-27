package leetcode.medium;

import leetcode.ListNode;

// https://leetcode.com/problems/plus-one-linked-list/
public class Q0369PlusOneLinkedList {
  public ListNode plusOne1(ListNode head) {
    ListNode h2 = reverse(head);
    ListNode p = h2;
    while (p != null) {
      if (p.val + 1 <= 9) {
        p.val = p.val + 1;
        break;
      } else {
        p.val = 0;
        if (p.next == null) {
          p.next = new ListNode(1);
          break;
        }
        p = p.next;
      }
    }
    return reverse(h2);
  }

  public ListNode reverse(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p1 = head;
    ListNode p2 = p1.next;
    while (p2 != null) {
      ListNode t = p2.next;
      p2.next = p1;
      p1 = p2;
      p2 = t;
    }
    head.next = null;
    return p1;
  }

  public ListNode plusOne2(ListNode head) {
    int sum = plusOne2(head, 1);
    if (sum == 1) head = new ListNode(1, head);
    return head;
  }

  public int plusOne2(ListNode head, int carry) {
    if (head == null) return 1;
    int result = head.val + plusOne2(head.next, carry);
    head.val %= 10;
    return result / 10;
  }
}
