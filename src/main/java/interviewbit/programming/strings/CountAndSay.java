package interviewbit.programming.strings;

// https://www.interviewbit.com/problems/count-and-say/
public class CountAndSay {
  public static String countAndSay(int A) {
    if (A < 1) return "";
    String start = "1";
    if (A == 1) return start;
    StringBuilder end = null;
    for (int i = 2; i <= A; i++) {
      end = new StringBuilder();
      char lastChar = start.charAt(0);
      int count = 1;
      for (int j = 1; j < start.length(); j++) {
        if (start.charAt(j) == lastChar) count++;
        else {
          end.append(count).append(lastChar);
          lastChar = start.charAt(j);
          count = 1;
        }
      }
      end.append(count).append(lastChar);
      start = end.toString();
    }
    return end.toString();
  }

  public static void main(String[] args) {
    System.out.println(countAndSay(1));
  }
}
