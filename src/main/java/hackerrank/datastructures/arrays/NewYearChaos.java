package hackerrank.datastructures.arrays;

// https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=arrays
public class NewYearChaos {
  public static void minimumBribes(int[] q) {
    boolean chaotic = false;
    int sum = 0;
    for (int i = 0; i < q.length; i++) {
      if (q[i] - i > 3) {
        chaotic = true;
        break;
      }
      for (int j = Math.max(0, q[i] - 2); j < i; j++) if (q[j] > q[i]) sum++;
    }
    if (chaotic) System.out.println("Too chaotic");
    else System.out.println(sum);
  }
}
