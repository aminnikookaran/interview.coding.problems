package leetcode.easy;

// https://leetcode.com/problems/merge-two-sorted-lists/
public class Q0021MergeTwoSortedLists {
  public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode();
    ListNode l = head;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        l.next = l1;
        l1 = l1.next;
      } else {
        l.next = l2;
        l2 = l2.next;
      }
      l = l.next;
    }
    if (l1 != null) l.next = l1;
    if (l2 != null) l.next = l2;
    return head.next;
  }

  public ListNode SortedMerge(ListNode A, ListNode B) {
    if (A == null) return B;
    if (B == null) return A;
    if (A.val < B.val) {
      A.next = SortedMerge(A.next, B);
      return A;
    } else {
      B.next = SortedMerge(A, B.next);
      return B;
    }
  }
}
