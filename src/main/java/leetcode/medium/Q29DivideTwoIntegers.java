package leetcode.medium;

// https://leetcode.com/problems/divide-two-integers/
public class Q29DivideTwoIntegers {
  public int divide1(int dividend, int divisor) {
    if (dividend == 0 || divisor == 0) return 0;
    long dividend2 = Math.abs((long) dividend);
    long divisor2 = Math.abs((long) divisor);
    long sign = 1;
    if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) sign = -1;
    long low = 0, high = dividend2;
    while (low < high) {
      long mid = (low + high + 1) / 2;
      long mult = mid * divisor2;
      if (mult == dividend2) {
        low = mid;
        break;
      }
      if (mult < dividend2) low = mid;
      else high = mid - 1;
    }
    low *= sign;
    if (low > Integer.MAX_VALUE) return Integer.MAX_VALUE;
    if (low < Integer.MIN_VALUE) return Integer.MIN_VALUE;
    return (int) low;
  }

  public int divide2(int dividend, int divisor) {
    // handle special cases
    if (divisor == 0) return Integer.MAX_VALUE;
    if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
    // get positive values
    long pDividend = Math.abs((long) dividend);
    long pDivisor = Math.abs((long) divisor);
    int result = 0;
    while (pDividend >= pDivisor) {
      // calculate number of left shifts
      int numShift = 0;
      while (pDividend >= (pDivisor << numShift)) numShift++;

      // dividend minus the largest shifted divisor
      result += 1 << (numShift - 1);
      pDividend -= (pDivisor << (numShift - 1));
    }
    if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) return result;
    else return -result;
  }

  public int divide3(int dividend, int divisor) {
    long pDividend = Math.abs((long) dividend);
    long pDivisor = Math.abs((long) divisor);
    long quotient = 0, temp = 0;

    for (int i = 31; i >= 0; i--) {
      if (temp + (pDivisor << i) <= pDividend) {
        temp += pDivisor << i;
        quotient |= 1L << i;
      }
    }

    if (dividend < 0 ^ divisor < 0) quotient = -quotient;
    if (quotient > Integer.MAX_VALUE) return Integer.MAX_VALUE;
    if (quotient < Integer.MIN_VALUE) return Integer.MIN_VALUE;
    return (int) quotient;
  }
}
