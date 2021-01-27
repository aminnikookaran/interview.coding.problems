package leetcode.medium;

// https://leetcode.com/problems/sort-transformed-array/
public class Q0360SortTransformedArray {
  public int[] sortTransformedArray1(int[] nums, int a, int b, int c) {
    if (nums == null || nums.length == 0) return nums;
    if (nums.length == 1) {
      nums[0] = eval(nums[0], a, b, c);
      return nums;
    }

    int l = 0;
    int r = nums.length - 1;
    int[] res = new int[nums.length];
    int k = 0;
    while (l <= r) { // need to equal to get the final number.
      int v1 = eval(nums[l], a, b, c);
      int v2 = eval(nums[r], a, b, c);

      if (a > 0) {
        if (v1 > v2) {
          res[k] = v1;
          l++;
        } else {
          res[k] = v2;
          r--;
        }
      } else {
        if (v1 > v2) {
          res[k] = v2;
          r--;
        } else {
          res[k] = v1;
          l++;
        }
      }
      k++;
    }

    if (a > 0) {
      int left = 0;
      int right = res.length - 1;
      while (left < right) {
        int tmp = res[left];
        res[left] = res[right];
        res[right] = tmp;
        left++;
        right--;
      }
    }

    return res;
  }

  private int eval(int n, int a, int b, int c) {
    return a * n * n + b * n + c;
  }

  public int[] sortTransformedArray2(int[] nums, int a, int b, int c) {
    if (nums == null || nums.length <= 1) return nums;

    int[] res = new int[nums.length];
    if (a > 0) {
      int k = res.length - 1;
      int l = 0, r = k;
      while (k >= 0) {
        int tl = eval(nums[l], a, b, c);
        int tr = eval(nums[r], a, b, c);

        if (tl > tr) {
          res[k] = tl;
          l++;
        } else {
          res[k] = tr;
          r--;
        }
        k--;
      }
    } else if (a < 0) {
      int k = 0;
      int l = 0, r = res.length - 1;
      while (k < nums.length) {
        int tl = eval(nums[l], a, b, c);
        int tr = eval(nums[r], a, b, c);

        if (tl < tr) {
          res[k] = tl;
          l++;
        } else {
          res[k] = tr;
          r--;
        }
        k++;
      }
    } else {
      for (int i = 0; i < res.length; i++) res[i] = eval(nums[i], 0, b, c);
      if (b < 0) {
        int l = 0, r = res.length - 1;
        while (l < r) {
          int tmp = res[l];
          res[l] = res[r];
          res[r] = tmp;
          l++;
          r--;
        }
      }
    }

    return res;
  }
}
