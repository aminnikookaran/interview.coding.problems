package leetcode.medium;

import java.util.Stack;

// https://leetcode.com/problems/basic-calculator-ii/
public class Q0227BasicCalculatorII {
  public int calculate1(String s) {
    if (s == null || s.isEmpty()) return 0;
    int len = s.length();
    Stack<Integer> stack = new Stack<>();
    int currentNumber = 0;
    char operation = '+';
    for (int i = 0; i < len; i++) {
      char currentChar = s.charAt(i);
      if (Character.isDigit(currentChar))
        currentNumber = (currentNumber * 10) + (currentChar - '0');
      if (i == len - 1
          || (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar))) {
        if (operation == '-') stack.push(-currentNumber);
        else if (operation == '+') stack.push(currentNumber);
        else if (operation == '*') stack.push(stack.pop() * currentNumber);
        else if (operation == '/') stack.push(stack.pop() / currentNumber);
        operation = currentChar;
        currentNumber = 0;
      }
    }
    int result = 0;
    while (!stack.isEmpty()) result += stack.pop();
    return result;
  }

  public int calculate2(String s) {
    if (s == null || s.isEmpty()) return 0;
    int length = s.length();
    int currentNumber = 0, lastNumber = 0, result = 0;
    char operation = '+';
    for (int i = 0; i < length; i++) {
      char currentChar = s.charAt(i);
      if (Character.isDigit(currentChar))
        currentNumber = (currentNumber * 10) + (currentChar - '0');
      if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar)
          || i == length - 1) {
        if (operation == '+') {
          result += lastNumber;
          lastNumber = currentNumber;
        } else if (operation == '-') {
          result += lastNumber;
          lastNumber = -currentNumber;
        } else if (operation == '*') lastNumber *= currentNumber;
        else if (operation == '/') lastNumber /= currentNumber;
        operation = currentChar;
        currentNumber = 0;
      }
    }
    result += lastNumber;
    return result;
  }
}
