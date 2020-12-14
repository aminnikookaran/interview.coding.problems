package leetcode.easy;

import leetcode.ListNode;

// https://leetcode.com/problems/remove-linked-list-elements/
public class Q203RemoveLinkedListElements {
  public ListNode removeElements(ListNode head, int val) {
    ListNode temp = new ListNode();
    temp.next = head;
    head = temp;
    while (temp.next != null) {
      if (temp.next.val == val) temp.next = temp.next.next;
      else temp = temp.next;
    }
    return head.next;
  }
}
