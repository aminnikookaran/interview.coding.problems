package cracking.linkedlists;

public class ReturnKthToLast {
  int printKthToLast(LinkedListNode head, int k) {
    if (head == null) return 0;
    int index = printKthToLast(head.next, k) + 1;
    if (index == k) System.out.println(k + "th to last node is " + head.data);
    return index;
  }

  class Index {
    public int value;
  }

  LinkedListNode kthTolast(LinkedListNode head, int k) {
    Index idx = new Index();
    return kthToLast(head, k, idx);
  }

  LinkedListNode kthToLast(LinkedListNode head, int k, Index idx) {
    if (head == null) return null;
    LinkedListNode node = kthToLast(head.next, k, idx);
    idx.value = idx.value + 1;
    if (idx.value == k) return head;
    return node;
  }

  LinkedListNode nthTolast(LinkedListNode head, int k) {
    LinkedListNode pl = head;
    LinkedListNode p2 = head;

    /* Move pl k nodes into the list.*/
    for (int i = 0; i < k; i++) {
      if (pl == null) return null; // Out of bounds
      pl = pl.next;
    }

    /* Move them at the same pace. When pl hits the end, p2 will be at the right
     * element. */
    while (pl != null) {
      pl = pl.next;
      p2 = p2.next;
    }
    return p2;
  }
}
