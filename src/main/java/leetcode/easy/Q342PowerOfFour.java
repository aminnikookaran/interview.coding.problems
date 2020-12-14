package leetcode.easy;

// https://leetcode.com/problems/power-of-four/
public class Q342PowerOfFour {
  public boolean isPowerOfFour1(int n) {
    if (n < 1) return false;
    if (n == 1) return true;
    while (n > 1) {
      if (n % 4 != 0) return false;
      n /= 4;
    }
    return true;
  }

  public boolean isPowerOfFour2(int num) {
    int count0 = 0;
    int count1 = 0;
    while (num > 0) {
      if ((num & 1) == 1) count1++;
      else count0++;
      num >>= 1;
    }
    return count1 == 1 && (count0 % 2 == 0);
  }

  public boolean isPowerOfFour3(int num) {
    if (num == 0) return false;
    int pow = (int) (Math.log(num) / Math.log(4));
    if (num == Math.pow(4, pow)) return true;
    else return false;
  }
}
