package leetcode.medium;

import leetcode.ListNode;

// https://leetcode.com/problems/reverse-linked-list-ii/
public class Q0092ReverseLinkedListII {
  public ListNode reverseBetween1(ListNode head, int m, int n) {
    if (m <= 1) return reverseN(head, n - m + 1);
    head.next = reverseBetween1(head.next, m - 1, n - 1);
    return head;
  }

  ListNode successor = null;

  ListNode reverseN(ListNode head, int n) {
    if (n == 1) {
      successor = head.next;
      return head;
    }
    ListNode last = reverseN(head.next, n - 1);
    head.next.next = head;
    head.next = successor;
    return last;
  }

  public ListNode reverseBetween2(ListNode head, int m, int n) {
    if (head == null) return null;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    for (int i = 0; i < m - 1; i++) pre = pre.next;
    ListNode start = pre.next;
    ListNode then = start.next;
    for (int i = 0; i < n - m; i++) {
      start.next = then.next;
      then.next = pre.next;
      pre.next = then;
      then = start.next;
    }
    return dummy.next;
  }
}
