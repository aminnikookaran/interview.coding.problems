package hackerrank.algorithms.warmup;

// https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=warmup
public class JumpingOnTheClouds {
  public static int jumpingOnClouds(int[] c) {
    if (c == null || c.length == 1) return 0;
    int jumps = 0;
    int i = 0;
    while (i < c.length - 3) {
      if (c[i + 2] == 0) i++;
      i++;
      jumps++;
    }
    jumps++;
    return jumps;
  }
}
