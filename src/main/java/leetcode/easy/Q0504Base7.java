package leetcode.easy;

// https://leetcode.com/problems/base-7/
public class Q0504Base7 {
  public String convertToBase71(int n) {
    if (n < 0) return "-" + convertToBase71(-n);
    if (n < 7) return Integer.toString(n);
    return convertToBase71(n / 7) + Integer.toString(n % 7);
  }

  public String convertTo72(int num) {
    if (num == 0) return "0";

    StringBuilder sb = new StringBuilder();
    boolean negative = (num < 0);
    num = Math.abs(num);
    while (num != 0) {
      sb.append(num % 7);
      num /= 7;
    }
    if (negative) sb.append("-");
    return sb.reverse().toString();
  }

  public String convertToBase73(int num) {
    int base = 1, result = 0;
    while (num != 0) {
      result += base * (num % 7);
      num /= 7;
      base *= 10;
    }
    return String.valueOf(result);
  }
}
