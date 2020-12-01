package hackerrank.algorithms.strings;

import static java.lang.Math.max;

// https://www.hackerrank.com/challenges/common-child/forum?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=strings
public class CommonChild {
  public static int lcs1(String X, String Y, int m, int n) {
    if (m == 0 || n == 0) return 0;
    if (X.charAt(m - 1) == Y.charAt(n - 1)) return 1 + lcs1(X, Y, m - 1, n - 1);
    else return max(lcs1(X, Y, m, n - 1), lcs1(X, Y, m - 1, n));
  }

  public static int lcs2(String X, String Y, int m, int n) {
    int L[][] = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (X.charAt(i - 1) == Y.charAt(j - 1)) L[i][j] = L[i - 1][j - 1] + 1;
        else L[i][j] = max(L[i - 1][j], L[i][j - 1]);
      }
    }
    return L[m][n];
  }

  public static int lcs3(String X, String Y) {
    int m = X.length(), n = Y.length();
    int L[][] = new int[2][n + 1];
    int bi = 0;
    for (int i = 1; i <= m; i++) {
      bi = i & 1;
      for (int j = 1; j <= n; j++) {
        if (X.charAt(i - 1) == Y.charAt(j - 1)) L[bi][j] = L[1 - bi][j - 1] + 1;
        else L[bi][j] = max(L[1 - bi][j], L[bi][j - 1]);
      }
    }
    return L[bi][n];
  }

  public static void main(String[] args) {
    System.out.println(lcs3("SHINCHAN", "NOHARAAA"));
  }
}
