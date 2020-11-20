package problems.strings;

public class ReversetheStringProblem {
  public static String solve1(String A) {
    StringBuilder stringBuilder = new StringBuilder();
    int i = A.length() - 1;
    int end = i;
    boolean word = false;
    while (i >= 0) {
      if (A.charAt(i) != ' ' && !word) {
        word = true;
        end = i;
      } else if (A.charAt(i) == ' ' && word) {
        word = false;
        stringBuilder.append(A.substring(i + 1, end + 1)).append(' ');
      }
      i--;
    }
    if (word) stringBuilder.append(A.substring(0, end + 1)).append(' ');
    return stringBuilder.toString().trim();
  }

  public static String solve2(String a) {
    String[] words = a.split(" ");
    String res = "";
    for (int i = words.length - 1; i >= 0; i--) {
      res += words[i];
      if (words[i].length() > 0) res += " ";
    }
    return res.substring(0, res.length() - 1);
  }

  public static void main(String[] args) {
    System.out.println(solve1("the sky is blue"));
  }
}
