package leetcode.easy;

// https://leetcode.com/problems/plus-one/
public class Q66PlusOne {
  public int[] plusOne(int[] digits) {
    if (digits == null || digits.length == 0) return new int[0];
    int carry = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      int sum = digits[i] + carry;
      carry = 0;
      if (sum > 9) carry = 1;
      digits[i] = sum % 10;
    }
    if (carry == 1) {
      int[] result = new int[digits.length + 1];
      System.arraycopy(digits, 0, result, 1, digits.length);
      result[0] = 1;
      digits = result;
    }
    return digits;
  }
}
