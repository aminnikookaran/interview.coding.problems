package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generalized-abbreviation/
public class Q0320GeneralizedAbbreviation {
  public List<String> generateAbbreviations1(String word) {
    List<String> result = new ArrayList<>();
    generateAbbreviations1(word, result, "", 0, 0);
    return result;
  }

  public void generateAbbreviations1(
      String word, List<String> result, String path, int count, int pos) {
    if (pos == word.length()) {
      if (count > 0) path += count;
      result.add(path);
    } else {
      // abbreviate this character
      generateAbbreviations1(word, result, path, count + 1, pos + 1);

      // do not abbreviate this character
      if (count > 0) path += count;
      generateAbbreviations1(word, result, path + word.charAt(pos), 0, pos + 1);
    }
  }

  public List<String> generateAbbreviations2(String word) {
    List<String> result = new ArrayList<>();
    for (int i = 0; i < Math.pow(2, word.length()); i++) {
      int count = 0;
      String abbr = "";
      for (int j = 0; j < word.length(); j++) {
        if (((i >> j) & 1) == 1) count++;
        else {
          if (count > 0) {
            abbr += count;
            count = 0;
          }
          abbr += word.charAt(j);
        }
      }
      if (count != 0) abbr += count;
      result.add(abbr);
    }
    return result;
  }
}
