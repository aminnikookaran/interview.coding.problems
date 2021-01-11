package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/unique-word-abbreviation/
public class Q0288UniqueWordAbbreviation {
  public class ValidWordAbbr {
    Map<String, String> dict;

    public ValidWordAbbr(String[] dictionary) {
      dict = new HashMap<>();
      for (String word : dictionary) {
        String abbr = getAbbr(word);
        if (!dict.containsKey(abbr)) dict.put(abbr, word);
        else if (!dict.get(abbr).equals(word)) dict.put(abbr, "-1");
      }
    }

    public boolean isUnique(String word) {
      String abbr = getAbbr(word);
      return !dict.containsKey(abbr) || dict.get(abbr).equals(word);
    }

    private String getAbbr(String word) {
      int n = word.length();
      if (n < 3) return word;
      return "" + word.charAt(0) + (n - 2) + word.charAt(n - 1);
    }
  }
}
