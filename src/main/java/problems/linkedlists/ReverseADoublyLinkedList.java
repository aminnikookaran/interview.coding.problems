package problems.linkedlists;

public class ReverseADoublyLinkedList {
  public static class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int data) {
      this.data = data;
    }
  }

  public static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
    if (head == null) return null;
    while (head.next != null) {
      DoublyLinkedListNode temp = head.next;
      head.next = head.prev;
      head.prev = temp;
      head = temp;
    }
    head.next = head.prev;
    head.prev = null;
    return head;
  }

  public static void main(String[] args) {
    //    System.out.println(reverse());
  }
}
