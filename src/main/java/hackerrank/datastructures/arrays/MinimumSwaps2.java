package hackerrank.datastructures.arrays;

// https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=arrays
public class MinimumSwaps2 {
  static int minimumSwaps(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != i + 1) {
        int temp = arr[arr[i] - 1];
        arr[arr[i] - 1] = arr[i];
        arr[i] = temp;
        sum++;
        i--;
      }
    }
    return sum;
  }
}
