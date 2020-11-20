package problems.strings;

public class LongestPalindromicSubstringProblem {
  public static String longestPalindrome1(String A) {
    int pStart = 0;
    int pEnd = 1;
    for (int i = 0; i < A.length(); i++) {
      for (int j = 1; j <= i && j < (A.length() - i); j++) {
        if (A.charAt(i - j) == A.charAt(i + j)) {
          if ((2 * j + 1) > (pEnd - pStart)) {
            pStart = i - j;
            pEnd = i + j + 1;
          }
        } else break;
      }
      for (int j = 0; j <= i && j < (A.length() - i - 1); j++) {
        if (A.charAt(i - j) == A.charAt(i + j + 1)) {
          if ((2 * j + 2) > (pEnd - pStart)) {
            pStart = i - j;
            pEnd = i + j + 2;
          }
        } else break;
      }
    }
    return A.substring(pStart, pEnd);
  }

  public static int start, end, maxLength;

  // finds the longest palindrome with [left, right] as center
  public static void checkPalindrome(String A, int left, int right) {
    while (left >= 0 && right < A.length() && A.charAt(left) == A.charAt(right)) {
      if (right - left + 1 > maxLength) {
        start = left;
        end = right + 1;
        maxLength = right - left + 1;
      }
      left--;
      right++;
    }
  }

  public static String longestPalindrome2(String A) {
    start = 0;
    end = 0;
    maxLength = 0;
    for (int i = 0; i < A.length(); i++) {
      checkPalindrome(A, i, i); // odd length, center in i
      checkPalindrome(A, i, i + 1); // even length, center between i and i + 1
    }
    return A.substring(start, end);
  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome1("cccb"));
  }
}
