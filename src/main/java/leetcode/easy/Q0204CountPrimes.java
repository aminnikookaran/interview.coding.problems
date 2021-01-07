package leetcode.easy;

// https://leetcode.com/problems/count-primes/
public class Q0204CountPrimes {
  public int countPrimes(int n) {
    if (n < 2) return 0;
    boolean[] numbers = new boolean[n];
    numbers[0] = true;
    numbers[1] = true;
    int count = 0;
    for (int i = 2; i < n; i++)
      if (!numbers[i]) {
        count++;
        for (int j = 2 * i; j < n; j += i) numbers[j] = true;
      }
    return count;
  }
}
