package leetcode.easy;

import java.util.Arrays;

// https://leetcode.com/problems/relative-ranks/
public class Q0506RelativeRanks {
  public String[] findRelativeRanks1(int[] nums) {
    int[][] pair = new int[nums.length][2];
    for (int i = 0; i < nums.length; i++) {
      pair[i][0] = nums[i];
      pair[i][1] = i;
    }
    Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
    String[] result = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (i == 0) result[pair[i][1]] = "Gold Medal";
      else if (i == 1) result[pair[i][1]] = "Silver Medal";
      else if (i == 2) result[pair[i][1]] = "Bronze Medal";
      else result[pair[i][1]] = (i + 1) + "";
    }
    return result;
  }

  public String[] findRelativeRanks2(int[] nums) {
    Integer[] index = new Integer[nums.length];
    for (int i = 0; i < nums.length; i++) index[i] = i;
    Arrays.sort(index, (a, b) -> Integer.compare(nums[b], nums[a]));
    String[] result = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (i == 0) result[index[i]] = "Gold Medal";
      else if (i == 1) result[index[i]] = "Silver Medal";
      else if (i == 2) result[index[i]] = "Bronze Medal";
      else result[index[i]] = (i + 1) + "";
    }
    return result;
  }

  public String[] findRelativeRanks3(int[] nums) {
    String[] result = new String[nums.length];
    int max = 0;
    for (int i : nums) if (i > max) max = i;
    int[] hash = new int[max + 1];
    for (int i = 0; i < nums.length; i++) hash[nums[i]] = i + 1;
    int place = 1;
    for (int i = hash.length - 1; i >= 0; i--) {
      if (hash[i] != 0) {
        if (place == 1) result[hash[i] - 1] = "Gold Medal";
        else if (place == 2) result[hash[i] - 1] = "Silver Medal";
        else if (place == 3) result[hash[i] - 1] = "Bronze Medal";
        else result[hash[i] - 1] = String.valueOf(place);
        place++;
      }
    }
    return result;
  }
}
