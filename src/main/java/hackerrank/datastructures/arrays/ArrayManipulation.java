package hackerrank.datastructures.arrays;

// https://www.hackerrank.com/challenges/crush/problem
public class ArrayManipulation {
  public static long arrayManipulation(int n, int[][] queries) {
    long max = Long.MIN_VALUE;
    long[] arr = new long[n];
    for (int i = 0; i < queries.length; i++) {
      arr[queries[i][0] - 1] += queries[i][2];
      if (queries[i][1] < n) arr[queries[i][1]] -= queries[i][2];
    }
    long sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
      if (sum > max) max = sum;
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(arrayManipulation(5, new int[][] {{1, 2, 100}, {2, 5, 100}, {3, 4, 100}}));
  }
}
