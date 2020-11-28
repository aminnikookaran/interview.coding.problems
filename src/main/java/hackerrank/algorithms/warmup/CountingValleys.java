package hackerrank.algorithms.warmup;

// https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=warmup
public class CountingValleys {
  public static int countingValleys(int steps, String path) {
    int valleys = 0;
    int height = 0;
    for (int i = 0; i < steps; i++) {
      int currentStep = 0;
      if (path.charAt(i) == 'U') currentStep = 1;
      else currentStep = -1;
      if (height == -1 && currentStep == 1) valleys++;
      height += currentStep;
    }
    return valleys;
  }
}
