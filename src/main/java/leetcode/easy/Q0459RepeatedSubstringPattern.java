package leetcode.easy;

// https://leetcode.com/problems/repeated-substring-pattern/
public class Q0459RepeatedSubstringPattern {
  public boolean repeatedSubstringPattern1(String str) {
    int len = str.length();
    for (int i = len / 2; i >= 1; i--) {
      if (len % i == 0) {
        int m = len / i;
        String subS = str.substring(0, i);
        int j;
        for (j = 1; j < m; j++) {
          if (!subS.equals(str.substring(j * i, i + j * i))) break;
        }
        if (j == m) return true;
      }
    }
    return false;
  }

  public boolean repeatedSubstringPattern2(String s) {
    int n = s.length();
    for (int i = n / 2; i > 0; i--) {
      if (n % i == 0) {
        int k = i;
        for (; k < n; k += i) {
          int j = 0;
          for (; j < i; j++) {
            if (s.charAt(j + k) != s.charAt(j)) break;
          }
          if (j != i) break;
        }
        if (k == n) return true;
      }
    }
    return false;
  }

  public boolean repeatedSubstringPattern3(String str) {
    String s = str + str;
    return s.substring(1, s.length() - 1).contains(str);
  }
}
