package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/different-ways-to-add-parentheses/
public class Q241DifferentWaysToAddParentheses {
  Map<String, List<Integer>> map = new HashMap<>();

  public List<Integer> diffWaysToCompute(String input) {
    if (map.containsKey(input)) return map.get(input);
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '+') {
        List<Integer> left = diffWaysToCompute(input.substring(0, i));
        List<Integer> right = diffWaysToCompute(input.substring(i + 1));
        for (Integer p1 : left) {
          for (Integer p2 : right) {
            int c = 0;
            switch (input.charAt(i)) {
              case '+':
                c = p1 + p2;
                break;
              case '-':
                c = p1 - p2;
                break;
              case '*':
                c = p1 * p2;
                break;
            }
            result.add(c);
          }
        }
      }
    }
    if (result.size() == 0) result.add(Integer.valueOf(input));
    map.put(input, result);
    return result;
  }
}
