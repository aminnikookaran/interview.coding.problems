package leetcode.easy;

// https://leetcode.com/problems/number-of-segments-in-a-string/
public class Q0434NumberOfSegmentsInAString {
  public int countSegments1(String s) {
    String trimmed = s.trim();
    if (trimmed.equals("")) return 0;
    return trimmed.split("\\s+").length;
  }

  public int countSegments2(String s) {
    int segmentCount = 0;
    for (int i = 0; i < s.length(); i++)
      if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') segmentCount++;
    return segmentCount;
  }
}
