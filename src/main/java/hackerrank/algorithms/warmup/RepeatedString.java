package hackerrank.algorithms.warmup;

// https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=warmup
public class RepeatedString {
  public static long repeatedString(String s, long n) {
    long size = s.length();
    long as = 0;
    for (int i = 0; i < size; i++) if (s.charAt(i) == 'a') as++;
    if (as == 0) return 0;
    long count = (n / size) * as;
    long remainder = n % size;
    for (int i = 0; i < remainder; i++) if (s.charAt(i) == 'a') count++;
    return count;
  }
}
