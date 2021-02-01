package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/decode-ways-ii/
public class Q0639DecodeWaysII {
  int M = 1000000007;

  public int numDecodings1(String s) {
    Integer[] memo = new Integer[s.length()];
    return ways(s, s.length() - 1, memo);
  }

  public int ways(String s, int i, Integer[] memo) {
    if (i < 0) return 1;
    if (memo[i] != null) return memo[i];
    if (s.charAt(i) == '*') {
      long res = 9 * ways(s, i - 1, memo);
      if (i > 0 && s.charAt(i - 1) == '1') res = (res + 9 * ways(s, i - 2, memo)) % M;
      else if (i > 0 && s.charAt(i - 1) == '2') res = (res + 6 * ways(s, i - 2, memo)) % M;
      else if (i > 0 && s.charAt(i - 1) == '*') res = (res + 15 * ways(s, i - 2, memo)) % M;
      memo[i] = (int) res;
      return memo[i];
    }
    long res = s.charAt(i) != '0' ? ways(s, i - 1, memo) : 0;
    if (i > 0 && s.charAt(i - 1) == '1') res = (res + ways(s, i - 2, memo)) % M;
    else if (i > 0 && s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
      res = (res + ways(s, i - 2, memo)) % M;
    else if (i > 0 && s.charAt(i - 1) == '*')
      res = (res + (s.charAt(i) <= '6' ? 2 : 1) * ways(s, i - 2, memo)) % M;
    memo[i] = (int) res;
    return memo[i];
  }

  public int numDecodings2(String s) {
    long[] dp = new long[s.length() + 1];
    dp[0] = 1;
    dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == '*') {
        dp[i + 1] = 9 * dp[i];
        if (s.charAt(i - 1) == '1') dp[i + 1] = (dp[i + 1] + 9 * dp[i - 1]) % M;
        else if (s.charAt(i - 1) == '2') dp[i + 1] = (dp[i + 1] + 6 * dp[i - 1]) % M;
        else if (s.charAt(i - 1) == '*') dp[i + 1] = (dp[i + 1] + 15 * dp[i - 1]) % M;
      } else {
        dp[i + 1] = s.charAt(i) != '0' ? dp[i] : 0;
        if (s.charAt(i - 1) == '1') dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
        else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
          dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
        else if (s.charAt(i - 1) == '*')
          dp[i + 1] = (dp[i + 1] + (s.charAt(i) <= '6' ? 2 : 1) * dp[i - 1]) % M;
      }
    }
    return (int) dp[s.length()];
  }

  public int numDecodings3(String s) {
    long first = 1, second = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
    for (int i = 1; i < s.length(); i++) {
      long temp = second;
      if (s.charAt(i) == '*') {
        second = 9 * second;
        if (s.charAt(i - 1) == '1') second = (second + 9 * first) % M;
        else if (s.charAt(i - 1) == '2') second = (second + 6 * first) % M;
        else if (s.charAt(i - 1) == '*') second = (second + 15 * first) % M;
      } else {
        second = s.charAt(i) != '0' ? second : 0;
        if (s.charAt(i - 1) == '1') second = (second + first) % M;
        else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6') second = (second + first) % M;
        else if (s.charAt(i - 1) == '*')
          second = (second + (s.charAt(i) <= '6' ? 2 : 1) * first) % M;
      }
      first = temp;
    }
    return (int) second;
  }

  static Map<String, Integer> map =
      new HashMap<>() {
        {
          put("**", 15); // 11 to 19 and 21 to 26
          put("*0", 2); // 1 and 2
          put("*1", 2);
          put("*2", 2);
          put("*3", 2);
          put("*4", 2);
          put("*5", 2);
          put("*6", 2);
          put("*7", 1); // 1
          put("*8", 1);
          put("*9", 1);
          put("1*", 9); // 1 to 9
          put("2*", 6); // 1 to 6
        }
      };

  public int numDecodings4(String s) {
    Long[] mem = new Long[s.length()];
    return (int) numDecodings4(0, s, mem);
  }

  private long numDecodings4(int p, String s, Long[] mem) {
    int n = s.length();
    if (p == n) return 1;
    if (s.charAt(p) == '0') return 0;
    if (mem[p] != null) return mem[p];
    long num = (s.charAt(p) == '*' ? 9 : 1) * numDecodings4(p + 1, s, mem);
    if (p < n - 1) {
      int mod = 1000000007;
      String s2 = s.substring(p, p + 2);
      if (s2.indexOf('*') > -1)
        num = (num + map.getOrDefault(s2, 0) * numDecodings4(p + 2, s, mem)) % mod;
      else if (s.charAt(p) == '1' || (s.charAt(p) == '2' && s.charAt(p + 1) < '7'))
        num = (num + numDecodings4(p + 2, s, mem)) % mod;
    }
    return mem[p] = num;
  }

  public int numDecodings5(String s) {
    int n = s.length(), mod = 1000000007;
    long[] dp = new long[n + 1];
    dp[n] = 1;
    for (int i = n - 1; i >= 0; i--)
      if (s.charAt(i) == '0') dp[i] = 0;
      else {
        dp[i] = (s.charAt(i) == '*' ? 9 : 1) * dp[i + 1];
        if (i < n - 1) {
          String s2 = s.substring(i, i + 2);
          if (s2.indexOf('*') > -1) dp[i] = (dp[i] + map.getOrDefault(s2, 0) * dp[i + 2]) % mod;
          else if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
            dp[i] = (dp[i] + dp[i + 2]) % mod;
        }
      }
    return (int) dp[0];
  }

  public int numDecodings6(String s) {
    int n = s.length(), mod = 1000000007;
    long dp = 0, dp1 = 1, dp2 = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (s.charAt(i) == '0') dp = 0;
      else {
        dp = (s.charAt(i) == '*' ? 9 : 1) * dp1;
        if (i < n - 1) {
          String s2 = s.substring(i, i + 2);
          if (s2.indexOf('*') > -1) dp = (dp + map.getOrDefault(s2, 0) * dp2) % mod;
          else if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
            dp = (dp + dp2) % mod;
        }
      }
      dp2 = dp1;
      dp1 = dp;
    }
    return (int) dp;
  }

  public int numDecodings7(String s) {
    if (s == null || s.length() == 0) return 0;
    Integer[] memo = new Integer[s.length()];
    return numDecodings7(s, 0, memo);
  }

  public int numDecodings7(String s, int index, Integer[] memo) {
    if (s.length() == index) return 1;
    if (s.charAt(index) == '0') return 0;
    if (memo[index] != null) return memo[index];
    int res = 0;
    long temp = numDecodings7(s, index + 1, memo) % 1000000007;
    if (s.charAt(index) == '*') res += (9 * temp) % 1000000007;
    else res += temp % 1000000007;
    temp = 0;
    if (index < s.length() - 1) {
      temp = numDecodings7(s, index + 2, memo) % 1000000007;
      if (s.charAt(index) == '1')
        if (s.charAt(index + 1) == '*') {
          res += (9 * temp) % 1000000007;
        } else res += temp % 1000000007;
      if (s.charAt(index) == '2')
        if (s.charAt(index + 1) == '*') {
          res += (6 * temp) % 1000000007;
        } else if (s.charAt(index + 1) < '7') res += temp % 1000000007;
      if (s.charAt(index) == '*')
        if (s.charAt(index + 1) == '*') {
          res += (15 * temp) % 1000000007;
        } else if (s.charAt(index + 1) < '7') {
          res += (2 * temp) % 1000000007;
        } else res += temp % 1000000007;
    }
    return memo[index] = res;
  }
}
