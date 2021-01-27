package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import leetcode.ListNode;

// https://leetcode.com/problems/linked-list-random-node/
public class Q0382LinkedListRandomNode {
  class Solution1 {
    private List<Integer> range = new ArrayList<>();

    /**
     * @param head The linked list's head. Note that the head is guaranteed to be not null, so it
     *     contains at least one node.
     */
    public Solution1(ListNode head) {
      while (head != null) {
        this.range.add(head.val);
        head = head.next;
      }
    }

    /** Returns a random node's value. */
    public int getRandom() {
      int pick = (int) (Math.random() * this.range.size());
      return this.range.get(pick);
    }
  }

  class Solution2 {
    private ListNode head;

    /**
     * @param head The linked list's head. Note that the head is guaranteed to be not null, so it
     *     contains at least one node.
     */
    public Solution2(ListNode head) {
      this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
      int scope = 1, chosenValue = 0;
      ListNode curr = this.head;
      while (curr != null) {
        // decide whether to include the element in reservoir
        if (Math.random() < 1.0 / scope) chosenValue = curr.val;
        // move on to the next node
        scope += 1;
        curr = curr.next;
      }
      return chosenValue;
    }
  }
}
