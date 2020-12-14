package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MatchingPairs {

  // Add any helper functions you may need here

  int matchingPairs(String s, String t) {
    // Write your code here
    Set<Character> matched = new HashSet<>();
    boolean repeatedMatched = false;
    Map<Character, Set<Character>> unmatched = new HashMap<>();
    Set<Character> unmatcheds = new HashSet<>();
    Set<Character> unmatchedt = new HashSet<>();
    boolean repeatedUnmatched = false;
    for (int i = 0; i < s.length(); i++) {
      char sc = s.charAt(i);
      char tc = t.charAt(i);
      if (sc == tc) {
        if (matched.contains(sc)) repeatedMatched = true;
        matched.add(sc);
      } else {
        if (!unmatched.containsKey(sc)) unmatched.put(sc, new HashSet<>());
        unmatched.get(sc).add(tc);
        unmatcheds.add(sc);
        unmatchedt.add(tc);
        if (unmatcheds.contains(tc) || unmatchedt.contains(sc)) repeatedUnmatched = true;
      }
    }

    if (unmatched.size() == 0) {
      if (repeatedMatched) return matched.size();
      return matched.size() - 2;
    } else if (unmatched.size() == 1) {
      for (char c : unmatcheds) if (matched.contains(c)) return matched.size();
      for (char c : unmatchedt) if (matched.contains(c)) return matched.size();
      return matched.size() - 1;
    } else {
      for (Map.Entry<Character, Set<Character>> entry : unmatched.entrySet()) {
        for (char c : entry.getValue()) {
          Set<Character> value = unmatched.get(c);
          if (value != null && value.contains(entry.getKey())) return matched.size() + 2;
        }
      }
      if (repeatedUnmatched) return matched.size() + 1;
      return matched.size();
    }
  }

  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;

  void check(int expected, int output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    } else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printInteger(expected);
      System.out.print(" Your output: ");
      printInteger(output);
      System.out.println();
    }
    test_case_number++;
  }

  void printInteger(int n) {
    System.out.print("[" + n + "]");
  }

  public void run() {
    String s_1 = "abcde";
    String t_1 = "adcbe";
    int expected_1 = 5;
    int output_1 = matchingPairs(s_1, t_1);
    check(expected_1, output_1);

    String s_2 = "abcd";
    String t_2 = "abcd";
    int expected_2 = 2;
    int output_2 = matchingPairs(s_2, t_2);
    check(expected_2, output_2);

    // Add your own test cases here
    String s_3 = "abec";
    String t_3 = "abcc";
    int expected_3 = 3;
    int output_3 = matchingPairs(s_3, t_3);
    check(expected_3, output_3);
  }

  public static void main(String[] args) {
    new MatchingPairs().run();
  }
}
