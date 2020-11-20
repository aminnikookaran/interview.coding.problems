package problems.strings;

import java.util.ArrayList;
import java.util.List;

public class AddBinaryStringsProblem {
  public static String addBinary(String A, String B) {
    if (B.length() > A.length()) {
      String temp = A;
      A = B;
      B = temp;
    }
    List<Integer> numbers = new ArrayList<>();
    int carry = 0;
    for (int i = 0; i < A.length(); i++) {
      int bDigit = 0;
      if (i < B.length()) bDigit = B.charAt(B.length() - i - 1) - '0';
      int aDigit = A.charAt(A.length() - i - 1) - '0';
      int sum = carry + aDigit + bDigit;
      carry = sum / 2;
      numbers.add(sum % 2);
    }
    if (carry > 0) numbers.add(carry);
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < numbers.size(); i++) ans.append(numbers.get(numbers.size() - i - 1));
    return ans.toString();
  }

  public static void main(String[] args) {
    System.out.println(addBinary("100", "11"));
  }
}
