package hackerrank.datastructures.trees;

// https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=trees
public class TreeLowestCommonAncestor {
  public static Node lca(Node root, int v1, int v2) {
    if (root == null) return null;
    if (root.data == v1 || root.data == v2) return root;
    boolean foundV1 = find(root.left, v1);
    boolean foundV2 = find(root.left, v2);
    if (foundV1 && foundV2) return lca(root.left, v1, v2);
    if (!foundV1 && !foundV2) return lca(root.right, v1, v2);
    return root;
  }

  public static boolean find(Node root, int v) {
    if (root == null) return false;
    if (root.data == v) return true;
    return find(root.left, v) || find(root.right, v);
  }
}
