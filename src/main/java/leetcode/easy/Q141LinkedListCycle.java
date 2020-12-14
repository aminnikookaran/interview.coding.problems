package leetcode.easy;

import java.util.HashSet;
import java.util.Set;
import leetcode.ListNode;

// https://leetcode.com/problems/linked-list-cycle/
public class Q141LinkedListCycle {
  public boolean hasCycle1(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) return true;
    }
    return false;
  }

  public boolean hasCycle2(ListNode head) {
    Set<ListNode> nodesSeen = new HashSet<>();
    while (head != null) {
      if (nodesSeen.contains(head)) return true;
      else nodesSeen.add(head);
      head = head.next;
    }
    return false;
  }
}
