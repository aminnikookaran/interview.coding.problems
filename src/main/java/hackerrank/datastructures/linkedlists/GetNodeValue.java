package hackerrank.datastructures.linkedlists;

// https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem
public class GetNodeValue {
  public static class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
      this.data = data;
    }
  }

  public static int getNode(SinglyLinkedListNode head, int positionFromTail) {
    SinglyLinkedListNode temp = head;
    int size = 0;
    while (temp != null) {
      temp = temp.next;
      size++;
    }
    if (positionFromTail >= size) return -1;
    int positionFromHead = size - positionFromTail - 1;
    temp = head;
    while (positionFromHead > 0) {
      temp = temp.next;
      positionFromHead--;
    }
    return temp.data;
  }

  public static void main(String[] args) {
    //    System.out.println(reverse());
  }
}
