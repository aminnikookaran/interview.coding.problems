package leetcode.easy;

// https://leetcode.com/problems/roman-to-integer/
public class Q13RomanToInteger {
  public int romanToInt(String s) {
    int number = 0;
    for (int i = 0; i < s.length(); i++) {
      switch (s.charAt(i)) {
        case 'M':
          number += 1000;
          break;
        case 'D':
          number += 500;
          break;
        case 'C':
          if (i + 1 < s.length() && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M'))
            number -= 100;
          else number += 100;
          break;
        case 'L':
          number += 50;
          break;
        case 'X':
          if (i + 1 < s.length() && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C'))
            number -= 10;
          else number += 10;
          break;
        case 'V':
          number += 5;
          break;
        case 'I':
          if (i + 1 < s.length() && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) number--;
          else number += 1;
          break;
      }
    }
    return number;
  }

  int value(char r) {
    if (r == 'I') return 1;
    if (r == 'V') return 5;
    if (r == 'X') return 10;
    if (r == 'L') return 50;
    if (r == 'C') return 100;
    if (r == 'D') return 500;
    if (r == 'M') return 1000;
    return -1;
  }

  int romanToDecimal(String str) {
    int res = 0;
    for (int i = 0; i < str.length(); i++) {
      int s1 = value(str.charAt(i));
      if (i + 1 < str.length()) {
        int s2 = value(str.charAt(i + 1));
        if (s1 >= s2) res = res + s1;
        else {
          res = res + s2 - s1;
          i++;
        }
      } else res = res + s1;
    }
    return res;
  }
}
