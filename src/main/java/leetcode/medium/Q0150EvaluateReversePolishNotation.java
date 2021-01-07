package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/
public class Q0150EvaluateReversePolishNotation {
  public int evalRPN(String[] tokens) {
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < tokens.length; i++) {
      if (tokens[i].equals("+")) {
        int number2 = deque.pop();
        int number1 = deque.pop();
        deque.push(number1 + number2);
      } else if (tokens[i].equals("-")) {
        int number2 = deque.pop();
        int number1 = deque.pop();
        deque.push(number1 - number2);
      } else if (tokens[i].equals("*")) {
        int number2 = deque.pop();
        int number1 = deque.pop();
        deque.push(number1 * number2);
      } else if (tokens[i].equals("/")) {
        int number2 = deque.pop();
        int number1 = deque.pop();
        deque.push(number1 / number2);
      } else {
        deque.push(Integer.parseInt(tokens[i]));
      }
    }
    return deque.pop();
  }
}
