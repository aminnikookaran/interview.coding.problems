package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
public class Q0022GenerateParentheses {
  public List<String> generateParenthesis1(int n) {
    List<String> list = new ArrayList<>();
    generateParenthesis1(n, "", 0, 0, list);
    return list;
  }

  public void generateParenthesis1(int n, String string, int open, int close, List<String> list) {
    if (open == n && close == n) list.add(string);
    if (close < open) generateParenthesis1(n, string + ")", open, close + 1, list);
    if (open < n) generateParenthesis1(n, string + "(", open + 1, close, list);
  }

  public List<String> generateParenthesis2(int n) {
    List<String> ans = new ArrayList<>();
    if (n == 0) ans.add("");
    else {
      for (int c = 0; c < n; ++c)
        for (String left : generateParenthesis2(c))
          for (String right : generateParenthesis2(n - 1 - c)) ans.add("(" + left + ")" + right);
    }
    return ans;
  }
}
