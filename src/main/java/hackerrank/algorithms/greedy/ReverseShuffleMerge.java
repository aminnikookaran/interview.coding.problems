package hackerrank.algorithms.greedy;

// https://www.hackerrank.com/challenges/reverse-shuffle-merge/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=greedy-algorithms
public class ReverseShuffleMerge {
  static String reverseShuffleMerge(String s) {
    int n = s.length();
    int[] unused = new int[26];
    for (int i = 0; i < n; i++) unused[s.charAt(i) - 'a']++;
    int[] needed = new int[26];
    for (int i = 0; i < 26; i++) needed[i] = unused[i] / 2;
    char[] word = new char[n / 2];
    word[0] = s.charAt(n - 1);
    unused[word[0] - 'a']--;
    needed[word[0] - 'a']--;
    int j = 1;
    for (int i = n - 2; i >= 0; i--) {
      char c = s.charAt(i);
      int ci = c - 'a';
      if (needed[ci] > 0) {
        if (word[j - 1] > c) {
          while (j > 0
              && word[j - 1] > c
              && needed[word[j - 1] - 'a'] < unused[word[j - 1] - 'a']) {
            needed[word[j - 1] - 'a']++;
            j--;
          }
        }
        word[j] = c;
        unused[ci]--;
        needed[ci]--;
        j++;
      } else unused[ci]--;
    }
    return new String(word);
  }

  public static void main(String[] args) {
    System.out.println(reverseShuffleMerge("abcabc"));
  }
}
