package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/fraction-to-recurring-decimal/
public class Q166FractionToRecurringDecimal {
  public String fractionToDecimal(int numerator, int denominator) {
    if (denominator == 0) return "";
    if (numerator == 0) return "0";

    StringBuilder stringBuilder = new StringBuilder();
    if (numerator < 0 ^ denominator < 0) stringBuilder.append("-");
    long numeratorl = Math.abs((long) numerator);
    long denominatorl = Math.abs((long) denominator);

    if (numeratorl >= denominatorl) {
      stringBuilder.append(String.valueOf(numeratorl / denominatorl));
      numeratorl %= denominatorl;
    } else stringBuilder.append("0");
    if (numeratorl == 0) return stringBuilder.toString();
    stringBuilder.append(".");
    Map<Long, Integer> map = new HashMap<>();
    while (numeratorl != 0) {
      Integer index = map.get(numeratorl);
      if (index != null) {
        stringBuilder.insert(index, "(");
        stringBuilder.append(")");
        break;
      }
      map.put(numeratorl, stringBuilder.length());

      numeratorl *= 10;
      stringBuilder.append(String.valueOf(numeratorl / denominatorl));
      numeratorl %= denominatorl;
    }
    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    Q166FractionToRecurringDecimal s = new Q166FractionToRecurringDecimal();
    System.out.println(s.fractionToDecimal(-50, 8));
  }
}
