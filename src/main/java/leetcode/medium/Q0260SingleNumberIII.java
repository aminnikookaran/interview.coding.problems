package leetcode.medium;

// https://leetcode.com/problems/single-number-iii/
public class Q0260SingleNumberIII {
  public int[] singleNumber(int[] nums) {
    int diff = 0;
    for (int num : nums) diff ^= num;
    diff &= -diff;
    //    diff &= ~(diff - 1);

    int[] rets = {0, 0};
    for (int num : nums) {
      if ((num & diff) == 0) rets[0] ^= num;
      else rets[1] ^= num;
    }
    return rets;
  }
}
