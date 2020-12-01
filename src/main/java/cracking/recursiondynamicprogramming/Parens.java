package cracking.recursiondynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class Parens {
  void addParen(List<String> list, int leftRem, int rightRem, char[] str, int index) {
    if (leftRem < 0 || rightRem < leftRem) return; // invalid state

    if (leftRem == 0 && rightRem == 0) {
      /*Out of left and right parentheses */
      list.add(String.copyValueOf(str));
    } else {
      str[index] = '('; // Add left and recurse
      addParen(list, leftRem - 1, rightRem, str, index + 1);

      str[index] = ')'; // Add right and recurse
      addParen(list, leftRem, rightRem - 1, str, index + 1);
    }
  }

  List<String> generateParens(int count) {
    char[] str = new char[count * 2];
    List<String> list = new ArrayList<String>();
    addParen(list, count, count, str, 0);
    return list;
  }
}
