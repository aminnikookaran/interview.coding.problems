package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/reverse-vowels-of-a-string/
public class Q0345ReverseVowelsOfAString {
  public String reverseVowels(String s) {
    char[] sChars = s.toCharArray();
    Set<Character> chars = new HashSet<>();
    chars.add('a');
    chars.add('e');
    chars.add('i');
    chars.add('o');
    chars.add('u');
    chars.add('A');
    chars.add('E');
    chars.add('I');
    chars.add('O');
    chars.add('U');
    int i = 0, j = sChars.length - 1;
    while (i < j) {
      if (!chars.contains(sChars[i])) i++;
      else if (!chars.contains(sChars[j])) j--;
      else {
        char temp = sChars[j];
        sChars[j] = sChars[i];
        sChars[i] = temp;
        i++;
        j--;
      }
    }
    return new String(sChars);
  }
}
