package problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicArrayProblem {
  public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    List<List<Integer>> lists = new ArrayList<>();
    for (int i = 0; i < n; i++) lists.add(new ArrayList<>());
    List<Integer> result = new ArrayList<>();

    int lastAnswer = 0;
    for (int i = 0; i < queries.size(); i++) {
      List<Integer> query = queries.get(i);
      int seq = (query.get(1) ^ lastAnswer) % n;
      if (query.get(0) == 1) {
        lists.get(seq).add(query.get(2));
      } else {
        lastAnswer = lists.get(seq).get(query.get(2) % lists.get(seq).size());
        result.add(lastAnswer);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Integer[][] queriesArray =
        new Integer[][] {{1, 0, 5}, {1, 1, 7}, {1, 0, 3}, {2, 1, 0}, {2, 1, 1}};
    List<List<Integer>> queries = new ArrayList<>();
    for (Integer[] query : queriesArray) queries.add(Arrays.asList(query));
    List<Integer> results = dynamicArray(2, queries);
    for (Integer result : results) System.out.println(result);
  }
}
