package leetcode.medium;

// https://leetcode.com/problems/longest-palindromic-substring/
public class Q0005LongestPalindromicSubstring {
  public String longestPalindrome1(String s) {
    String result = "";
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; i - j >= 0 && i + j < s.length(); j++) {
        if (s.charAt(i - j) == s.charAt(i + j)) {
          if (2 * j + 1 > result.length()) result = s.substring(i - j, i + 1 + j);
        } else break;
      }
      for (int j = 0; i - j >= 0 && i + 1 + j < s.length(); j++) {
        if (s.charAt(i - j) == s.charAt(i + 1 + j)) {
          if (2 * j + 2 > result.length()) result = s.substring(i - j, i + 2 + j);
        } else break;
      }
    }
    return result;
  }

  public String longestPalindrome2(String s) {
    if (s == null || s.length() <= 1) return s;
    int len = s.length();
    int maxLen = 1;
    boolean[][] dp = new boolean[len][len];
    String longest = null;
    for (int l = 0; l < len; l++) {
      for (int i = 0; i < len - l; i++) {
        int j = i + l;
        if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
          dp[i][j] = true;
          if (j - i + 1 > maxLen) {
            maxLen = j - i + 1;
            longest = s.substring(i, j + 1);
          }
        }
      }
    }
    return longest;
  }

  public String longestPalindrome3(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = expandAroundCenter(s, i, i);
      int len2 = expandAroundCenter(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
      L--;
      R++;
    }
    return R - L - 1;
  }

  // https://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-1
}
