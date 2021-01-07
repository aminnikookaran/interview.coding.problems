package leetcode.medium;

// https://leetcode.com/problems/compare-version-numbers/
public class Q0165CompareVersionNumbers {
  public int compareVersion1(String version1, String version2) {
    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");
    for (int i = 0; i < v1.length || i < v2.length; i++) {
      int ver1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
      int ver2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
      if (ver1 > ver2) return 1;
      if (ver1 < ver2) return -1;
    }
    return 0;
  }

  public int compareVersion2(String version1, String version2) {
    int num1 = 0, num2 = 0;
    int len1 = version1.length(), len2 = version2.length();
    int i = 0, j = 0;
    while (i < len1 || j < len2) {
      while (i < len1 && version1.charAt(i) != '.') num1 = num1 * 10 + version1.charAt(i++) - '0';
      while (j < len2 && version2.charAt(j) != '.') num2 = num2 * 10 + version2.charAt(j++) - '0';
      if (num1 > num2) return 1;
      if (num1 < num2) return -1;
      num1 = 0;
      num2 = 0;
      i++;
      j++;
    }
    return 0;
  }
}
