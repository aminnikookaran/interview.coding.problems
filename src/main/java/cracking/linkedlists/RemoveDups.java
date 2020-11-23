package cracking.linkedlists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {
  void deleteDups1(LinkedListNode n) {
    Set<Integer> set = new HashSet<Integer>();
    LinkedListNode previous = null;
    while (n != null) {
      if (set.contains(n.data)) {
        previous.next = n.next;
      } else {
        set.add(n.data);
        previous = n;
      }
      n = n.next;
    }
  }

  void deleteDups2(LinkedListNode head) {
    LinkedListNode current = head;
    while (current != null) {
      /* Remove all future nodes that have the same value */
      LinkedListNode runner = current;
      while (runner.next != null)
        if (runner.next.data == current.data) runner.next = runner.next.next;
        else runner = runner.next;
      current = current.next;
    }
  }
}
