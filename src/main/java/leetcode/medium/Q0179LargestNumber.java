package leetcode.medium;

import java.util.Arrays;

// https://leetcode.com/problems/largest-number/
public class Q0179LargestNumber {
  public String largestNumber(int[] nums) {
    String[] numsString = new String[nums.length];
    for (int i = 0; i < nums.length; i++) numsString[i] = String.valueOf(nums[i]);
    Arrays.sort(numsString, (a, b) -> (b + a).compareTo(a + b));
    if (numsString[0].equals("0")) return "0";
    StringBuilder stringBuilder = new StringBuilder();
    for (String number : numsString) stringBuilder.append(number);
    return stringBuilder.toString();
  }
}
