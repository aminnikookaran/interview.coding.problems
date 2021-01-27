package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/decode-string/
public class Q0394DecodeString {
  public String decodeString1(String s) {
    Deque<Integer> intStack = new ArrayDeque<>();
    Deque<StringBuilder> strStack = new ArrayDeque<>();
    StringBuilder cur = new StringBuilder();
    int k = 0;
    for (char ch : s.toCharArray()) {
      if (Character.isDigit(ch)) k = k * 10 + ch - '0';
      else if (ch == '[') {
        intStack.push(k);
        strStack.push(cur);
        cur = new StringBuilder();
        k = 0;
      } else if (ch == ']') {
        StringBuilder tmp = cur;
        cur = strStack.pop();
        for (k = intStack.pop(); k > 0; --k) cur.append(tmp);
      } else cur.append(ch);
    }
    return cur.toString();
  }

  public String decodeString2(String s) {
    Deque<Character> queue = new ArrayDeque<>();
    for (char c : s.toCharArray()) queue.offer(c);
    return decodeString2(queue);
  }

  public String decodeString2(Deque<Character> queue) {
    StringBuilder sb = new StringBuilder();
    int num = 0;
    while (!queue.isEmpty()) {
      char c = queue.poll();
      if (Character.isDigit(c)) num = num * 10 + c - '0';
      else if (c == '[') {
        String sub = decodeString2(queue);
        for (int i = 0; i < num; i++) sb.append(sub);
        num = 0;
      } else if (c == ']') break;
      else sb.append(c);
    }
    return sb.toString();
  }
}
