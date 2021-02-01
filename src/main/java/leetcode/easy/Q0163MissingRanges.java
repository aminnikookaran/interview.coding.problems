package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/missing-ranges/
public class Q0163MissingRanges {
  public static List<String> findMissingRanges1(int[] nums, int lower, int upper) {
    List<String> list = new ArrayList<>();
    int j = 0;
    boolean rangeStart = false;
    int start = 0;
    for (int i = lower; i <= upper; i++) {
      if (j < nums.length && nums[j] == i) {
        if (rangeStart) {
          if ((i - 1) != start) list.add(start + "->" + (i - 1));
          else list.add(String.valueOf(start));
          rangeStart = false;
        }
        while (j < nums.length && nums[j] == i) j++;
      } else if (!rangeStart) {
        start = i;
        rangeStart = true;
      }
      if (i == upper && rangeStart) {
        if (i != start) list.add(start + "->" + i);
        else list.add(String.valueOf(start));
        rangeStart = false;
      }
    }
    return list;
  }

  public List<String> findMissingRanges2(int[] nums, int lower, int upper) {
    List<String> result = new ArrayList<>();
    if (lower == Integer.MAX_VALUE) return result;
    int start = lower;
    for (int i = 0; i < nums.length; i++) {
      // handle duplicates, e.g., [1,1,1] lower=1 upper=1
      if (i < nums.length - 1 && nums[i] == nums[i + 1]) continue;
      if (nums[i] == start) start++;
      else {
        result.add(getRange(start, nums[i] - 1));
        if (nums[i] == Integer.MAX_VALUE) return result;
        start = nums[i] + 1;
      }
    }
    if (start <= upper) result.add(getRange(start, upper));
    return result;
  }

  private String getRange(int n1, int n2) {
    return n1 == n2 ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
  }

  public static void main(String[] args) {
    System.out.println(findMissingRanges1(new int[] {0, 1, 3, 50, 75}, 0, 99));
  }
}
