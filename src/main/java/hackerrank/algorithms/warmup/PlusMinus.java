package hackerrank.algorithms.warmup;

// https://www.hackerrank.com/challenges/plus-minus/problem
public class PlusMinus {
  public static void plusMinus(int[] arr) {
    float positives = 0;
    float negatives = 0;
    float zeros = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > 0) positives++;
      else if (arr[i] < 0) negatives++;
      else zeros++;
    }
    System.out.format("%.6f\n", positives / arr.length);
    System.out.format("%.6f\n", negatives / arr.length);
    System.out.format("%.6f\n", zeros / arr.length);
  }

  public static void main(String[] args) {
    plusMinus(new int[] {-4, 3, -9, 0, 4, 1});
  }
}
