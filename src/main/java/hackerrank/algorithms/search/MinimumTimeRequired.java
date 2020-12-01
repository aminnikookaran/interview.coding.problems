package hackerrank.algorithms.search;

import java.util.Arrays;

// https://www.hackerrank.com/challenges/minimum-time-required/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=search
public class MinimumTimeRequired {
  public static long minTime1(long[] machines, long goal) {
    long count = 0;
    Arrays.sort(machines);
    int day = 0;
    while (count < goal) {
      day++;
      for (int i = 0; i < machines.length; i++) {
        if (day < machines[i]) break;
        if (day % machines[i] == 0) count++;
        if (count == goal) break;
      }
    }
    return day;
  }

  public static long minTime2(long[] machines, long goal) {
    Arrays.sort(machines);
    long low = goal * machines[0] / machines.length;
    long high = goal * machines[machines.length - 1] / machines.length;
    while (low < high) {
      long mid = (low + high) / 2;
      long count = 0;
      for (long i : machines) count += mid / i;
      if (count < goal) low = mid + 1;
      else high = mid;
    }
    return low;
  }

  public static void main(String[] args) {
    System.out.println(minTime2(new long[] {1, 3, 4}, 10));
  }
}
