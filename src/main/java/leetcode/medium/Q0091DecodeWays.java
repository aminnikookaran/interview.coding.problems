package leetcode.medium;

// https://leetcode.com/problems/decode-ways/
public class Q0091DecodeWays {
  public int numDecodings1(String s) {
    if (s == null || s.length() == 0) return 0;
    Integer[] mem = new Integer[s.length()];
    return numDecodings1(0, s, mem);
  }

  private int numDecodings1(int p, String s, Integer[] mem) {
    if (p == s.length()) return 1;
    if (s.charAt(p) == '0') return 0;
    if (mem[p] != null) return mem[p];
    int res = numDecodings1(p + 1, s, mem);
    if (p < s.length() - 1 && (s.charAt(p) == '1' || s.charAt(p) == '2' && s.charAt(p + 1) < '7'))
      res += numDecodings1(p + 2, s, mem);
    return mem[p] = res;
  }

  public int numDecodings2(String s) {
    if (s == null || s.length() == 0) return 0;
    int n = s.length();
    int[] dp = new int[n + 1];
    dp[n] = 1;
    for (int i = n - 1; i >= 0; i--)
      if (s.charAt(i) != '0') {
        dp[i] = dp[i + 1];
        if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
          dp[i] += dp[i + 2];
      }
    return dp[0];
  }

  public int numDecodings3(String s) {
    if (s == null || s.length() == 0) return 0;
    int dp1 = 1, dp2 = 0, n = s.length();
    for (int i = n - 1; i >= 0; i--) {
      int dp = s.charAt(i) == '0' ? 0 : dp1;
      if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
        dp += dp2;
      dp2 = dp1;
      dp1 = dp;
    }
    return dp1;
  }
}
