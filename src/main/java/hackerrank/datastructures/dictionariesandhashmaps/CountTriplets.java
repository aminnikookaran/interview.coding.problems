package hackerrank.datastructures.dictionariesandhashmaps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.hackerrank.com/challenges/count-triplets-1/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=dictionaries-hashmaps
public class CountTriplets {
  public static long countTriplets(List<Long> arr, long r) {
    if (arr == null || arr.size() < 3) return 0;
    Map<Long, Long> map1 = new HashMap<>();
    Map<Long, Long> map2 = new HashMap<>();
    long sum = 0;
    for (Long number : arr) {
      if (number % r == 0) {
        Long number2 = number / r;
        Long count22 = map2.get(number2);
        if (count22 != null) sum += count22;

        Long count12 = map1.get(number2);
        if (count12 != null) {
          Long count21 = map2.get(number);
          map2.put(number, count21 == null ? count12 : count21 + count12);
        }
      }

      Long count11 = map1.get(number);
      map1.put(number, count11 == null ? 1 : count11 + 1);
    }
    return sum;
  }
}
