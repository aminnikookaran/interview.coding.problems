package interviewbit.programming.math;

// https://www.interviewbit.com/problems/next-similar-number/
public class NextSimilarNumber {
  public static String solve1(String A) {
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

  public static String solve2(String A) {
    char[] a = A.toCharArray();
    int i = a.length - 2;
    while (i >= 0 && a[i] >= a[i + 1]) i--;
    if (i == -1) return "-1";
    int j = a.length - 1;
    while (j >= 0 && a[j] <= a[i]) j--;
    char temp = a[i];
    a[i] = a[j];
    a[j] = temp;
    int start = i + 1;
    int end = a.length - 1;
    while (start < end) {
      temp = a[start];
      a[start++] = a[end];
      a[end--] = temp;
    }
    return new String(a);
  }

  public static void main(String[] args) {
    System.out.println(solve1("742321"));
  }
}
