package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/largest-number/
public class Q179LargestNumber {
  public String largestNumber(int[] nums) {
    String[] numsString = new String[nums.length];
    for (int i = 0; i < nums.length; i++) numsString[i] = String.valueOf(nums[i]);
    Arrays.sort(numsString, (a, b) -> (b + a).compareTo(a + b));
    if (numsString[0].equals("0")) return "0";
    StringBuilder stringBuilder = new StringBuilder();
    for (String number : numsString) stringBuilder.append(number);
    return stringBuilder.toString();
  }

  private class LargerNumberComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
      String order1 = a + b;
      String order2 = b + a;
      return order2.compareTo(order1);
    }
  }

  public String largestNumber2(int[] nums) {
    // Get input integers as strings.
    String[] asStrs = new String[nums.length];
    for (int i = 0; i < nums.length; i++) asStrs[i] = String.valueOf(nums[i]);

    // Sort strings according to custom comparator.
    Arrays.sort(asStrs, new LargerNumberComparator());

    // If, after being sorted, the largest number is `0`, the entire number
    // is zero.
    if (asStrs[0].equals("0")) return "0";

    // Build largest number from sorted array.
    String largestNumberStr = new String();
    for (String numAsStr : asStrs) largestNumberStr += numAsStr;

    return largestNumberStr;
  }

  public String largestNumber3(int[] nums) {
    String[] arr = new String[nums.length];
    for (int i = 0; i < nums.length; i++) arr[i] = String.valueOf(nums[i]);
    Arrays.sort(
        arr,
        new Comparator<String>() {
          public int compare(String a, String b) {
            return (b + a).compareTo(a + b);
          }
        });
    StringBuilder sb = new StringBuilder();
    for (String s : arr) sb.append(s);
    while (sb.charAt(0) == '0' && sb.length() > 1) sb.deleteCharAt(0);
    return sb.toString();
  }
}
