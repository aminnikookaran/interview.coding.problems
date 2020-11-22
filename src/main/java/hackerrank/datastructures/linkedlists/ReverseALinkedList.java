package hackerrank.datastructures.linkedlists;

// https://www.hackerrank.com/challenges/reverse-a-linked-list/problem
public class ReverseALinkedList {
  public static class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
      this.data = data;
    }
  }

  public static SinglyLinkedListNode reverse1(SinglyLinkedListNode node) {
    SinglyLinkedListNode prev = null;
    SinglyLinkedListNode current = node;
    SinglyLinkedListNode next = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    node = prev;
    return node;
  }

  public static SinglyLinkedListNode reverse2(SinglyLinkedListNode head) {
    if (head == null || head.next == null) return head;
    SinglyLinkedListNode rest = reverse2(head.next);
    head.next.next = head;
    head.next = null;
    return rest;
  }

  public static void main(String[] args) {
    //    System.out.println(reverse());
  }
}
