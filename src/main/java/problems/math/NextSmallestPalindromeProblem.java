package problems.math;

import java.math.BigInteger;

public class NextSmallestPalindromeProblem {
  public static String solve1(String A) {
    int n = A.length();
    if (n == 0) {
      return A;
    } else if (n == 1) {
      if (A.charAt(0) == '9') return "11";
      else return String.valueOf(Integer.parseInt(A) + 1);
    } else if (n % 2 == 0) {
      int k = n / 2 - 1;
      while (k >= 0) {
        if (A.charAt(k) != A.charAt(n - 1 - k)) break;
        k--;
      }
      if (k >= 0 && A.charAt(k) > A.charAt(n - 1 - k)) {
        StringBuilder answer = new StringBuilder();
        answer.append(A.substring(0, n / 2));
        for (int i = 0; i < n / 2; i++) answer.append(A.charAt(n / 2 - 1 - i));
        return answer.toString();
      } else {
        int i = n / 2 - 1;
        while (i >= 0) {
          if (A.charAt(i) != '9') break;
          i--;
        }
        if (i == -1) {
          StringBuilder answer = new StringBuilder();
          answer.append('1');
          for (int j = 1; j < n; j++) answer.append('0');
          answer.append('1');
          return answer.toString();
        } else {
          StringBuilder answer = new StringBuilder();
          answer.append(A.substring(0, i));
          int middleDigit = Integer.parseInt(String.valueOf(A.charAt(i)));
          answer.append(middleDigit + 1);
          for (int j = i + 1; j < n / 2; j++) answer.append("00");
          answer.append(middleDigit + 1);
          for (int j = 0; j < i; j++) answer.append(A.charAt(i - 1 - j));
          return answer.toString();
        }
      }
    } else {
      int k = n / 2 - 1;
      while (k >= 0) {
        if (A.charAt(k) != A.charAt(n - 1 - k)) break;
        k--;
      }
      if (k >= 0 && A.charAt(k) > A.charAt(n - 1 - k)) {
        StringBuilder answer = new StringBuilder();
        answer.append(A.substring(0, n / 2 + 1));
        for (int i = 0; i < n / 2; i++) answer.append(A.charAt(n / 2 - 1 - i));
        return answer.toString();
      } else {
        int i = n / 2;
        while (i >= 0) {
          if (A.charAt(i) != '9') break;
          i--;
        }
        if (i == -1) {
          StringBuilder answer = new StringBuilder();
          answer.append('1');
          for (int j = 1; j < n; j++) answer.append('0');
          answer.append('1');
          return answer.toString();
        } else {
          StringBuilder answer = new StringBuilder();
          answer.append(A.substring(0, i));
          int middleDigit = Integer.parseInt(String.valueOf(A.charAt(i)));
          answer.append(middleDigit + 1);
          for (int j = i + 1; j < n / 2; j++) answer.append("00");
          if (i < n / 2) answer.append('0').append(middleDigit + 1);
          for (int j = 0; j < i; j++) answer.append(A.charAt(i - 1 - j));
          return answer.toString();
        }
      }
    }
  }

  public static String solve2(String num) {
    int len = num.length();
    String left = num.substring(0, len / 2);
    String middle = num.substring(len / 2, len - len / 2);
    String right = num.substring(len - len / 2);

    if (right.compareTo(reverse(left)) < 0) return left + middle + reverse(left);

    String next = new BigInteger(left + middle).add(BigInteger.ONE).toString();
    return next.substring(0, left.length() + middle.length())
        + reverse(next).substring(middle.length());
  }

  public static String reverse(String s) {
    return new StringBuilder(s).reverse().toString();
  }

  public static String solve3(String A) {
    if (areOnlyNines(A)) {
      return nextPalindromeFromNines(A);
    }

    String mirrorOfA = mirror(A);
    if (isLarger(mirrorOfA, A)) {
      return mirrorOfA;
    }

    return increaseFromMiddle(A);
  }

  public static boolean areOnlyNines(String number) {
    for (char c : number.toCharArray()) {
      if (c != '9') {
        return false;
      }
    }
    return true;
  }

  public static String nextPalindromeFromNines(String number) {
    StringBuffer buf = new StringBuffer();
    buf.append('1');
    for (int i = 0; i < number.length() - 1; i++) {
      buf.append('0');
    }
    buf.append('1');
    return buf.toString();
  }

  public static String mirror(String number) {
    StringBuffer buf = new StringBuffer(number);
    // start from middle
    int backward = number.length() - 1;
    int forward = 0;
    while (forward < backward) {
      buf.setCharAt(backward, buf.charAt(forward));
      backward--;
      forward++;
    }
    return buf.toString();
  }

  public static boolean isLarger(String a, String b) {
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) > b.charAt(i)) {
        return true;
      } else if (a.charAt(i) < b.charAt(i)) {
        return false;
      }
    }
    return false;
  }

  public static String increaseFromMiddle(String number) {
    StringBuffer buf = new StringBuffer(number);
    int carrier = 1;
    for (int i = (number.length() - 1) / 2; i >= 0; i--) {
      if (carrier == 0) {
        break;
      }
      char c = number.charAt(i);
      if (c == '9') {
        buf.setCharAt(i, '0');
      } else {
        buf.setCharAt(i, (char) (c + 1));
        carrier = 0;
      }
    }
    return mirror(buf.toString());
  }

  public static void main(String[] args) {
//    System.out.println(solve2("387427793198650286024"));
    System.out.println(solve3("12345"));
  }
}
