package leetcode.easy;

// https://leetcode.com/problems/find-the-difference/
public class Q389FindTheDifference {
  public char findTheDifference(String s, String t) {
    int[] chars = new int[26];
    for (int i = 0; i < s.length(); i++) chars[s.charAt(i) - 'a']++;
    for (int i = 0; i < t.length(); i++) {
      if (chars[t.charAt(i) - 'a'] == 0) return t.charAt(i);
      chars[t.charAt(i) - 'a']--;
    }
    return ' ';
  }
}
