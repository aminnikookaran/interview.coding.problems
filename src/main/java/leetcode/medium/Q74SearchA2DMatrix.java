package leetcode.medium;

// https://leetcode.com/problems/search-a-2d-matrix/
public class Q74SearchA2DMatrix {
  public boolean searchMatrix1(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0) return false;
    int left = 0, right = matrix.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (matrix[mid][0] == target) return true;
      else if (matrix[mid][0] > target) right = mid - 1;
      else left = mid + 1;
    }
    if (right == -1) return false;
    int row = right;
    left = 0;
    right = matrix[0].length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (matrix[row][mid] == target) return true;
      else if (matrix[row][mid] > target) right = mid - 1;
      else left = mid + 1;
    }
    return false;
  }

  public boolean searchMatrix2(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
    int m = matrix.length;
    int n = matrix[0].length;
    int start = 0;
    int end = m * n - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      int midX = mid / n;
      int midY = mid % n;
      if (matrix[midX][midY] == target) return true;
      if (matrix[midX][midY] < target) start = mid + 1;
      else end = mid - 1;
    }
    return false;
  }
}
