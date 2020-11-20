package problems.arrays;

public class TwoDArrayDSProblem {
  public static int hourglassSum(int[][] arr) {
    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        int sum = 0;
        sum += arr[i][j];
        sum += arr[i][j + 1];
        sum += arr[i][j + 2];

        sum += arr[i + 1][j + 1];

        sum += arr[i + 2][j];
        sum += arr[i + 2][j + 1];
        sum += arr[i + 2][j + 2];
        if (sum > maxSum) maxSum = sum;
      }
    }
    return maxSum;
  }

  public static void main(String[] args) {
    System.out.println(
        hourglassSum(
            new int[][] {
              {1, 1, 1, 0, 0, 0},
              {0, 1, 0, 0, 0, 0},
              {1, 1, 1, 0, 0, 0},
              {0, 0, 2, 4, 4, 0},
              {0, 0, 0, 2, 0, 0},
              {0, 0, 1, 2, 4, 0}
            }));
  }
}
