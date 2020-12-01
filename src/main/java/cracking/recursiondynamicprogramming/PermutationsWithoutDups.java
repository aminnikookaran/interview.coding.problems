package cracking.recursiondynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class PermutationsWithoutDups {
  List<String> getPerms1(String str) {
    if (str == null) return null;

    List<String> permutations = new ArrayList<String>();
    if (str.length() == 0) { // base case
      permutations.add("");
      return permutations;
    }

    char first = str.charAt(0); // get the first char
    String remainder = str.substring(1); // remove the first char
    List<String> words = getPerms1(remainder);
    for (String word : words) {
      for (int j = 0; j <= word.length(); j++) {
        String s = insertCharAt(word, first, j);
        permutations.add(s);
      }
    }
    return permutations;
  }

  /* Insert char c at index i in word. */
  String insertCharAt(String word, char c, int i) {
    String start = word.substring(0, i);
    String end = word.substring(i);
    return start + c + end;
  }

  List<String> getPerms2(String remainder) {
    int len = remainder.length();
    List<String> result = new ArrayList<String>();

    /* Base case. */
    if (len == 0) {
      result.add(""); // Be sure to return empty string!
      return result;
    }

    for (int i = 0; i < len; i++) {
      /* Remove char i and find permutations of remaining chars.*/
      String before = remainder.substring(0, i);
      String after = remainder.substring(i + 1, len);
      List<String> partials = getPerms2(before + after);
      /* Prepend char i to each permutation.*/
      for (String s : partials) result.add(remainder.charAt(i) + s);
    }
    return result;
  }

  List<String> getPerms3(String str) {
    List<String> result = new ArrayList<String>();
    getPerms("", str, result);
    return result;
  }

  void getPerms(String prefix, String remainder, List<String> result) {
    if (remainder.length() == 0) result.add(prefix);

    int len = remainder.length();
    for (int i = 0; i < len; i++) {
      String before = remainder.substring(0, i);
      String after = remainder.substring(i + 1, len);
      char c = remainder.charAt(i);
      getPerms(prefix + c, before + after, result);
    }
  }
}
