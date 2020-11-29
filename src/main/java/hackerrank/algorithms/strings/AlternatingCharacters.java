package hackerrank.algorithms.strings;

// https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=strings
public class AlternatingCharacters {
  public static int alternatingCharacters(String s) {
    if (s == null || s.length() < 2) return 0;
    int sum = 0;
    char lastChar = s.charAt(0);
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == lastChar) sum++;
      else lastChar = s.charAt(i);
    }
    return sum;
  }
}
