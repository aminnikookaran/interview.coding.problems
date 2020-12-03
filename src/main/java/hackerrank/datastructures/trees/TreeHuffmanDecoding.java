package hackerrank.datastructures.trees;

// https://www.hackerrank.com/challenges/tree-huffman-decoding/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=trees
public class TreeHuffmanDecoding {
  void decode1(String s, Node root) {
    StringBuilder stringBuilder = new StringBuilder();
    Node node = root;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') node = node.left;
      else node = node.right;
      if (node.data != '\0') {
        stringBuilder.append(node.data);
        node = root;
      }
    }
    System.out.println(stringBuilder);
  }

  void decode2(String s, Node root) {
    StringBuilder stringBuilder = new StringBuilder();
    Node node = root;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') node = node.left;
      else node = node.right;
      if (node.left == null && node.right == null) {
        stringBuilder.append(node.data);
        node = root;
      }
    }
    System.out.println(stringBuilder);
  }

  public Node originalNode;

  void decode3(String S, Node root) {
    originalNode = root;
    decodeHelper(S, root);
  }

  void decodeHelper(String S, Node root) {
    if (S.isEmpty()) {
      if (root.data != '\0') System.out.print(root.data);
    } else {
      if (root.data != '\0') {
        System.out.print(root.data);
        decodeHelper(S, originalNode);
      } else {
        char c = S.charAt(0);
        if (c == '0') decodeHelper(S.substring(1), root.left);
        else decodeHelper(S.substring(1), root.right);
      }
    }
  }
}
