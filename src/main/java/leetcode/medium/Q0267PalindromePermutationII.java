package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/palindrome-permutation-ii/
public class Q0267PalindromePermutationII {
  public List<String> generatePalindromes1(String s) {
    int[] hash = new int[256];
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    char[] input = s.toCharArray();
    int odd = 0;
    int len = 0;
    for (char c : input) hash[c]++;
    for (int i = 0; i < 256; i++) {
      if (hash[i] % 2 == 1) {
        odd++;
        if (odd > 1) return result;
        sb.append((char) i);
        hash[i]--;
      }
      hash[i] /= 2;
      len += hash[i];
    }
    String mid = sb.toString();
    sb.setLength(0);
    helper1(hash, len, sb, mid, result);
    return result;
  }

  private void helper1(int[] hash, int len, StringBuilder sb, String mid, List<String> result) {
    if (sb.length() == len) {
      result.add(sb.toString() + mid + sb.reverse().toString());
      sb.reverse();
      return;
    }
    for (int i = 0; i < hash.length; ++i) {
      if (hash[i] > 0) {
        sb.append((char) i);
        hash[i]--;
        helper1(hash, len, sb, mid, result);
        sb.deleteCharAt(sb.length() - 1);
        hash[i]++;
      }
    }
  }
}
