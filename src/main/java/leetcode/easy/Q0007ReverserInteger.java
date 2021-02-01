package leetcode.easy;

// https://leetcode.com/problems/reverse-integer/
public class Q0007ReverserInteger {
  public int reverse1(int x) {
    boolean isNegative = false;
    if (x < 0) {
      isNegative = true;
      x = -x;
    }

    int newInteger = 0;
    int preInteger = 0;
    while (x > 0) {
      preInteger *= 10;
      if (newInteger != preInteger / 10) return 0;
      preInteger += x % 10;
      if (newInteger > preInteger) return 0;
      newInteger = preInteger;
      x /= 10;
    }

    if (isNegative) newInteger = -newInteger;
    return newInteger;
  }

  public int reverse(int x) {
    int rev = 0;
    while (x != 0) {
      int pop = x % 10;
      x /= 10;
      if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
      if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
      rev = rev * 10 + pop;
    }
    return rev;
  }
}
