package leetcode.medium;

import java.util.Stack;
import leetcode.NestedInteger;

// https://leetcode.com/problems/mini-parser/
public class Q0385MiniParser {
  public NestedInteger deserialize1(String s) {
    if (s == null || s.isEmpty()) return null;
    if (s.charAt(0) != '[') // ERROR: special case
    return new NestedInteger(Integer.valueOf(s));

    Stack<NestedInteger> stack = new Stack<>();
    NestedInteger curr = null;
    int l = 0; // l shall point to the start of a number substring;
    // r shall point to the end+1 of a number substring
    for (int r = 0; r < s.length(); r++) {
      char ch = s.charAt(r);
      if (ch == '[') {
        if (curr != null) stack.push(curr);
        curr = new NestedInteger();
        l = r + 1;
      } else if (ch == ']') {
        String num = s.substring(l, r);
        if (!num.isEmpty()) curr.add(new NestedInteger(Integer.valueOf(num)));
        if (!stack.isEmpty()) {
          NestedInteger pop = stack.pop();
          pop.add(curr);
          curr = pop;
        }
        l = r + 1;
      } else if (ch == ',') {
        if (s.charAt(r - 1) != ']') {
          String num = s.substring(l, r);
          curr.add(new NestedInteger(Integer.valueOf(num)));
        }
        l = r + 1;
      }
    }

    return curr;
  }

  public NestedInteger deserialize2(String s) {
    if (s == null || s.isEmpty()) return new NestedInteger();
    Stack<NestedInteger> stack = new Stack<>();
    int sign = 1, len = s.length();
    for (int i = 0; i < len; i++) {
      char c = s.charAt(i);
      if (c == '[') {
        stack.push(new NestedInteger()); // start of a new NestedInteger
      } else if (c == ']' && stack.size() > 1) { // End of a NesterdInteger
        NestedInteger n = stack.pop();
        stack.peek().add(n);
      } else if (c == '-') { // just change the sign
        sign = -1;
      } else if (Character.isDigit(c)) { // if digit check for all the continous ones
        int num = c - '0';
        while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
          num = num * 10 + s.charAt(i + 1) - '0';
          i++;
        }
        num = num * sign;
        if (!stack.isEmpty()) {
          stack.peek().add(new NestedInteger(num)); // add to previous item if not empty
        } else {
          stack.push(new NestedInteger(num));
        }
        sign = 1; // reset the sign
      }
    }
    return stack.isEmpty() ? new NestedInteger() : stack.pop();
  }

  public NestedInteger deserialize3(String s) {
    NestedInteger result = new NestedInteger();
    if (s == null || s.length() == 0) return result;
    if (s.charAt(0) != '[') {
      result.setInteger(Integer.parseInt(s));
    } else if (s.length() > 2) {
      int start = 1, count = 0;
      for (int i = 1; i < s.length(); i++) {
        char c = s.charAt(i);
        if (count == 0 && (c == ',' || i == s.length() - 1)) {
          result.add(deserialize3(s.substring(start, i)));
          start = i + 1;
        } else if (c == '[') count++;
        else if (c == ']') count--;
      }
    }
    return result;
  }
}
