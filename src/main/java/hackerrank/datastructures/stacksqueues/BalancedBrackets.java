package hackerrank.datastructures.stacksqueues;

import java.util.ArrayDeque;
import java.util.Deque;

// https://www.hackerrank.com/challenges/balanced-brackets/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=stacks-queues
public class BalancedBrackets {
  static String isBalanced(String s) {
    Deque<Character> deque = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      switch (c) {
        case ')':
          if (deque.peek() == null || deque.peek() != '(') return "NO";
          deque.pop();
          break;
        case ']':
          if (deque.peek() == null || deque.peek() != '[') return "NO";
          deque.pop();
          break;
        case '}':
          if (deque.peek() == null || deque.peek() != '{') return "NO";
          deque.pop();
          break;
        default:
          deque.push(c);
          break;
      }
    }
    if (deque.size() == 0) return "YES";
    return "NO";
  }

  public static void main(String[] args) {
    System.out.println(isBalanced("}][}}(}][))]"));
  }
}
