package problems.linkedlists;

public class FindMergePointofTwoLists {
  public static class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
      this.data = data;
    }
  }

  public static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    SinglyLinkedListNode temp1 = head1;
    SinglyLinkedListNode temp2 = head2;
    while (temp1 != temp2) {
      if (temp1.next == null) temp1 = head2;
      else temp1 = temp1.next;
      if (temp2.next == null) temp2 = head1;
      else temp2 = temp2.next;
    }
    return temp1.data;
  }

  public static void main(String[] args) {
    //    System.out.println(reverse());
  }
}
