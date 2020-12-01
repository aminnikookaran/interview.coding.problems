package cracking.recursiondynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
  public static List<List<Integer>> getSubsets(List<Integer> set, int index) {
    List<List<Integer>> allsubsets;
    if (set.size() == index) { // Base case - add empty set
      allsubsets = new ArrayList<>();
      allsubsets.add(new ArrayList<Integer>()); // Empty set
    } else {
      allsubsets = getSubsets(set, index + 1);
      int item = set.get(index);
      List<List<Integer>> moresubsets = new ArrayList<>();
      for (List<Integer> subset : allsubsets) {
        List<Integer> newsubset = new ArrayList<Integer>();
        newsubset.addAll(subset);
        newsubset.add(item);
        moresubsets.add(newsubset);
      }
      allsubsets.addAll(moresubsets);
    }
    return allsubsets;
  }

  public static List<List<Integer>> getSubsets2(List<Integer> set) {
    List<List<Integer>> allsubsets = new ArrayList<>();
    int max = 1 << set.size(); /* Compute 2An */
    for (int k = 0; k < max; k++) {
      List<Integer> subset = convertIntToSet(k, set);
      allsubsets.add(subset);
    }
    return allsubsets;
  }

  public static List<Integer> convertIntToSet(int x, List<Integer> set) {
    List<Integer> subset = new ArrayList<Integer>();
    int index = 0;
    for (int k = x; k > 0; k >>= 1) {
      if ((k & 1) == 1) subset.add(set.get(index));
      index++;
    }
    return subset;
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    System.out.println(getSubsets2(list));
  }
}
