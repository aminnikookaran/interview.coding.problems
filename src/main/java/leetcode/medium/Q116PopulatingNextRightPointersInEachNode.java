package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import leetcode.Node;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class Q116PopulatingNextRightPointersInEachNode {
  public Node connect1(Node root) {
    if (root == null) return null;
    Deque<Node> deque = new ArrayDeque<>();
    deque.add(root);
    while (!deque.isEmpty()) {
      Node prev = null;
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        Node curr = deque.poll();
        curr.next = prev;
        if (curr.right != null) deque.add(curr.right);
        if (curr.left != null) deque.add(curr.left);
        prev = curr;
      }
    }
    return root;
  }

  public void connect(Node root) {
    if (root == null) return;
    LinkedList<Node> nodeQueue = new LinkedList<>();
    LinkedList<Integer> depthQueue = new LinkedList<>();
    if (root != null) {
      nodeQueue.offer(root);
      depthQueue.offer(1);
    }
    while (!nodeQueue.isEmpty()) {
      Node topNode = nodeQueue.poll();
      int depth = depthQueue.poll();
      if (depthQueue.isEmpty()) topNode.next = null;
      else if (depthQueue.peek() > depth) topNode.next = null;
      else topNode.next = nodeQueue.peek();

      if (topNode.left != null) {
        nodeQueue.offer(topNode.left);
        depthQueue.offer(depth + 1);
      }
      if (topNode.right != null) {
        nodeQueue.offer(topNode.right);
        depthQueue.offer(depth + 1);
      }
    }
  }

  public void connect3(Node root) {
    if (root == null) return;
    Node lastHead = root; // previous level's head
    Node lastCurrent = null; // previous level's pointer
    Node currentHead = null; // current level's head
    Node current = null; // current level's pointer
    while (lastHead != null) {
      lastCurrent = lastHead;
      while (lastCurrent != null) {
        if (currentHead == null) {
          currentHead = lastCurrent.left;
          current = lastCurrent.left;
        } else {
          current.next = lastCurrent.left;
          current = current.next;
        }
        if (currentHead != null) {
          current.next = lastCurrent.right;
          current = current.next;
        }
        lastCurrent = lastCurrent.next;
      }
      // update last head
      lastHead = currentHead;
      currentHead = null;
    }
  }
}
