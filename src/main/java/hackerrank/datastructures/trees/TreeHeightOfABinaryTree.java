package hackerrank.datastructures.trees;

import java.util.ArrayDeque;
import java.util.Deque;

// https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=trees
public class TreeHeightOfABinaryTree {
  public static int height1(Node root) {
    if (root == null) return -1;
    Deque<Node> deque1 = new ArrayDeque<>();
    Deque<Node> deque2 = new ArrayDeque<>();
    deque1.add(root);
    int max = -1;
    while (!deque1.isEmpty()) {
      Node node = deque1.poll();
      if (node.left != null) deque2.add(node.left);
      if (node.right != null) deque2.add(node.right);
      if (deque1.isEmpty()) {
        max++;
        deque1 = deque2;
        deque2 = new ArrayDeque<>();
      }
    }
    return max;
  }

  public static int height(Node root) {
    if (root == null) return -1;
    return 1 + Math.max(height(root.left), height(root.right));
  }
}
