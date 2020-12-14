package problems;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MinimumLengthSubstrings {

  // Add any helper functions you may need here
  boolean isSubstring(Map<Character, Integer> tChars, Map<Character, Integer> sChars) {
    if (sChars.size() < tChars.size()) return false;
    for (Map.Entry<Character, Integer> entry : tChars.entrySet()) {
      Integer count = sChars.get(entry.getKey());
      if (count == null || count < entry.getValue()) return false;
    }
    return true;
  }

  int minLengthSubstring(String s, String t) {
    // Write your code here
    Map<Character, Integer> tChars = new HashMap<>();
    for (char c : t.toCharArray()) tChars.put(c, tChars.getOrDefault(c, 0) + 1);

    Map<Character, Integer> sChars = new HashMap<>();
    int i = 0, j = 0, min = Integer.MAX_VALUE;
    while (i < s.length()) {
      if (isSubstring(tChars, sChars)) {
        min = Math.min(min, j - i);
        char c = s.charAt(i);
        Integer count = sChars.get(c);
        if (count == 1) sChars.remove(c);
        else sChars.put(c, count - 1);
        i++;
      } else if (j < s.length()) {
        char c = s.charAt(j);
        sChars.put(c, sChars.getOrDefault(c, 0) + 1);
        j++;
      } else i++;
    }
    return min > s.length() ? -1 : min;
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

  public void run() throws IOException {
    String s_1 = "dcbefebce";
    String t_1 = "fd";
    int expected_1 = 5;
    int output_1 = minLengthSubstring(s_1, t_1);
    check(expected_1, output_1);

    String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
    String t_2 = "cbccfafebccdccebdd";
    int expected_2 = -1;
    int output_2 = minLengthSubstring(s_2, t_2);
    check(expected_2, output_2);

    // Add your own test cases here

  }

  public static void main(String[] args) throws IOException {
    new MinimumLengthSubstrings().run();
  }
}
