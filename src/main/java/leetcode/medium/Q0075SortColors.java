package leetcode.medium;

// https://leetcode.com/problems/sort-colors/
public class Q0075SortColors {
  public void sortColors1(int[] nums) {
    int i = 0, j = 0;
    while (j < nums.length) {
      if (j <= i || nums[j] != 0) j++;
      else if (nums[i] != 0) {
        nums[j] = nums[i];
        nums[i] = 0;
        i++;
        j++;
      } else i++;
    }
    i = nums.length - 1;
    j = nums.length - 1;
    while (j >= 0) {
      if (j >= i || nums[j] != 2) j--;
      else if (nums[i] != 2) {
        nums[j] = nums[i];
        nums[i] = 2;
        i--;
        j--;
      } else i--;
    }
  }

  public void sortColors2(int[] nums) {
    if (nums == null || nums.length < 2) return;
    int[] countArray = new int[3];
    for (int i = 0; i < nums.length; i++) countArray[nums[i]]++;
    int j = 0;
    int k = 0;
    while (j <= 2) {
      if (countArray[j] != 0) {
        nums[k++] = j;
        countArray[j]--;
      } else j++;
    }
  }
}
