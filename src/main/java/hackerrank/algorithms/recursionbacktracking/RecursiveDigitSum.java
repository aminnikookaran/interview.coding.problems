package hackerrank.algorithms.recursionbacktracking;

// https://www.hackerrank.com/challenges/recursive-digit-sum/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=recursion-backtracking
public class RecursiveDigitSum {
  static int superDigit1(String n, int k) {
    if (k == 1 && n.length() == 1) return n.charAt(0) - '0';
    long sum = 0;
    for (int i = 0; i < n.length(); i++) sum += n.charAt(i) - '0';
    return superDigit1(String.valueOf(sum * k), 1);
  }

  static int superDigit2(String n, int k) {
    long sum = 0;
    for (int i = 0; i < n.length(); i++) sum += (n.charAt(i) - '0') % 9;
    sum *= k;
    sum %= 9;
    if (sum == 0) return 9;
    return (int) sum;
  }
}
