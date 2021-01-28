package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/queue-reconstruction-by-height/
public class Q0406QueueReconstructionByHeight {
  public int[][] reconstructQueue1(int[][] people) {
    Arrays.sort(
        people, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0]));
    List<int[]> list = new LinkedList<>();
    for (int[] p : people) list.add(p[1], p);
    return list.toArray(new int[list.size()][]);
  }

  public int[][] reconstructQueue2(int[][] people) {
    Arrays.sort(
        people, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < people.length; i++) list.add(i);
    int[][] res = new int[people.length][2];
    for (int i = 0; i < people.length; i++) {
      int index = list.get(people[i][1]);
      res[index][0] = people[i][0];
      res[index][1] = people[i][1];
      list.remove(people[i][1]);
    }
    return res;
  }
}
