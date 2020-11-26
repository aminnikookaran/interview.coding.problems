package interviewbit.programming.twopointers;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays {
  public static List<Integer> intersect(final List<Integer> A, final List<Integer> B) {
    List<Integer> output = new ArrayList<Integer>();
    int i = 0;
    int j = 0;
    while (i < A.size() && j < B.size()) {
      if (A.get(i).equals(B.get(j))) {
        output.add(A.get(i));
        i++;
        j++;
      } else if (A.get(i) > B.get(j)) j++;
      else i++;
    }
    return output;
  }
}
