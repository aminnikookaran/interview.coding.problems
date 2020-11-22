package interviewbit.programming.math;

// https://www.interviewbit.com/problems/palindrome-integer/
public class PalindromeInteger {
  public static int isPalindrome(int A) {
    if (A < 0) return 0;
    int b = A;
    int c = 0;
    while (A > 0) {
      c *= 10;
      c += A % 10;
      A /= 10;
    }
    if (b == c) return 1;
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome(123));
  }
}
