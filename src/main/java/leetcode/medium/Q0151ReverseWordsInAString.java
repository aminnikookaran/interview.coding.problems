package leetcode.medium;

// https://leetcode.com/problems/reverse-words-in-a-string/
public class Q0151ReverseWordsInAString {
  public String reverseWords1(String s) {
    if (s == null) return null;

    char[] a = s.toCharArray();
    int n = a.length;

    // step 1. reverse the whole string
    reverse(a, 0, n - 1);
    // step 2. reverse each word
    reverseWords(a, n);
    // step 3. clean up spaces
    return cleanSpaces(a, n);
  }

  void reverseWords(char[] a, int n) {
    int i = 0, j = 0;

    while (i < n) {
      while (i < j || i < n && a[i] == ' ') i++; // skip spaces
      while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
      reverse(a, i, j - 1); // reverse the word
    }
  }

  // trim leading, trailing and multiple spaces
  String cleanSpaces(char[] a, int n) {
    int i = 0, j = 0;

    while (j < n) {
      while (j < n && a[j] == ' ') j++; // skip spaces
      while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
      while (j < n && a[j] == ' ') j++; // skip spaces
      if (j < n) a[i++] = ' '; // keep only one space
    }

    return new String(a).substring(0, i);
  }

  // reverse a[] from a[i] to a[j]
  private void reverse(char[] a, int i, int j) {
    while (i < j) {
      char t = a[i];
      a[i++] = a[j];
      a[j--] = t;
    }
  }

  public static String reverseWords2(String s) {
    StringBuilder res = new StringBuilder();
    for (int start = s.length() - 1; start >= 0; start--) {
      if (s.charAt(start) == ' ') continue;
      int end = start;
      while (start >= 0 && s.charAt(start) != ' ') start--;
      res.append(s.substring(start + 1, end + 1)).append(" ");
    }
    return res.toString().trim();
  }
}
