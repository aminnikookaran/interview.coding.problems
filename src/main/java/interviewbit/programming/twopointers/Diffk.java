package interviewbit.programming.twopointers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://www.interviewbit.com/problems/diffk/
public class Diffk {
  public static int diffPossible1(List<Integer> A, int B) {
    int i = 0, j = 1;
    while (j < A.size() && i < A.size()) {
      int diff = A.get(j) - A.get(i);
      if (diff == B && i != j) return 1;
      if (A.get(j) - A.get(i) < B) j++;
      else i++;
    }
    return 0;
  }

  public static int diffPossible2(ArrayList<Integer> a, int b) {
    LinkedList<Integer> seen = new LinkedList<Integer>();
    for (int i = 0; i < a.size(); i++) {
      int n = a.get(i);
      int lookFor = n - b;
      if (!seen.isEmpty()) {
        int first = seen.getFirst();
        while (first < lookFor) {
          seen.removeFirst();
          if (seen.isEmpty()) break;
          first = seen.getFirst();
        }
        if (first == lookFor) return 1;
      }
      seen.addLast(n);
    }
    return 0;
  }
}
