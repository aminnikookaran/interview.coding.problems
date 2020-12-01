package hackerrank.algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.hackerrank.com/challenges/luck-balance/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=greedy-algorithms
public class LuckBalance {
  public static int luckBalance(int k, int[][] contests) {
    List<Integer> lucks = new ArrayList<>();
    int sum = 0;
    for (int i = 0; i < contests.length; i++) {
      sum += contests[i][0];
      if (contests[i][1] == 1) lucks.add(contests[i][0]);
    }
    Collections.sort(lucks);
    for (int i = 0; i < (lucks.size() - k); i++) sum -= (2 * lucks.get(i));
    return sum;
  }
}
