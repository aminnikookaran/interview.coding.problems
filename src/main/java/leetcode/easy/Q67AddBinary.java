package leetcode.easy;

// https://leetcode.com/problems/add-binary/
public class Q67AddBinary {
  public String addBinary1(String a, String b) {
    StringBuilder stringBuilder = new StringBuilder();
    int carry = 0;
    int m = a.length() - 1;
    int n = b.length() - 1;
    int k = Math.min(m, n);
    for (int i = 0; i <= k; i++) {
      int sum = (a.charAt(m - i) - '0') + (b.charAt(n - i) - '0') + carry;
      carry = sum / 2;
      sum %= 2;
      stringBuilder.insert(0, sum);
    }
    for (int i = k + 1; i <= m; i++) {
      int sum = (a.charAt(m - i) - '0') + carry;
      carry = sum / 2;
      sum %= 2;
      stringBuilder.insert(0, sum);
    }
    for (int i = k + 1; i <= n; i++) {
      int sum = (b.charAt(n - i) - '0') + carry;
      carry = sum / 2;
      sum %= 2;
      stringBuilder.insert(0, sum);
    }
    if (carry == 1) stringBuilder.insert(0, carry);
    return stringBuilder.toString();
  }

  public String addBinary2(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;
    while (i >= 0 || j >= 0) {
      int sum = carry;
      if (i >= 0 && a.charAt(i) == '1') sum++;
      if (j >= 0 && b.charAt(j) == '1') sum++;
      carry = sum / 2;
      sb.insert(0, sum % 2);
      i--;
      j--;
    }
    if (carry == 1) sb.insert(0, '1');
    return sb.toString();
  }
}
