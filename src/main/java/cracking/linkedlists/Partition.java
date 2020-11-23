package cracking.linkedlists;

public class Partition {
  LinkedListNode partition1(LinkedListNode node, int x) {
    LinkedListNode beforeStart = null;
    LinkedListNode beforeEnd = null;
    LinkedListNode afterStart = null;
    LinkedListNode afterEnd = null;

    /*Partition list*/
    while (node != null) {
      LinkedListNode next = node.next;
      node.next = null;
      if (node.data < x) {
        /*Insert node into end of before list*/
        if (beforeStart == null) {
          beforeStart = node;
          beforeEnd = beforeStart;
        } else {
          beforeEnd.next = node;
          beforeEnd = node;
        }
      } else {
        /*Insert node into end of after list*/
        if (afterStart == null) {
          afterStart = node;
          afterEnd = afterStart;
        } else {
          afterEnd.next = node;
          afterEnd = node;
        }
      }
      node = next;
    }

    if (beforeStart == null) return afterStart;

    /* Merge before list and after list */
    beforeEnd.next = afterStart;
    return beforeStart;
  }

  LinkedListNode partition2(LinkedListNode node, int x) {
    LinkedListNode head = node;
    LinkedListNode tail = node;

    while (node != null) {
      LinkedListNode next = node.next;
      if (node.data < x) {
        /* Insert node at head. */
        node.next = head;
        head = node;
      } else {
        /* Insert node at tail. */
        tail.next = node;
        tail = node;
      }
      node = next;
    }
    tail.next = null;

    // The head has changed, so we need to return it to the user.
    return head;
  }
}
