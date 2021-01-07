package leetcode.easy;

// https://leetcode.com/problems/perfect-number/
public class Q0507PerfectNumber {
  public boolean checkPerfectNumber1(int num) {
    if (num <= 0) return false;
    int sum = 0;
    for (int i = 1; i * i <= num; i++) {
      if (num % i == 0) {
        sum += i;
        if (i * i != num) sum += num / i;
      }
    }
    return sum - num == num;
  }

  public boolean checkPerfectNumber2(int num) {
    int[] primes = new int[] {2, 3, 5, 7, 13, 17, 19, 31};
    for (int prime : primes) if (pn(prime) == num) return true;
    return false;
  }

  public int pn(int p) {
    return (1 << (p - 1)) * ((1 << p) - 1);
  }
}
