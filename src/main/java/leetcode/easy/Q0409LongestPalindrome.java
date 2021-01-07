package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-palindrome/
public class Q0409LongestPalindrome {
  public int longestPalindrome(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    boolean containsOddChar = false;
    int sum = 0;
    for (Integer value : map.values()) {
      sum += (value / 2) * 2;
      if (value % 2 == 1) containsOddChar = true;
    }
    if (containsOddChar) sum++;
    return sum;
  }
}
