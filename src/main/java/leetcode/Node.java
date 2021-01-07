package leetcode;

import java.util.List;

public class Node {
  public int key;
  public int val;
  public Node left;
  public Node right;
  public Node next;
  public Node prev;
  public Node random;
  public List<Node> neighbors;

  public Node() {}

  public Node(int val) {
    this.val = val;
  }

  public Node(int key, int value) {
    this.key = key;
    this.val = value;
  }

  public Node(int val, Node left, Node right, Node next) {
    this.val = val;
    this.left = left;
    this.right = right;
    this.next = next;
  }

  public Node(int val, List<Node> neighbors) {
    this.val = val;
    this.neighbors = neighbors;
  }
}
