package leetcode.medium;

// https://leetcode.com/problems/container-with-most-water/
public class Q0011ContainerWithMostWater {
  public int maxArea(int[] height) {
    int max = 0, i = 0, j = height.length - 1;
    while (i < j) {
      max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
      if (height[i] < height[j]) i++;
      else j--;
    }
    return max;
  }
}
