package hackerrank.datastructures.trees;

// https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=trees
public class TreesIsThisABinarySearchTree {
  boolean checkBST1(Node root) {
    if (root == null) return true;
    if (root.left != null) if (root.data < root.left.data) return false;
    if (root.right != null) if (root.data >= root.right.data) return false;
    return checkBST1(root.left) && checkBST1(root.right);
  }

  boolean checkBST2(Node root) {
    return checkBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  boolean checkBST2(Node node, int min, int max) {
    if (node == null) return true;
    return min < node.data
        && node.data < max
        && checkBST2(node.left, min, node.data)
        && checkBST2(node.right, node.data, max);
  }
}
