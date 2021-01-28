package leetcode.medium;

// https://leetcode.com/problems/sentence-screen-fitting/
public class Q0418SentenceScreenFitting {
  public int wordsTyping1(String[] sentence, int rows, int cols) {
    int i = 0;
    int cnt = 0;
    int k = 0; // kth word
    int colLen = cols;
    while (i < rows) {
      String sen = sentence[k++];
      if (sen.length() > cols) return 0;
      if (colLen >= sen.length()) colLen = colLen - sen.length() - 1;
      else {
        i++;
        colLen = cols;
        colLen = colLen - sen.length() - 1;
      }
      if (i >= rows) return cnt;
      if (k == sentence.length) {
        cnt++;
        k = 0;
      }
    }
    return cnt;
  }

  public int wordsTyping2(String[] sentence, int rows, int cols) {
    StringBuilder str = new StringBuilder();
    for (String s : sentence) {
      s = s + " ";
      str.append(s);
    }

    int start = 0;
    for (int i = 0; i < rows; i++) {
      start = start + cols;
      if (str.charAt(start % str.length()) == ' ') start++;
      else while (start > 0 && str.charAt((start - 1) % str.length()) != ' ') start--;
    }
    return start / str.length();
  }
}
