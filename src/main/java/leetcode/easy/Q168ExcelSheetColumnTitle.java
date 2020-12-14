package leetcode.easy;

// https://leetcode.com/problems/excel-sheet-column-title/
public class Q168ExcelSheetColumnTitle {
  public String convertToTitle(int n) {
    StringBuilder stringBuilder = new StringBuilder();
    while (n > 0) {
      n--;
      stringBuilder.insert(0, (char) ('A' + (n % 26)));
      n /= 26;
    }
    return stringBuilder.toString();
  }
}
