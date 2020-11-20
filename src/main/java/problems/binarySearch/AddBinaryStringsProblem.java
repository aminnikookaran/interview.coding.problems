package problems.binarySearch;

public class AddBinaryStringsProblem {
  public static int sqrt1(int A) {
    if (A < 1) return 0;
    int b = A;
    int c = A / 2;
    while (true) {
      if (b <= A / b)
        if ((b + 1) > A / (b + 1)) break;
        else b += c;
      else b -= c;
      c /= 2;
      if (c < 1) c = 1;
    }
    return b;
  }

  public static int sqrt2(int a) {
    long low = 1;
    long high = a;
    while (low <= high) {
      long mid = (high + low) / 2;
      if (mid * mid == a) return (int) mid;
      if (mid * mid > a) high = mid - 1;
      else low = mid + 1;
    }
    return (int) high;
  }

  public static void main(String[] args) {
    System.out.println(sqrt2(Integer.MAX_VALUE));
  }
}
