package leetcode;

public class Node {
  public int key;
  public int val;
  public Node left;
  public Node right;
  public Node next;
  public Node prev;
  public Node random;

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
}
