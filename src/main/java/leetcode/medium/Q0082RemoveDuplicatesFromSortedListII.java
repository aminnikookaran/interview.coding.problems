package leetcode.medium;

import leetcode.ListNode;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class Q0082RemoveDuplicatesFromSortedListII {
  class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      ListNode tempHead = new ListNode(0, head);
      ListNode temp = tempHead;
      while (head != null) {
        if (head.next != null && head.val == head.next.val) {
          while (head.next != null && head.val == head.next.val) head = head.next;
          temp.next = head.next;
        } else temp = temp.next;
        head = head.next;
      }
      return tempHead.next;
    }
  }
}
