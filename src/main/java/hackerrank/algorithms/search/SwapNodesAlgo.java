package hackerrank.algorithms.search;

import java.util.List;

// https://www.hackerrank.com/challenges/swap-nodes-algo/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=search
public class SwapNodesAlgo {
  public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
    }
  }

  public static void inOrderTraverse(Node root, List<Integer> list) {
    if (root == null) return;
    inOrderTraverse(root.left, list);
    list.add(root.value);
    inOrderTraverse(root.right, list);
  }

  public static int[][] swapNodes(int[][] indexes, int[] queries) {
    return indexes;
  }
}
