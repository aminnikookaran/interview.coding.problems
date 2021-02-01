package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/palindrome-partitioning/
public class Q0131PalindromePartitioning {
  public List<List<String>> partition1(String s) {
    List<List<String>> palindromes = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) palindromes.add(new ArrayList<>());

    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int l = 0; l < s.length(); l++) {
      for (int i = 0; i < s.length() - l; i++) {
        int j = i + l;
        if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
          dp[i][j] = true;
          palindromes.get(i).add(s.substring(i, j + 1));
        }
      }
    }

    List<List<String>> result = new ArrayList<>();
    partition1(result, palindromes, new ArrayList<>(), 0, s);
    return result;
  }

  public void partition1(
      List<List<String>> result,
      List<List<String>> palindromes,
      List<String> list,
      int index,
      String s) {
    if (index == s.length()) result.add(new ArrayList<>(list));
    else {
      for (String palindrome : palindromes.get(index)) {
        list.add(palindrome);
        partition1(result, palindromes, list, index + palindrome.length(), s);
        list.remove(list.size() - 1);
      }
    }
  }

  public List<List<String>> partition2(String s) {
    int len = s.length();
    boolean[][] memo = new boolean[len][len];
    List<List<String>> result = new ArrayList<>();
    dfs2(result, s, 0, new ArrayList<>(), memo);
    return result;
  }

  void dfs2(
      List<List<String>> result, String s, int start, List<String> currentList, boolean[][] memo) {
    if (start >= s.length()) result.add(new ArrayList<>(currentList));
    for (int end = start; end < s.length(); end++) {
      if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || memo[start + 1][end - 1])) {
        memo[start][end] = true;
        currentList.add(s.substring(start, end + 1));
        dfs2(result, s, end + 1, currentList, memo);
        currentList.remove(currentList.size() - 1);
      }
    }
  }
}
