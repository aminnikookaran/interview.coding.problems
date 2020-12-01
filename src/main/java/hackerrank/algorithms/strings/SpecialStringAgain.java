package hackerrank.algorithms.strings;

import java.io.IOException;

// https://www.hackerrank.com/challenges/special-palindrome-again/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=strings
public class SpecialStringAgain {
  public static long substrCount1(int n, String s) {
    if (s == null || s.length() < 1) return 0;
    n = s.length();
    long sum = 1;
    int currChar = s.charAt(0);
    int currLength = 1;
    for (int i = 1; i < n; i++) {
      sum++;
      if (s.charAt(i) == currChar) {
        sum += currLength;
        currLength++;
      } else {
        for (int j = 1; j <= currLength && j < n - i; j++)
          if (s.charAt(i + j) == currChar) sum++;
          else break;
        currChar = s.charAt(i);
        currLength = 1;
      }
    }
    return sum;
  }

  public static int substrCount2(String str) {
    int n = str.length();
    int result = 0;
    int[] sameChar = new int[n];
    int i = 0;
    while (i < n) {
      int sameCharCount = 1;
      int j = i + 1;
      while (j < n && str.charAt(i) == str.charAt(j)) {
        sameCharCount++;
        j++;
      }
      result += (sameCharCount * (sameCharCount + 1) / 2);
      sameChar[i] = sameCharCount;
      i = j;
    }
    for (int j = 1; j < n; j++) {
      if (str.charAt(j) == str.charAt(j - 1)) sameChar[j] = sameChar[j - 1];
      if (j < (n - 1)
          && (str.charAt(j - 1) == str.charAt(j + 1) && str.charAt(j) != str.charAt(j - 1)))
        result += Math.min(sameChar[j - 1], sameChar[j + 1]);
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    System.out.println(substrCount1(0, "aaabaa"));
  }
}
