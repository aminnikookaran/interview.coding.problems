package leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/count-the-number-of-consistent-strings/
public class Q1684CountTheNumberOfConsistentStrings {
  public int countConsistentStrings1(String allowed, String[] words) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < allowed.length(); i++) set.add(allowed.charAt(i));
    int count = 0;
    for (int i = 0; i < words.length; i++) {
      count++;
      for (int j = 0; j < words[i].length(); j++)
        if (!set.contains(words[i].charAt(j))) {
          count--;
          break;
        }
    }
    return count;
  }

  public int countConsistentStrings2(String allowed, String[] words) {
    int alphabet = 0, cnt = 0;
    for (int i = 0; i < allowed.length(); ++i) {
      int shift = allowed.charAt(i) - 'a';
      alphabet |= 1 << shift;
    }
    for (String w : words) {
      ++cnt;
      for (int i = 0; i < w.length(); ++i)
        if ((alphabet & (1 << w.charAt(i) - 'a')) == 0) {
          --cnt;
          break;
        }
    }
    return cnt;
  }

  public int countConsistentStrings3(String allowed, String[] words) {
    return Arrays.stream(words)
        .mapToInt(w -> w.chars().allMatch(c -> allowed.contains((char) c + "")) ? 1 : 0)
        .sum();
  }
}
