package leetcode.easy;

// https://leetcode.com/problems/license-key-formatting/
public class Q0482LicenseKeyFormatting {
  public String licenseKeyFormatting1(String s, int k) {
    StringBuilder sb = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--)
      if (s.charAt(i) != '-') sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
    return sb.reverse().toString().toUpperCase();
  }

  public String licenseKeyFormatting2(String s, int k) {
    StringBuilder sb = new StringBuilder();
    int counter = 0;
    for (int i = s.length() - 1; i >= 0; --i) {
      if (s.charAt(i) == '-') continue;
      sb.append(s.charAt(i));
      counter++;
      if (counter % k == 0 && i != 0) sb.append("-");
    }
    return sb.reverse().toString().toUpperCase();
  }
}
