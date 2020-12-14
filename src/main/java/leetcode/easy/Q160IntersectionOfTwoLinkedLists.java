package leetcode.easy;

import java.util.HashSet;
import java.util.Set;
import leetcode.ListNode;

// https://leetcode.com/problems/intersection-of-two-linked-lists/
public class Q160IntersectionOfTwoLinkedLists {
  public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;

    ListNode node1 = headA;
    int sizeA = 0;
    while (node1 != null) {
      node1 = node1.next;
      sizeA++;
    }

    ListNode node2 = headB;
    int sizeB = 0;
    while (node2 != null) {
      node2 = node2.next;
      sizeB++;
    }

    node1 = headA;
    node2 = headB;
    while (sizeA > sizeB) {
      node1 = node1.next;
      sizeA--;
    }
    while (sizeB > sizeA) {
      node2 = node2.next;
      sizeB--;
    }

    while (node1 != null && node2 != null) {
      if (node1 == node2) return node1;
      node1 = node1.next;
      node2 = node2.next;
    }

    return null;
  }

  public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;

    Set<ListNode> set = new HashSet<>();
    while (headA != null) {
      set.add(headA);
      headA = headA.next;
    }

    while (headB != null) {
      if (set.contains(headB)) return headB;
      headB = headB.next;
    }

    return null;
  }
}
