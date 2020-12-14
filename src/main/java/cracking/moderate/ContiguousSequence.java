package cracking.moderate;

public class ContiguousSequence {
  int getMaxSum(int[] a) {
    int maxsum = 0;
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
      if (maxsum < sum) maxsum = sum;
      else if (sum < 0) sum = a[i];
    }
    return maxsum;
  }
}
