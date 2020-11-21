package problems.linkedlists;

public class InsertingaNodeIntoaSortedDoublyLinkedList {
  public static class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int data) {
      this.data = data;
    }
  }

  public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
    DoublyLinkedListNode node = new DoublyLinkedListNode(data);
    if (head == null) return node;
    else if (head.data >= data) {
      node.next = head;
      head.prev = node;
      return node;
    } else {
      DoublyLinkedListNode temp = head;
      while (temp.next != null && temp.next.data < data) temp = temp.next;
      if (temp.next == null) {
        node.prev = temp;
        temp.next = node;
      } else {
        node.next = temp.next;
        node.prev = temp;
        temp.next = node;
        node.next.prev = node;
      }
      return head;
    }
  }

  public static void main(String[] args) {
    //    System.out.println(reverse());
  }
}
