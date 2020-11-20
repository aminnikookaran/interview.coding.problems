package problems.linkedlists;

import java.util.HashSet;
import java.util.Set;

public class CycleDetection {
  public static class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
      this.data = data;
    }
  }

  public static boolean hasCycle1(SinglyLinkedListNode head) {
    Set<Integer> set = new HashSet<>();
    while (head != null) {
      if (set.contains(head.data)) return true;
      set.add(head.data);
      head = head.next;
    }
    return false;
  }

  public static boolean hasCycle2(SinglyLinkedListNode head) {
    SinglyLinkedListNode slow = head;
    SinglyLinkedListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (fast == slow) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    //    System.out.println(reverse());
  }
}
