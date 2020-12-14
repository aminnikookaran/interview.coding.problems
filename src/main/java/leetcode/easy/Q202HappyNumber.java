package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/happy-number/
public class Q202HappyNumber {
  public boolean isHappy1(int n) {
    Set<Integer> set = new HashSet<>();
    while (!set.contains(n)) {
      set.add(n);
      int temp = 0;
      while (n > 0) {
        temp += (n % 10) * (n % 10);
        n /= 10;
      }
      if (temp == 1) return true;
      n = temp;
    }
    return false;
  }

  public int numSquareSum(int n) {
    int squareSum = 0;
    while (n != 0) {
      squareSum += (n % 10) * (n % 10);
      n /= 10;
    }
    return squareSum;
  }

  public boolean isHappynumber2(int n) {
    int slow, fast;
    slow = fast = n;
    do {
      slow = numSquareSum(slow);
      fast = numSquareSum(numSquareSum(fast));
    } while (slow != fast);
    return (slow == 1);
  }

  public boolean isHappynumber(int n) {
    if (n == 1 || n == 7) return true;
    int sum = n, x = n;
    while (sum > 9) {
      sum = 0;
      while (x > 0) {
        int d = x % 10;
        sum += d * d;
        x /= 10;
      }
      if (sum == 1) return true;
      x = sum;
    }
    if (sum == 7) return true;
    return false;
  }
}
