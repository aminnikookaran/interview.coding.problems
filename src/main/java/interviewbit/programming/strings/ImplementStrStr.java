package interviewbit.programming.strings;

// https://www.interviewbit.com/problems/implement-strstr/
public class ImplementStrStr {
  public static int strStr1(final String A, final String B) {
    if (B.length() < 1 || A.length() < B.length()) return -1;
    for (int i = 0; i <= A.length() - B.length(); i++) {
      if (A.charAt(i) == B.charAt(0)) {
        boolean containsWord = true;
        for (int j = 1; j < B.length(); j++) {
          if (A.charAt(i + j) != B.charAt(j)) {
            containsWord = false;
            break;
          }
        }
        if (containsWord) return i;
      }
    }
    return -1;
  }

  public static int strStr2(final String A, final String B) {
    int n = A.length(), m = B.length();
    if (n == 0 || m == 0) return -1;
    if (m > n) return -1;
    int i = 0, j = 0, index = -1;
    while (i < n && j < m) {
      if ((n - i) < (m - j)) return -1;
      if (A.charAt(i) == B.charAt(j)) {
        if (j == 0) index = i;
        j++;
      } else if (j > 0) {
        index = -1;
        i = i - j;
        j = 0;
      }
      i++;
    }
    return index;
  }

  public static void main(String[] args) {
    System.out.println(strStr1("the sky is blue", "blue"));
  }
}
