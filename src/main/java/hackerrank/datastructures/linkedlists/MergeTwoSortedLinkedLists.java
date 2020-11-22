package hackerrank.datastructures.linkedlists;

// https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem
public class MergeTwoSortedLinkedLists {
  public static class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
      this.data = data;
    }
  }

  public static SinglyLinkedListNode mergeLists(
      SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    if (head1 == null) return head2;
    if (head2 == null) return head1;
    if (head2.data < head1.data) {
      SinglyLinkedListNode temp = head1;
      head1 = head2;
      head2 = temp;
    }
    SinglyLinkedListNode head = head1;
    SinglyLinkedListNode prehead1 = head1;
    head1 = head1.next;
    while (head1 != null && head2 != null) {
      if (head1.data <= head2.data) {
        head1 = head1.next;
      } else {
        prehead1.next = head2;
        head2 = head2.next;
        prehead1.next.next = head1;
      }
      prehead1 = prehead1.next;
    }
    if (head2 != null) prehead1.next = head2;

    return head;
  }

  public static SinglyLinkedListNode sortedMerge(
      SinglyLinkedListNode headA, SinglyLinkedListNode headB) {
    SinglyLinkedListNode head = new SinglyLinkedListNode(0);
    SinglyLinkedListNode tail = head;
    while (headA != null && headB != null) {
      if (headA.data < headB.data) {
        tail.next = headA;
        headA = headA.next;
      } else {
        tail.next = headB;
        headB = headB.next;
      }
      tail = tail.next;
    }
    if (headA != null) tail.next = headA;
    if (headB != null) tail.next = headB;
    return head.next;
  }

  public SinglyLinkedListNode SortedMerge(SinglyLinkedListNode A, SinglyLinkedListNode B) {
    if (A == null) return B;
    if (B == null) return A;

    if (A.data < B.data) {
      A.next = SortedMerge(A.next, B);
      return A;
    } else {
      B.next = SortedMerge(A, B.next);
      return B;
    }
  }

  public static void main(String[] args) {
    //    System.out.println(reverse());
  }
}
