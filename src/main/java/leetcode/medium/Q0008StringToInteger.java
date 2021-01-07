package leetcode.medium;

// https://leetcode.com/problems/string-to-integer-atoi/
public class Q0008StringToInteger {
  public int myAtoi1(String s) {
    long result = 0;
    boolean numberStart = false;
    boolean numberNegative = false;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == ' ') {
        if (numberStart) break;
        else continue;
      } else if (c == '-' || c == '+' || (c - '0' >= 0 && c - '0' <= 9)) {
        if ((c == '-' || c == '+') && numberStart) break;
        if (c == '-') numberNegative = true;
        numberStart = true;
        if (c - '0' >= 0 && c - '0' <= 9) {
          result = result * 10 + (c - '0');
          if (!numberNegative && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
          if (numberNegative && -result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
      } else break;
    }
    return (int) (numberNegative ? -result : result);
  }

  public int myAtoi2(String str) {
    int i = 0;
    int sign = 1;
    int result = 0;
    if (str.length() == 0) return 0;
    while (i < str.length() && str.charAt(i) == ' ') i++;
    if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-'))
      sign = (str.charAt(i++) == '-') ? -1 : 1;
    while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
      if (result > Integer.MAX_VALUE / 10
          || (result == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
        return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      result = result * 10 + (str.charAt(i++) - '0');
    }
    return result * sign;
  }
}
