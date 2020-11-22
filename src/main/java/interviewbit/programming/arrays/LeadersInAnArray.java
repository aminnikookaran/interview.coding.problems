package interviewbit.programming.arrays;

import java.util.ArrayList;
import java.util.List;

// https://www.interviewbit.com/problems/leaders-in-an-array/
public class LeadersInAnArray {
  public static List<Integer> solve(List<Integer> A) {
    List<Integer> list = new ArrayList<>();
    int max = A.get(A.size() - 1);
    list.add(max);
    for (int i = A.size() - 2; i >= 0; i--) {
      if (A.get(i) > max) {
        max = A.get(i);
        list.add(max);
      }
    }
    return list;
  }

  public static void main(String[] args) {}
}
