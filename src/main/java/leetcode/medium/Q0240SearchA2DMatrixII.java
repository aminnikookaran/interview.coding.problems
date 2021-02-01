package leetcode.medium;

// https://leetcode.com/problems/search-a-2d-matrix-ii/
public class Q0240SearchA2DMatrixII {
  public boolean searchMatrix1(int[][] matrix, int target) {
    return searchMatrix1(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
  }

  public boolean searchMatrix1(
      int[][] matrix, int target, int starty, int endy, int startx, int endx) {
    if (endy < starty || endx < startx) return false;
    int lefty = starty,
        leftx = startx,
        righty = starty + Math.min(endy - starty, endx - startx),
        rightx = startx + Math.min(endy - starty, endx - startx);
    while (lefty <= righty) {
      int midy = lefty + (righty - lefty) / 2;
      int midx = leftx + (rightx - leftx) / 2;
      if (matrix[midy][midx] == target) return true;
      else if (matrix[midy][midx] > target) {
        righty = midy - 1;
        rightx = midx - 1;
      } else {
        lefty = midy + 1;
        leftx = midx + 1;
      }
    }
    return searchMatrix1(matrix, target, starty, righty, leftx, endx)
        || searchMatrix1(matrix, target, lefty, endy, startx, rightx);
  }

  public boolean searchMatrix2(int[][] matrix, int target) {
    int m = matrix.length - 1;
    int n = matrix[0].length - 1;
    int i = m;
    int j = 0;
    while (i >= 0 && j <= n)
      if (target < matrix[i][j]) i--;
      else if (target > matrix[i][j]) j++;
      else return true;
    return false;
  }
}
