package leetcode.easy;

// https://leetcode.com/problems/power-of-two/
public class Q231PowerOfTwo {
  public boolean isPowerOfTwo1(int n) {
    if (n <= 0) return false;
    int m = n - 1;
    return (n & ((~m) << 1)) == 0;
  }

  public boolean isPowerOfTwo2(int n) {
    if (n <= 0) return false;
    while (n > 2) {
      int t = n >> 1;
      int c = t << 1;
      if (n - c != 0) return false;
      n = n >> 1;
    }
    return true;
  }

  public boolean isPowerOfTwo3(int n) {
    return n > 0 && (n & n - 1) == 0;
  }

  public boolean isPowerOfTwo4(int n) {
    return n > 0 && n == Math.pow(2, Math.round(Math.log(n) / Math.log(2)));
  }

  public static void main(String[] args) {
    Q231PowerOfTwo q = new Q231PowerOfTwo();
    System.out.println(q.isPowerOfTwo3(16));
  }
}
