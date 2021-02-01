package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class Q0017LetterCombinationsOfAPhoneNumber {
  public List<String> letterCombinations1(String digits) {
    if (digits == null) return null;
    if (digits.length() == 0) return new ArrayList<>();
    boolean numberValid = true;
    Deque<String> deque = new ArrayDeque<>();
    deque.add("");
    for (int i = 0; i < digits.length(); i++) {
      int size = deque.size();
      for (int j = 0; j < size; j++) {
        String s = deque.poll();
        switch (digits.charAt(i)) {
          case '2':
            deque.add(s + 'a');
            deque.add(s + 'b');
            deque.add(s + 'c');
            break;
          case '3':
            deque.add(s + 'd');
            deque.add(s + 'e');
            deque.add(s + 'f');
            break;
          case '4':
            deque.add(s + 'g');
            deque.add(s + 'h');
            deque.add(s + 'i');
            break;
          case '5':
            deque.add(s + 'j');
            deque.add(s + 'k');
            deque.add(s + 'l');
            break;
          case '6':
            deque.add(s + 'm');
            deque.add(s + 'n');
            deque.add(s + 'o');
            break;
          case '7':
            deque.add(s + 'p');
            deque.add(s + 'q');
            deque.add(s + 'r');
            deque.add(s + 's');
            break;
          case '8':
            deque.add(s + 't');
            deque.add(s + 'u');
            deque.add(s + 'v');
            break;
          case '9':
            deque.add(s + 'w');
            deque.add(s + 'x');
            deque.add(s + 'y');
            deque.add(s + 'z');
            break;
          default:
            numberValid = false;
            break;
        }
        if (!numberValid) break;
      }
      if (!numberValid) break;
    }
    if (!numberValid) return null;
    return new ArrayList<>(deque);
  }

  @SuppressWarnings("serial")
  Map<String, String> phone =
      new HashMap<>() {
        {
          put("2", "abc");
          put("3", "def");
          put("4", "ghi");
          put("5", "jkl");
          put("6", "mno");
          put("7", "pqrs");
          put("8", "tuv");
          put("9", "wxyz");
        }
      };

  List<String> output = new ArrayList<>();

  public void backtrack(String combination, String next_digits) {
    if (next_digits.length() == 0) output.add(combination);
    else {
      String digit = next_digits.substring(0, 1);
      String letters = phone.get(digit);
      for (int i = 0; i < letters.length(); i++) {
        String letter = phone.get(digit).substring(i, i + 1);
        backtrack(combination + letter, next_digits.substring(1));
      }
    }
  }

  public List<String> letterCombinations(String digits) {
    if (digits.length() != 0) backtrack("", digits);
    return output;
  }
}
