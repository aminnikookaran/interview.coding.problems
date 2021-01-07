package leetcode.medium;

import leetcode.ListNode;

// https://leetcode.com/problems/odd-even-linked-list/
public class Q0328OddEvenLinkedList {
  public ListNode oddEvenList1(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode oddNodes = head;
    ListNode evenNodes = head.next;
    ListNode oddTemp = oddNodes;
    ListNode evenTemp = evenNodes;
    while (true) {
      if (oddTemp.next == null) break;
      oddTemp.next = oddTemp.next.next;
      if (oddTemp.next == null) break;
      oddTemp = oddTemp.next;
      if (evenTemp.next == null) break;
      evenTemp.next = evenTemp.next.next;
      if (evenTemp.next == null) break;
      evenTemp = evenTemp.next;
    }
    oddTemp.next = evenNodes;
    return oddNodes;
  }

  public ListNode oddEvenList2(ListNode head) {
    if (head == null) return null;
    ListNode odd = head, even = head.next, evenHead = even;
    while (even != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }
    odd.next = evenHead;
    return head;
  }
}
