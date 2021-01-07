package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import leetcode.Node;

// https://leetcode.com/problems/copy-list-with-random-pointer/
public class Q0138CopyListWithRandomPointer {
  public Node copyRandomList1(Node head) {
    Map<Node, Node> map = new HashMap<>();
    return copyRandomList1(head, map);
  }

  public Node copyRandomList1(Node head, Map<Node, Node> map) {
    if (head == null) return null;
    Node node = map.get(head);
    if (node != null) return node;
    node = new Node(head.val);
    map.put(head, node);
    node.next = copyRandomList1(head.next, map);
    node.random = copyRandomList1(head.random, map);
    return node;
  }

  public Node copyRandomList2(Node head) {
    if (head == null) return null;
    Node p = head;
    // copy every node and insert to list
    while (p != null) {
      Node copy = new Node(p.val);
      copy.next = p.next;
      p.next = copy;
      p = copy.next;
    }
    // copy random pointer for each new node
    p = head;
    while (p != null) {
      if (p.random != null) p.next.random = p.random.next;
      p = p.next.next;
    }
    // break list to two
    p = head;
    Node newHead = head.next;
    while (p != null) {
      Node temp = p.next;
      p.next = temp.next;
      if (temp.next != null) temp.next = temp.next.next;
      p = p.next;
    }
    return newHead;
  }

  public Node copyRandomList3(Node head) {
    if (head == null) return null;
    Map<Node, Node> map = new HashMap<>();
    Node newHead = new Node(head.val);
    Node p = head;
    Node q = newHead;
    map.put(head, newHead);
    p = p.next;
    while (p != null) {
      Node temp = new Node(p.val);
      map.put(p, temp);
      q.next = temp;
      q = temp;
      p = p.next;
    }
    p = head;
    q = newHead;
    while (p != null) {
      if (p.random != null) q.random = map.get(p.random);
      else q.random = null;
      p = p.next;
      q = q.next;
    }
    return newHead;
  }
}
