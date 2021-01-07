package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/simplify-path/
public class Q0071SimplifyPath {
  public String simplifyPath(String path) {
    Deque<String> stack = new ArrayDeque<>();
    for (String s : path.split("/")) {
      if (s.equals("..")) stack.poll();
      else if (!s.equals("") && !s.equals(".")) stack.push(s);
    }
    StringBuilder sb = new StringBuilder();
    if (stack.size() == 0) return "/";
    while (stack.size() != 0) sb.append("/").append(stack.pollLast());
    return sb.toString();
  }
}
