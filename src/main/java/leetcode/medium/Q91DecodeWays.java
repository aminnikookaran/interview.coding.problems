package leetcode.medium;

import java.util.Arrays;

// https://leetcode.com/problems/decode-ways/
public class Q91DecodeWays {
  public int numDecodings1(String s) {
    if (s == null || s.length() == 0) return 0;
    int[] ways = new int[s.length()];
    Arrays.fill(ways, -1);
    return numDecodings1(s, 0, ways);
  }

  public int numDecodings1(String s, int index, int[] ways) {
    if (index >= s.length()) return 1;
    if (ways[index] == -1) {
      int count = 0;
      if (s.charAt(index) != '0' && s.charAt(index) <= '9') {
        count = numDecodings1(s, index + 1, ways);
        if (index + 1 < s.length()
            && ((s.charAt(index) == '1' && s.charAt(index + 1) >= '0' && s.charAt(index + 1) <= '9')
                || (s.charAt(index) == '2'
                    && s.charAt(index + 1) >= '0'
                    && s.charAt(index + 1) <= '6'))) {
          count += numDecodings1(s, index + 2, ways);
        }
      }
      ways[index] = count;
    }
    return ways[index];
  }

  public int numDecodings2(String s) {
    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    if (s.charAt(0) == '0') return 0;
    dp[1] = 1;
    for (int i = 1; i < s.length(); i++) {
      char c = s.charAt(i);
      char p = s.charAt(i - 1);
      if (c == '0' && (p == '0' || p > '2')) return 0;

      if (p == '0') dp[i + 1] = dp[i];
      else if (p == '1') {
        if (c == '0') dp[i + 1] = dp[i - 1];
        else dp[i + 1] = dp[i - 1] + dp[i];
      } else if (p == '2') {
        if (c == '0') dp[i + 1] = dp[i - 1];
        else if (c <= '6') dp[i + 1] = dp[i] + dp[i - 1];
        else dp[i + 1] = dp[i];
      } else dp[i + 1] = dp[i];
    }
    return dp[s.length()];
  }
}
