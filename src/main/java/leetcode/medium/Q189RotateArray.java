package leetcode.medium;

// https://leetcode.com/problems/rotate-array/
public class Q189RotateArray {
  public void rotate(int[] nums, int k) {
    int startIndex = -1, currIndex = -1, pre = 0;
    for (int i = 0; i < nums.length; ++i) {
      if (startIndex == currIndex) {
        startIndex++;
        pre = nums[startIndex];
        currIndex = startIndex;
      }
      currIndex = (currIndex + k) % nums.length;
      int temp = nums[currIndex];
      nums[currIndex] = pre;
      pre = temp;
    }
  }

  public void rotate2(int[] nums, int k) {
    int[] a = new int[nums.length];
    for (int i = 0; i < nums.length; i++) a[(i + k) % nums.length] = nums[i];
    for (int i = 0; i < nums.length; i++) nums[i] = a[i];
  }

  public void rotate3(int[] nums, int k) {
    k = k % nums.length;
    int count = 0;
    for (int start = 0; count < nums.length; start++) {
      int current = start;
      int prev = nums[start];
      do {
        int next = (current + k) % nums.length;
        int temp = nums[next];
        nums[next] = prev;
        prev = temp;
        current = next;
        count++;
      } while (start != current);
    }
  }

  public void rotate4(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  public void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  public void rotate5(int nums[], int d) {
    d %= nums.length;
    int g_c_d = gcd(d, nums.length);
    for (int i = 0; i < g_c_d; i++) {
      int temp = nums[i];
      int j = i;
      while (true) {
        int k = j - d;
        if (k < nums.length) k += nums.length;
        if (k == i) break;
        nums[k] = nums[j];
        j = k;
      }
      nums[j] = temp;
    }
  }

  public int gcd(int a, int b) {
    if (b == 0) return a;
    else return gcd(b, a % b);
  }
}
