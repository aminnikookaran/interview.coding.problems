package leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/missing-number/
public class Q0268MissingNumber {
  public int missingNumber1(int[] nums) {
    int x = nums.length;
    for (int i = 0; i < nums.length; i++) x ^= i ^ nums[i];
    return x;
  }

  public int missingNumber2(int[] nums) {
    Arrays.sort(nums);
    if (nums[nums.length - 1] != nums.length) return nums.length;
    else if (nums[0] != 0) return 0;
    for (int i = 1; i < nums.length; i++) {
      int expectedNum = nums[i - 1] + 1;
      if (nums[i] != expectedNum) return expectedNum;
    }
    return -1;
  }

  public int missingNumber3(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) numSet.add(num);
    int expectedNumCount = nums.length + 1;
    for (int number = 0; number < expectedNumCount; number++)
      if (!numSet.contains(number)) return number;
    return -1;
  }

  public int missingNumber4(int[] nums) {
    int expectedSum = nums.length * (nums.length + 1) / 2;
    int actualSum = 0;
    for (int num : nums) actualSum += num;
    return expectedSum - actualSum;
  }
}
