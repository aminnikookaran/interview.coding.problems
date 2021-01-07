package leetcode.easy;

import leetcode.ListNode;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class Q0083RemoveDuplicatesFromSortedList {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode node = head;
    while (node != null && node.next != null)
      if (node.val == node.next.val) node.next = node.next.next;
      else node = node.next;
    return head;
  }
}
