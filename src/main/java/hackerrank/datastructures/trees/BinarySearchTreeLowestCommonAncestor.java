package hackerrank.datastructures.trees;

// https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=trees
public class BinarySearchTreeLowestCommonAncestor {
  public static Node lca1(Node root, int v1, int v2) {
    if (root == null) return null;
    if (root.data == v1 || root.data == v2) return root;
    if (v1 < root.data && v2 < root.data) return lca1(root.left, v1, v2);
    if (v1 > root.data && v2 > root.data) return lca1(root.right, v1, v2);
    return root;
  }

  public static Node lca2(Node root, int v1, int v2) {
    while (true)
      if (v1 < root.data && v2 < root.data) root = root.left;
      else if (v1 > root.data && v2 > root.data) root = root.right;
      else return root;
  }
}
