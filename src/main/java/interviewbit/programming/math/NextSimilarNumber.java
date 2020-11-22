package interviewbit.programming.math;

public class NextSimilarNumber {
  public static String solve(String A) {
    if (A.length() < 2) return "-1";
    int[] digits = new int[10];
    int currentDigit = Integer.parseInt(A.substring(A.length() - 1, A.length()));
    digits[currentDigit]++;
    int previousDigit = currentDigit;
    int i = 0;
    for (i = A.length() - 2; i >= 0; i--) {
      currentDigit = Integer.parseInt(A.substring(i, i + 1));
      digits[currentDigit]++;
      if (currentDigit < previousDigit) break;
      previousDigit = currentDigit;
    }
    if (i == -1) return "-1";
    String B = A.substring(0, i);
    for (int j = currentDigit + 1; j < 10; j++) {
      if (digits[j] > 0) {
        B += String.valueOf(j);
        digits[j]--;
        break;
      }
    }

    for (int j = 0; j < 10; j++) {
      while (digits[j] > 0) {
        B += String.valueOf(j);
        digits[j]--;
      }
    }
    return B;
  }

  public static void main(String[] args) {
    System.out.println(solve("740948"));
  }
}
