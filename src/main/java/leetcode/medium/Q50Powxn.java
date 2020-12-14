package leetcode.medium;

// https://leetcode.com/problems/powx-n/
public class Q50Powxn {
  public double myPow1(double x, int n) {
    double result = 1;
    double mult = x;
    long pow = n;
    if (pow < 0) {
      mult = 1 / x;
      pow = -pow;
    }
    while (pow > 0) {
      if (pow % 2 == 1) result *= mult;
      mult *= mult;
      pow /= 2;
    }
    return result;
  }

  public double myPow2(double x, int n) {
    if (n == 0) return 1;
    if (n < 0) return 1 / myPow2(x, -n);
    double v = myPow2(x, n / 2);
    if (n % 2 == 0) return v * v;
    else return v * v * x;
  }
}
