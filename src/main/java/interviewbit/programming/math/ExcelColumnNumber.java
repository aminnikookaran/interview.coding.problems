package interviewbit.programming.math;

// https://www.interviewbit.com/problems/excel-column-number/
public class ExcelColumnNumber {
  public static int titleToNumber(String A) {
    int b = 0;
    for (int i = 0; i < A.length(); i++) {
      int d = A.charAt(i) - 'A';
      b *= 26;
      b += d + 1;
    }
    return b;
  }

  public static void main(String[] args) {
    System.out.println(titleToNumber("AB"));
  }
}
