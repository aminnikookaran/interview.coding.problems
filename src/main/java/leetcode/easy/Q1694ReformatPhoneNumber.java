package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/reformat-phone-number/
public class Q1694ReformatPhoneNumber {
  public String reformatNumber1(String number) {
    StringBuilder stringBuilder = new StringBuilder();
    int i = 0;
    for (i = 0; i < number.length(); i++)
      if (number.charAt(i) >= '0' && number.charAt(i) <= '9')
        stringBuilder.append(number.charAt(i));
    for (i = 3; i <= stringBuilder.length() - 2; i += 4) stringBuilder.insert(i, '-');
    if (i == stringBuilder.length() - 1) stringBuilder.insert(i - 1, '-');
    return stringBuilder.toString();
  }

  public String reformatNumber2(String number) {
    return number.replaceAll("\\D", "").replaceAll("...?(?=..)", "$0-");
  }

  public String reformatNumber3(String number) {
    Deque<Character> deque = new ArrayDeque<>();
    for (int i = 0; i < number.length(); i++)
      if (Character.isDigit(number.charAt(i))) deque.add(number.charAt(i));
    StringBuilder stringBuilder = new StringBuilder();
    while (deque.size() > 4)
      stringBuilder.append(deque.poll()).append(deque.poll()).append(deque.poll()).append('-');
    if (deque.size() == 4) stringBuilder.append(deque.poll()).append(deque.poll()).append('-');
    while (!deque.isEmpty()) stringBuilder.append(deque.poll());
    return stringBuilder.toString();
  }
}
