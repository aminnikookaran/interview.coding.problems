package hackerrank.algorithms.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=strings
public class SherlockAndTheValidString {
  public static String isValid1(String s) {
    int[] freqs = new int[26];
    for (int i = 0; i < s.length(); i++) freqs[s.charAt(i) - 'a']++;
    Map<Integer, Integer> map = new HashMap<>();
    for (int freq : freqs)
      if (freq > 0) {
        Integer count = map.get(freq);
        map.put(freq, count == null ? 1 : count + 1);
      }
    if (map.size() == 1) return "YES";
    else if (map.size() == 2) {
      int i = 0;
      int[] keys = new int[2];
      int[] values = new int[2];
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        keys[i] = entry.getKey();
        values[i] = entry.getValue();
        i++;
      }

      if (values[0] > 1 && values[1] > 1) return "NO";
      else if ((values[0] == 1 && keys[0] == 1) || (values[1] == 1 && keys[1] == 1)) return "YES";
      else if ((values[0] == 1 && keys[0] == keys[1] + 1)
          || (values[1] == 1 && keys[1] == keys[0] + 1)) return "YES";
      else return "NO";
    } else return "NO";
  }

  public static String isValid2(String s) {
    final String GOOD = "YES";
    final String BAD = "NO";

    if (s.isEmpty()) return BAD;
    if (s.length() <= 3) return GOOD;

    int[] letters = new int[26];
    for (int i = 0; i < s.length(); i++) letters[s.charAt(i) - 'a']++;
    Arrays.sort(letters);
    int i = 0;
    while (letters[i] == 0) i++;

    int min = letters[i]; // the smallest frequency of some letter
    int max = letters[25]; // the largest frequency of some letter
    String ret = BAD;
    if (min == max) ret = GOOD;
    else {
      // remove one letter at higher frequency or the lower frequency
      if (((max - min == 1) && (max > letters[24])) || (min == 1) && (letters[i + 1] == max))
        ret = GOOD;
    }
    return ret;
  }

  public static void main(String[] args) {
    System.out.println(isValid1("abcdefghhgfedecba"));
    System.out.println(isValid2("aaaabb"));
  }
}
