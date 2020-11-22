package interviewbit.programming.arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://www.interviewbit.com/problems/find-duplicate-in-array/
public class FindDuplicateInArray {
  public static int repeatedNumber(final List<Integer> A) {
    Set<Integer> set = new HashSet<>();
    for (Integer integer : A) {
      if (set.contains(integer)) return integer;
      set.add(integer);
    }
    return -1;
  }

  public static void main(String[] args) {}
}
