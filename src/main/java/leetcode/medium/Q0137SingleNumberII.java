package leetcode.medium;

// https://leetcode.com/problems/single-number-ii/
public class Q0137SingleNumberII {
  public int singleNumber1(int[] nums) {
    int ans = 0;
    for (int i = 0; i < 32; i++) {
      int sum = 0;
      for (int j = 0; j < nums.length; j++) if (((nums[j] >> i) & 1) == 1) sum++;
      sum %= 3;
      if (sum != 0) ans |= sum << i;
    }
    return ans;
  }

  // k = 2, p = 1, k is 2, then m = 1, we need only one 32-bit integer (x1) as the counter. And 2^m
  // = k so we do not even need a mask! A complete java program will look like:
  public int singleNumber2(int[] nums) {
    int x1 = 0, x2 = 0, mask = 0;

    for (int i : nums) {
      x2 ^= x1 & i;
      x1 ^= i;
      mask = ~(x1 & x2);
      x2 &= mask;
      x1 &= mask;
    }

    return x1; // Since p = 1, in binary form p = '01', then p1 = 1, so we should return x1.
    // If p = 2, in binary form p = '10', then p2 = 1, and we should return x2.
    // Or alternatively we can simply return (x1 | x2).
  }

  // k = 3, p = 1, k is 3, then m = 2, we need two 32-bit integers(x2, x1) as the counter. And 2^m >
  // k so we do need a mask. Write k in its binary form: k = '11', then k1 = 1, k2 = 1, so we have
  // mask = ~(x1 & x2). A complete java program will look like:
  public int singleNumber3(int[] nums) {
    int x1 = 0, x2 = 0, mask = 0;

    for (int i : nums) {
      x2 ^= x1 & i;
      x1 ^= i;
      mask = ~(x1 & x2);
      x2 &= mask;
      x1 &= mask;
    }

    return x1; // Since p = 1, in binary form p = '01', then p1 = 1, so we should return x1.
    // If p = 2, in binary form p = '10', then p2 = 1, and we should return x2.
    // Or alternatively we can simply return (x1 | x2).
  }

  // k = 5, p = 3, k is 5, then m = 3, we need three 32-bit integers(x3, x2, x1) as the counter. And
  // 2^m > k so we need a mask. Write k in its binary form: k = '101', then k1 = 1, k2 = 0, k3 = 1,
  // so we have mask = ~(x1 & ~x2 & x3). A complete java program will look like:
  public int singleNumber4(int[] nums) {
    int x1 = 0, x2 = 0, x3 = 0, mask = 0;

    for (int i : nums) {
      x3 ^= x2 & x1 & i;
      x2 ^= x1 & i;
      x1 ^= i;
      mask = ~(x1 & ~x2 & x3);
      x3 &= mask;
      x2 &= mask;
      x1 &= mask;
    }

    return x1; // Since p = 3, in binary form p = '011', then p1 = p2 = 1, so we can return either
    // x1 or x2.
    // If p = 4, in binary form p = '100', only p3 = 1, which implies we can only return x3.
    // Or alternatively we can simply return (x1 | x2 | x3).
  }
}
