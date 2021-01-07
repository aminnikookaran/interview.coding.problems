package leetcode.easy;

// https://leetcode.com/problems/ransom-note/
public class Q0383RansomNote {
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] chars = new int[26];
    int sum = ransomNote.length();
    for (int i = 0; i < ransomNote.length(); ++i) chars[ransomNote.charAt(i) - 'a']++;
    for (int i = 0; i < magazine.length(); i++) {
      if (chars[magazine.charAt(i) - 'a'] > 0) {
        chars[magazine.charAt(i) - 'a']--;
        sum--;
        if (sum == 0) return true;
      }
    }
    return false;
  }
}
