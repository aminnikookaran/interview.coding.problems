package interviewbit.programming.math;

// https://www.interviewbit.com/problems/reverse-integer/
public class ReverserInteger {
  public static int reverse(int x) {
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

  public static void main(String[] args) {
    System.out.println(reverse(123));
  }
}
