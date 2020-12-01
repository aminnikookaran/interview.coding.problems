package hackerrank.algorithms.search;

import java.util.HashMap;
import java.util.Map;

// https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=search
public class HashTablesIceCreamParlor {
  static void whatFlavors(int[] cost, int money) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < cost.length; i++) {
      if (cost[i] < money) {
        Integer index = map.get(money - cost[i]);
        if (index != null) {
          System.out.println(String.valueOf(index) + " " + String.valueOf(i + 1));
          return;
        }
        if (!map.containsKey(cost[i])) map.put(cost[i], i + 1);
      }
    }
  }
}
