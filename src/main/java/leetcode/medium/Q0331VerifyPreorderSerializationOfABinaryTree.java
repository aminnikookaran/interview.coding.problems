package leetcode.medium;

import java.util.Stack;

// https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
public class Q0331VerifyPreorderSerializationOfABinaryTree {
  public boolean isValidSerialization1(String preorder) {
    if (preorder == null || preorder.length() == 0) return false;
    Stack<String> st = new Stack<>();
    String[] strs = preorder.split(",");
    for (int pos = 0; pos < strs.length; pos++) {
      String curr = strs[pos];
      while (curr.equals("#") && !st.isEmpty() && st.peek().equals(curr)) {
        st.pop();
        if (st.isEmpty()) return false;
        st.pop();
      }
      st.push(curr);
    }
    return st.size() == 1 && st.peek().equals("#");
  }

  public boolean isValidSerialization2(String preorder) {
    if (preorder == null || preorder.length() == 0) return false;
    String[] strs = preorder.split(",");
    int degree = -1;
    for (String str : strs) {
      degree++;
      if (degree > 0) return false;
      if (!str.equals("#")) degree -= 2;
    }
    return degree == 0;
  }

  public boolean isValidSerialization3(String preorder) {
    if (preorder == null || preorder.length() == 0) return false;
    String[] strs = preorder.split(",");
    int depth = 0;
    int i = 0;
    while (i < strs.length - 1) {
      if (strs[i++].equals("#")) {
        if (depth == 0) return false;
        else depth--;
      } else depth++;
    }
    if (depth != 0) return false;
    return strs[strs.length - 1].equals("#");
  }

  public boolean isValidSerialization4(String preorder) {
    String[] tree = preorder.split(",");
    return valid(tree, 0) == tree.length - 1;
  }

  private int valid(String[] tree, int current) {
    if (current >= tree.length) return -1;
    if ("#".equals(tree[current])) return current;

    // left
    int next = valid(tree, current + 1);
    if (next == -1) return -1;

    // right
    next = valid(tree, next + 1);
    return next == -1 ? -1 : next;
  }
}
